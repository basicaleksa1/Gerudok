package action;

import java.awt.event.ActionEvent;

import app.MainFrame;
import errorHandler.ErrorHandler;
import errorHandler.Errors;
import rightPanelView.ProjectView;

public class DeleteElementAction extends MyAbstractAction{

	public DeleteElementAction() {
		putValue(SMALL_ICON, loadIcon("/ikonice/delete-icon.png"));
		putValue(SHORT_DESCRIPTION, "Delete element");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		try {
			((ProjectView)MainFrame.getMainFrame().getSplit().getRightComponent()).setDeleteState();	
			System.out.println("state delete");
		} catch (Exception e1) {
			ErrorHandler.handle(Errors.noProject);
		}
	}
	
}
