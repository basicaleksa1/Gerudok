package toolbar.view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import action.ActionManager;

public class ToolBar extends JToolBar{

	public ToolBar() {
		
		add(ActionManager.getInstance().getNewAction());
		setFloatable(false);
		add(ActionManager.getInstance().getRemoveAction());
		add(ActionManager.getInstance().getCloseAction());
		add(ActionManager.getInstance().getCloseAllAction());
		add(ActionManager.getInstance().getSaveAction());
		add(ActionManager.getInstance().getSaveAsAction());
		add(ActionManager.getInstance().getOpenProject());
		add(ActionManager.getInstance().getOpenWorkspace());
		add(ActionManager.getInstance().getCutAction());
		add(ActionManager.getInstance().getCopyAction());
		add(ActionManager.getInstance().getPasteAction());
		add(ActionManager.getInstance().getUndoAction());
		add(ActionManager.getInstance().getRedoAction());
		
	}
}
