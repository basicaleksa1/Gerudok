package toolbar.view;

import javax.swing.JToolBar;

import action.ActionManager;

public class Pallete extends JToolBar {

	public Pallete() {
		add(ActionManager.getInstance().getDrawRectangle());
		add(ActionManager.getInstance().getDrawCircle());
		add(ActionManager.getInstance().getDrawTriangle());
		add(ActionManager.getInstance().getRotateAction());
		add(ActionManager.getInstance().getResizeAction());
		add(ActionManager.getInstance().getDragAction());
		add(ActionManager.getInstance().getSelectAction());
		add(ActionManager.getInstance().getDeleteElementAction());
		setFloatable(true);
		setOrientation(JToolBar.VERTICAL);
	}
}
