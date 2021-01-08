package action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import app.MainFrame;
import rightPanelView.DocumentView;
import rightPanelView.PageView;
import rightPanelView.ProjectView;
import workspace.model.PageElementsSelection;

public class CopyAction extends MyAbstractAction {

	public CopyAction() {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("/ikonice/copy.png"));
		putValue(NAME, "Copy");
		putValue(SHORT_DESCRIPTION, "Copy");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(((PageView)(((DocumentView)(((ProjectView)(MainFrame.getMainFrame().getSplit().getRightComponent())).getDocuments().getSelectedComponent())).getSplit().getRightComponent())).getPage().getSelectedElements().getSelectionList().size() != 0){
			PageElementsSelection slotovi = new PageElementsSelection(((PageView)(((DocumentView)(((ProjectView)(MainFrame.getMainFrame().getSplit().getRightComponent())).getDocuments().getSelectedComponent())).getSplit().getRightComponent())).getPage().getSelectedElements().getSelectionList()); 
			MainFrame.getMainFrame().getClipboard().setContents(slotovi, MainFrame.getMainFrame());
		}
			
	}

}
