package action;

import java.awt.event.ActionEvent;

import app.MainFrame;
import errorHandler.ErrorHandler;
import errorHandler.Errors;
import rightPanelView.ProjectView;

public class SelectAction extends MyAbstractAction{

	public SelectAction() {
		putValue(SMALL_ICON, loadIcon("/ikonice/select.png"));
		putValue(SHORT_DESCRIPTION, "Select element");
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		try {
			((ProjectView)MainFrame.getMainFrame().getSplit().getRightComponent()).setSelectState();	
			System.out.println("state resize");
		} catch (Exception e1) {
			ErrorHandler.handle(Errors.noProject);
		}
	}

}
