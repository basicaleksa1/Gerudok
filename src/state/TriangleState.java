package state;

import java.awt.Dimension;
import java.awt.Point;

import app.MainFrame;
import comands.AddCommand;
import graphics2D.elements.PageSlot;
import graphics2D.elements.TriangleElement;
import rightPanelView.DocumentView;
import rightPanelView.PageView;
import rightPanelView.ProjectView;
import workspace.model.Page;

public class TriangleState implements IState {

	@Override
	public void mousePressed(Point point, Page page, Point currentPoint) {
//		for(PageSlot slot: page.getSlotovi()) {
//			if(slot.getElementPainter().elementAt(point, slot))
//				return;
//		}
//		TriangleElement rec = new TriangleElement(new Dimension(99, 99), point);
//		rec.setName("Element " + page.getSlotovi().size());
//		page.addSlot(rec);

		PageSlot sloto = null;
		for(PageSlot slot: page.getSlotovi()) {
			if(slot.getElementPainter().elementAt(point, slot)) {
				sloto = slot;
				break;
			}
		}
		((PageView)(((DocumentView)(((ProjectView)(MainFrame.getMainFrame().getSplit().getRightComponent())).getDocuments().getSelectedComponent())).getSplit().getRightComponent())).getCommandManager().addCommand(new AddCommand(page, sloto, point,3));
		
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
