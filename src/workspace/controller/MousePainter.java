package workspace.controller;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import app.MainFrame;
import graphics2D.elements.PageSlot;
import rightPanelView.PageView;
import rightPanelView.ProjectView;
import slot.view.SlotTypeChoser;
import state.StateManager;
import workspace.model.Page;

public class MousePainter extends MouseAdapter{
	
	private Page page;
	private StateManager state;
	private PageView pView;
	private static Point clicked;
	
	public MousePainter(Page page, PageView pView) {
		this.page = page;
		this.state = ((ProjectView)MainFrame.getMainFrame().getSplit().getRightComponent()).getStateManager();
		this.pView = pView;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getClickCount() == 2) {
			for(PageSlot slot: page.getSlotovi()) {
				if(slot.getElementPainter().elementAt(e.getPoint(), slot)) {
					if(slot.getSlotType() == null) {
						SlotTypeChoser typeChoser = new SlotTypeChoser(slot, e.getPoint());
						typeChoser.setVisible(true);
						return;
					}
					else
						slot.getSlotType().showView();
					return;
				}
			}
		}
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		Point point = arg0.getPoint();
		//System.out.println(clicked);
		state.getCurrentState().mouseDragged(clicked, point, page);
		pView.repaint();
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		Point point = arg0.getPoint();
		clicked = arg0.getPoint();
		//System.out.println(clicked);
		state.getCurrentState().mousePressed(point, page, clicked);
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		Point point = arg0.getPoint();
		state.getCurrentState().mouseReleased(point, page);
		pView.repaint();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		
	}

	
}
