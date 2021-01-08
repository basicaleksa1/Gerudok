package comands;

import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

import app.MainFrame;
import graphics2D.elements.PageSlot;
import rightPanelView.DocumentView;
import rightPanelView.PageView;
import rightPanelView.ProjectView;
import graphics2D.elements.RectangleElement;
import graphics2D.elements.TriangleElement;
import graphics2D.painters.CirclePainter;
import graphics2D.painters.RectanglePainter;
import graphics2D.painters.SlotPainter;
import graphics2D.painters.TrianglePainter;
import rightPanelView.PageView;
import workspace.model.Page;

public class MoveCommand extends AbstractCommand{

	private Page page;
	private ArrayList<PageSlot> slotovi;
	private ArrayList<Point> ogPoints;
	private ArrayList<Point> points;
	private PageView pv;
	
	public MoveCommand(Page page, PageView pv) {
		this.page = page;
		this.pv = pv;
		slotovi = new ArrayList<PageSlot>(page.getSelectedElements().getSelectionList());
		ogPoints = new ArrayList<Point>();
		points = new ArrayList<Point>();
		for(PageSlot p: slotovi) {
			ogPoints.add(p.getOriginalPosition());
		}
	}
	
	
	@Override
	public void doCommand() {
		for(int i = 0; i < slotovi.size();i ++) {
			PageSlot s = slotovi.get(i);
			s.setOriginalPosition(s.getPosition());
			points.add(s.getPosition());
			s.setPosition(points.get(i));
			if(s instanceof RectangleElement) 
				s.setElementPainter(new RectanglePainter(s));
			else if(s instanceof TriangleElement) 
				s.setElementPainter(new TrianglePainter(s));
			else
				s.setElementPainter(new CirclePainter(s));
			
			AffineTransform transform = new AffineTransform();
			transform.rotate(Math.toRadians(s.getOriginalAngle()), s.getPosition().getX(), s.getPosition().getY());
			((SlotPainter)s.getElementPainter()).setShape(transform.createTransformedShape(((SlotPainter)s.getElementPainter()).getOriginalShape()));
		
			pv.repaint();

		}
	}

	@Override
	public void undoCommand() {
		for(int i = 0; i < slotovi.size(); i++) {	
			PageSlot s = slotovi.get(i);
		
			s.setPosition(ogPoints.get(i));
			s.setOriginalPosition(s.getPosition());
			if(s instanceof RectangleElement) 
				s.setElementPainter(new RectanglePainter(s));
			else if(s instanceof TriangleElement) 
				s.setElementPainter(new TrianglePainter(s));
			else
				s.setElementPainter(new CirclePainter(s));
			System.out.println(s.getPosition().toString());
			
			AffineTransform transform = new AffineTransform();
			transform.rotate(Math.toRadians(s.getOriginalAngle()), s.getPosition().getX(), s.getPosition().getY());
			((SlotPainter)s.getElementPainter()).setShape(transform.createTransformedShape(((SlotPainter)s.getElementPainter()).getOriginalShape()));

			pv.repaint();
		}

	}

	
}
