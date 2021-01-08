package comands;

import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

import graphics2D.elements.PageSlot;
import graphics2D.elements.RectangleElement;
import graphics2D.elements.TriangleElement;
import graphics2D.painters.CirclePainter;
import graphics2D.painters.RectanglePainter;
import graphics2D.painters.SlotPainter;
import graphics2D.painters.TrianglePainter;
import rightPanelView.PageView;
import workspace.model.Page;

public class RotateCommand extends AbstractCommand{

	private Page page;
	private ArrayList<PageSlot> slotovi;
	private ArrayList<Double> angles;
	private ArrayList<Double> ogAngles;
	private PageView pv;
	
	public RotateCommand(Page page, PageView pv) {
		this.page = page;
		this.pv = pv;
		slotovi = new ArrayList<PageSlot>(page.getSelectedElements().getSelectionList());
		angles = new ArrayList<Double>();
		ogAngles = new ArrayList<Double>();
		for(PageSlot s: slotovi) {
			ogAngles.add(s.getOriginalAngle());
		}
	}
	
	@Override
	public void doCommand() {
		if(!page.getSelectedElements().getSelectionList().isEmpty()) {
			for(int i = 0; i <slotovi.size(); i++) {
				PageSlot slot = slotovi.get(i);
				((SlotPainter)slot.getElementPainter()).setOriginalShape(((SlotPainter)slot.getElementPainter()).getShape());
				slot.setOriginalAngle(slot.getOriginalAngle() + slot.getAngle());
				angles.add(slot.getAngle());
				slot.setAngle(angles.get(i));

				if(slot instanceof RectangleElement) 
					slot.setElementPainter(new RectanglePainter(slot));
				else if(slot instanceof TriangleElement) 
					slot.setElementPainter(new TrianglePainter(slot));
				else
					slot.setElementPainter(new CirclePainter(slot));
				
				
				pv.repaint();
			}
		}
	}

	@Override
	public void undoCommand() {
		
		for(int i = 0; i < slotovi.size(); i++) {
			PageSlot s = slotovi.get(i);
			s.setAngle(ogAngles.get(i));
			s.setOriginalAngle(s.getAngle());
			if(s instanceof RectangleElement) 
				s.setElementPainter(new RectanglePainter(s));
			else if(s instanceof TriangleElement) 
				s.setElementPainter(new TrianglePainter(s));
			else
				s.setElementPainter(new CirclePainter(s));
			System.out.println(s.getPosition().toString());
			
			
			pv.repaint();
			
		}
	}

}
