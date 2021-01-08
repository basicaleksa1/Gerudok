package menubar.view;

import javax.swing.JPopupMenu;

import action.ActionManager;

public class PopupMenu extends JPopupMenu {
	
	public PopupMenu() {
		add(ActionManager.getInstance().getNewAction());
		add(ActionManager.getInstance().getRemoveAction());
		add(ActionManager.getInstance().getCloseAction());
		add(ActionManager.getInstance().getSaveAction());
		add(ActionManager.getInstance().getSaveAsAction());
	}
	
}
