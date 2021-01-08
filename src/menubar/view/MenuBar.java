package menubar.view;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;

import action.ActionManager;

public class MenuBar extends JMenuBar{

	public MenuBar() {
		JMenu file = new JMenu("File");
		JMenu help = new JMenu("Help");
		help.add(ActionManager.getInstance().getAboutAction());
		file.add(ActionManager.getInstance().getNewAction());
		file.add(ActionManager.getInstance().getRemoveAction());
		file.add(ActionManager.getInstance().getCloseAction());
		file.add(ActionManager.getInstance().getCloseAllAction());
		file.add(ActionManager.getInstance().getSaveAction());
		file.add(ActionManager.getInstance().getSaveAsAction());
		file.add(ActionManager.getInstance().getOpenProject());
		file.add(ActionManager.getInstance().getOpenWorkspace());
		file.add(ActionManager.getInstance().getCutAction());
		file.add(ActionManager.getInstance().getCopyAction());
		file.add(ActionManager.getInstance().getPasteAction());
		this.add(file);	
		this.add(help);
	}
}













