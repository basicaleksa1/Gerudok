package state;

import java.awt.Point;
import java.awt.geom.AffineTransform;

import app.MainFrame;
import comands.MoveCommand;
import comands.RotateCommand;
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

public class MoveState implements IState{

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
	public void mouseDragged(Point clicked, Point current, Page page) {
		if(!page.getSelectedElements().getSelectionList().isEmpty()) {
			for(PageSlot slot: page.getSelectedElements().getSelectionList()) {
				slot.setPosition(new Point(slot.getOriginalPosition().x + current.x - clicked.x, slot.getOriginalPosition().y + current.y - clicked.y));
				
				if(slot instanceof RectangleElement) 
					slot.setElementPainter(new RectanglePainter(slot));
				
				else if(slot instanceof TriangleElement) 
					slot.setElementPainter(new TrianglePainter(slot));
				
				else
					slot.setElementPainter(new CirclePainter(slot));
				AffineTransform transform = new AffineTransform();
				transform.rotate(Math.toRadians(slot.getOriginalAngle()), slot.getPosition().getX(), slot.getPosition().getY());
				((SlotPainter)slot.getElementPainter()).setShape(transform.createTransformedShape(((SlotPainter)slot.getElementPainter()).getOriginalShape()));
			}
		}
	}

	@Override
	public void mouseReleased(Point point, Page page) {
		if(page.getSelectedElements().getSelectionList().isEmpty())
			return;
//		if(!page.getSelectedElements().getSelectionList().isEmpty()) {
//			for(PageSlot slot: page.getSelectedElements().getSelectionList()) {
//				slot.setOriginalPosition(slot.getPosition());
//			}
//		}
		((PageView)(((DocumentView)(((ProjectView)(MainFrame.getMainFrame().getSplit().getRightComponent())).getDocuments().getSelectedComponent())).getSplit().getRightComponent())).getCommandManager().addCommand(new MoveCommand(page, ((PageView)(((DocumentView)(((ProjectView)(MainFrame.getMainFrame().getSplit().getRightComponent())).getDocuments().getSelectedComponent())).getSplit().getRightComponent()))));

	}

}
