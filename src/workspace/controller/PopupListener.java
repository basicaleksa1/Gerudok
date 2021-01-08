package workspace.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


import menubar.view.PopupMenu;

public class PopupListener implements MouseListener{


	@Override
	public void mouseClicked(MouseEvent arg0) {
		if(arg0.isPopupTrigger()) {
			
			popOut(arg0);
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		if(arg0.isPopupTrigger()) 
			popOut(arg0);
			
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		if(arg0.isPopupTrigger()) 
			popOut(arg0);
		
	}

	private void popOut(MouseEvent arg0) {
		PopupMenu menu = new PopupMenu();
		menu.show(arg0.getComponent(), arg0.getX(), arg0.getY());
	}

}
