package state;

import java.awt.Point;

import graphics2D.elements.PageSlot;
import workspace.model.Page;

public class SelectState implements IState {

	@Override
	public void mousePressed(Point point, Page page, Point currentPoint) {
		for(PageSlot element: page.getSlotovi()) {
			if(element.getElementPainter().elementAt(point, element)) {
				if(page.getSelectedElements().getSelectionList().contains(element)) {
					page.getSelectedElements().removeElementFromSelection(element);
					return;
				}
				else {
					page.getSelectedElements().addElementToSelection(element);
					return;
				}
			}
		}
		page.getSelectedElements().clearSelection();
		
	}

	@Override
	public void mouseDragged(Point clicked, Point current, Page page) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(Point point, Page page) {
		// TODO Auto-generated method stub
		
	} 
	
}
