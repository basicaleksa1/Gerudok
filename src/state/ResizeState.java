package state;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.geom.AffineTransform;

import app.MainFrame;
import comands.ResizeCommand;
import graphics2D.elements.PageSlot;
import graphics2D.elements.RectangleElement;
import graphics2D.elements.TriangleElement;
import graphics2D.painters.CirclePainter;
import graphics2D.painters.RectanglePainter;
import graphics2D.painters.SlotPainter;
import graphics2D.painters.TrianglePainter;
import rightPanelView.DocumentView;
import rightPanelView.PageView;
import rightPanelView.ProjectView;
import workspace.model.Page;

public class ResizeState implements IState {
	
	
	@Override
	public void mousePressed(Point point, Page page, Point currentPoint) {
		if(page.getSelectedElements().getSelectionList().isEmpty()) {
			for(PageSlot element: page.getSlotovi()) {
				if(element.getElementPainter().elementAt(point, element)) {	
					page.getSelectedElements().addElementToSelection(element);
				}
			}
		}
	}

	@Override
	public void mouseDragged(Point clicked, Point released, Page page) {
		if(!page.getSelectedElements().getSelectionList().isEmpty()) {
			for(PageSlot slot: page.getSelectedElements().getSelectionList()) {
			
			slot.setSize(new Dimension(slot.getOriginalSize().width + released.x - clicked.x,
					slot.getOriginalSize().height + released.y - clicked.y));
			if(slot instanceof RectangleElement) 
				slot.setElementPainter(new RectanglePainter(slot));
			
			else if(slot instanceof TriangleElement) 
				slot.setElementPainter(new TrianglePainter(slot));
			
			else
				slot.setElementPainter(new CirclePainter(slot));
			AffineTransform transform = new AffineTransform();
			transform.rotate(Math.toRadians(slot.getOriginalAngle()), slot.getPosition().getX(), slot.getPosition().getY());
			((SlotPainter)slot.getElementPainter()).setShape(transform.createTransformedShape(((SlotPainter)slot.getElementPainter()).getOriginalShape()));
			
			//namestiti ugao samo i to je to
			}
		}
		
	}
	
	public void mouseReleased(Point point, Page page) {
		if(page.getSelectedElements().getSelectionList().isEmpty())
			return;
//		if(!page.getSelectedElements().getSelectionList().isEmpty()) {
//			for(PageSlot slot: page.getSelectedElements().getSelectionList()) {
//				slot.setOriginalSize(slot.getSize());
//			}
//		}
		((PageView)(((DocumentView)(((ProjectView)(MainFrame.getMainFrame().getSplit().getRightComponent())).getDocuments().getSelectedComponent())).getSplit().getRightComponent())).getCommandManager().addCommand(new ResizeCommand(page, ((PageView)(((DocumentView)(((ProjectView)(MainFrame.getMainFrame().getSplit().getRightComponent())).getDocuments().getSelectedComponent())).getSplit().getRightComponent()))));

	}

}
