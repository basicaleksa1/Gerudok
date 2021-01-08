package action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import app.MainFrame;
import rightPanelView.DocumentView;
import rightPanelView.PageView;
import rightPanelView.ProjectView;

public class UndoAction extends MyAbstractAction{

	UndoAction(){
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("/ikonice/undo-icon.png"));
		putValue(NAME, "Undo");
		putValue(SHORT_DESCRIPTION, "Undo");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		((PageView)(((DocumentView)(((ProjectView)(MainFrame.getMainFrame().getSplit().getRightComponent())).getDocuments().getSelectedComponent())).getSplit().getRightComponent())).getCommandManager().undoCommand();
		//((PageView)(((DocumentView)(((ProjectView)(MainFrame.getMainFrame().getSplit().getRightComponent())).getDocuments().getSelectedComponent())).getSplit().getRightComponent())).repaint();
	}
}
