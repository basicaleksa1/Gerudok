package state;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.geom.AffineTransform;

import app.MainFrame;
import comands.DeleteCommand;
import comands.RotateCommand;
import graphics2D.elements.PageElement;
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

public class RotateState implements IState {

	@Override
	public void mousePressed(Point point, Page page, Point currentPoint) {
		if(page.getSelectedElements().getSelectionList().isEmpty()) {
			for(PageSlot element: page.getSlotovi()) {
				if(element.getElementPainter().elementAt(point, element)) {	
					page.getSelectedElements().addElementToSelection(element);
					break;
				}
			}
		}
//		for(PageSlot element: page.getSlotovi()) {
//			if(element.getElementPainter().elementAt(point, element)) {
//				page.setSelectedSlot(element);
//				System.out.println("selektovan element" + element.toString());
//				return;
//			}
//		}
//		page.setSelectedSlot(null);	
	}

	
	// ne valja nesto mnogo brzo menja ugao
	@Override
	public void mouseDragged(Point point, Point released, Page page) {
		if(!page.getSelectedElements().getSelectionList().isEmpty()) {
			for(PageSlot slot: page.getSelectedElements().getSelectionList()) {
				double angle = angleCalculator(point, released, slot);
				AffineTransform transform = new AffineTransform();
				transform.rotate(Math.toRadians(angle), slot.getPosition().getX(), slot.getPosition().getY());
				((SlotPainter)slot.getElementPainter()).setShape(transform.createTransformedShape(((SlotPainter)slot.getElementPainter()).getOriginalShape()));                                                             
				slot.setAngle(angle);
			}
		}
		
	}

	@Override
	public void mouseReleased(Point point, Page page) {
		if(page.getSelectedElements().getSelectionList().isEmpty())
			return;
		if(!page.getSelectedElements().getSelectionList().isEmpty()) {
			for(PageSlot slot: page.getSelectedElements().getSelectionList()) {
				((SlotPainter)slot.getElementPainter()).setOriginalShape(((SlotPainter)slot.getElementPainter()).getShape());
				slot.setOriginalAngle(slot.getOriginalAngle() + slot.getAngle());
			}
		}
		//((PageView)(((DocumentView)(((ProjectView)(MainFrame.getMainFrame().getSplit().getRightComponent())).getDocuments().getSelectedComponent())).getSplit().getRightComponent())).getCommandManager().addCommand(new RotateCommand(page, ((PageView)(((DocumentView)(((ProjectView)(MainFrame.getMainFrame().getSplit().getRightComponent())).getDocuments().getSelectedComponent())).getSplit().getRightComponent()))));

	}

	private double angleCalculator(Point clicked, Point released, PageSlot slot) {
		double angle = 0;
		
		
		double centerx = slot.getPosition().getX();
		double centery = slot.getPosition().getY();

		double clickedx = clicked.x - centerx;
		double clickedy = clicked.y - centery;
		
		double releasedx = released.x - centerx;
		double releasedy = released.y - centery;
		
		double y = clickedx * releasedy - clickedy * releasedx;
		double x = clickedx * releasedx + clickedy * releasedy;
		angle = Math.atan2(y, x);
	
		angle = Math.toDegrees(angle);
		
		return angle;
	}

}
