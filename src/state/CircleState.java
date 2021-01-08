package state;

import java.awt.Dimension;
import java.awt.Point;

import app.MainFrame;
import comands.AddCommand;
import graphics2D.elements.CircleElement;
import graphics2D.elements.PageSlot;
import rightPanelView.DocumentView;
import rightPanelView.PageView;
import rightPanelView.ProjectView;
import workspace.model.Page;

public class CircleState implements IState {

	@Override
	public void mousePressed(Point point, Page page, Point currentPoint) {
//		for(PageSlot slot: page.getSlotovi()) {
//			if(slot.getElementPainter().elementAt(point, slot))
//				return;
//		}
//		CircleElement circle = new CircleElement(new Dimension(100, 100), point);
//		page.addSlot(circle);

		PageSlot sloto = null;
		for(PageSlot slot: page.getSlotovi()) {
			if(slot.getElementPainter().elementAt(point, slot)) {
				sloto = slot;
				break;
			}
		}
		((PageView)(((DocumentView)(((ProjectView)(MainFrame.getMainFrame().getSplit().getRightComponent())).getDocuments().getSelectedComponent())).getSplit().getRightComponent())).getCommandManager().addCommand(new AddCommand(page, sloto, point, 2));
		
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
