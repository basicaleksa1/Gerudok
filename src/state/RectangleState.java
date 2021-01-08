package state;

import java.awt.Dimension;
import java.awt.Point;

import app.MainFrame;
import comands.AddCommand;
import graphics2D.elements.PageElement;
import graphics2D.elements.PageSlot;
import graphics2D.elements.RectangleElement;
import rightPanelView.DocumentView;
import rightPanelView.PageView;
import rightPanelView.ProjectView;
import workspace.model.Page;


public class RectangleState implements IState {

	@Override
	public void mousePressed(Point point, Page page, Point currentPoint) {	
//		for(PageSlot slot: page.getSlotovi()) {
//			if(slot.getElementPainter().elementAt(point, slot))
//				return;
//		}
//		RectangleElement rec = new RectangleElement(new Dimension(100, 70), point);
//		rec.setName("Element " + page.getSlotovi().size());
//		page.addSlot(rec);
		PageSlot sloto = null;
		for(PageSlot slot: page.getSlotovi()) {
			if(slot.getElementPainter().elementAt(point, slot)) {
				sloto = slot;
				break;
			}
		}
		
		((PageView)(((DocumentView)(((ProjectView)(MainFrame.getMainFrame().getSplit().getRightComponent())).getDocuments().getSelectedComponent())).getSplit().getRightComponent())).getCommandManager().addCommand(new AddCommand(page, sloto, point,1));
		
	}

	@Override
	public void mouseReleased(Point point, Page page) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(Point clicked, Point current, Page page) {
		// TODO Auto-generated method stub
		
	}

}
