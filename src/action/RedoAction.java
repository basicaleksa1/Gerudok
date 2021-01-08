package action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import app.MainFrame;
import rightPanelView.DocumentView;
import rightPanelView.PageView;
import rightPanelView.ProjectView;

public class RedoAction extends MyAbstractAction {

	RedoAction(){
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_Y, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("/ikonice/redo-icon.png"));
		putValue(NAME, "Redo");
		putValue(SHORT_DESCRIPTION, "Redo");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		((PageView)(((DocumentView)(((ProjectView)(MainFrame.getMainFrame().getSplit().getRightComponent())).getDocuments().getSelectedComponent())).getSplit().getRightComponent())).getCommandManager().doCommand();
	}

}
