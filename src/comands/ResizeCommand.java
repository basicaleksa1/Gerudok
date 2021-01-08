package comands;

import java.awt.Dimension;
import java.util.ArrayList;

import graphics2D.elements.PageSlot;
import graphics2D.elements.RectangleElement;
import graphics2D.elements.TriangleElement;
import graphics2D.painters.CirclePainter;
import graphics2D.painters.RectanglePainter;
import graphics2D.painters.TrianglePainter;
import rightPanelView.PageView;
import workspace.model.Page;

public class ResizeCommand extends AbstractCommand{

	private Page page;
	private ArrayList<PageSlot> slotovi;
	private ArrayList<Dimension> ogDimenzije;
	private ArrayList<Dimension> dimenzije;
	private PageView pv;
	
	public ResizeCommand(Page page, PageView pv) {
		this.page = page;
		this.pv = pv;
		slotovi = new ArrayList<PageSlot>(page.getSelectedElements().getSelectionList());
		ogDimenzije = new ArrayList<Dimension>();
		dimenzije = new ArrayList<Dimension>();
		for(PageSlot s: slotovi) {
			ogDimenzije.add(s.getOriginalSize());
		}
	}
	
	@Override
	public void doCommand() {
		for(int i = 0; i <slotovi.size(); i++) {
			PageSlot s = slotovi.get(i);
			s.setOriginalSize(s.getSize());
			dimenzije.add(s.getSize());
			s.setSize(dimenzije.get(i));
			if(s instanceof RectangleElement) 
				s.setElementPainter(new RectanglePainter(s));
			else if(s instanceof TriangleElement) 
				s.setElementPainter(new TrianglePainter(s));
			else
				s.setElementPainter(new CirclePainter(s));
			
			
			pv.repaint();
		}
		
	}

	@Override
	public void undoCommand() {
		for(int i = 0; i < slotovi.size(); i++) {
			PageSlot s = slotovi.get(i);
			
			s.setSize(ogDimenzije.get(i));
			s.setOriginalSize(s.getSize());
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
