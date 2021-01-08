package state;

import java.awt.Point;
import java.util.Iterator;

import app.MainFrame;
import comands.AddCommand;
import comands.DeleteCommand;
import graphics2D.elements.PageSlot;
import rightPanelView.DocumentView;
import rightPanelView.PageView;
import rightPanelView.ProjectView;
import workspace.model.Page;

public class DeleteState implements IState{

	@Override
	public void mousePressed(Point point, Page page, Point currentPoint) {
//		if(page.getSelectedElements().getSelectionList().isEmpty()) {
//			for(PageSlot element: page.getSlotovi()) {
//				if(element.getElementPainter().elementAt(point, element)) {	
//					page.getSelectedElements().addElementToSelection(element);
//				}
//			}
//		}
//			page.getSlotovi().removeAll(page.getSelectedElements().getSelectionList());
//			page.getSelectedElements().clearSelection();
		
		if(page.getSelectedElements().getSelectionList().isEmpty()) {
            for(PageSlot element: page.getSlotovi()) {
                if(element.getElementPainter().elementAt(point, element)) {
                    page.getSelectedElements().addElementToSelection(element);
                    break;
                }
            }
        }
		((PageView)(((DocumentView)(((ProjectView)(MainFrame.getMainFrame().getSplit().getRightComponent())).getDocuments().getSelectedComponent())).getSplit().getRightComponent())).getCommandManager().addCommand(new DeleteCommand(page));

		//page.getSelectedElements().clearSelection();
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
