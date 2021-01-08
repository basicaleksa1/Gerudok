package action;

import java.awt.event.ActionEvent;

import app.MainFrame;
import errorHandler.ErrorHandler;
import errorHandler.Errors;
import rightPanelView.PageView;
import rightPanelView.ProjectView;

public class RotateAction extends MyAbstractAction{

	public RotateAction() {
		putValue(SMALL_ICON, loadIcon("/ikonice/rotate.png"));
		putValue(SHORT_DESCRIPTION, "Rotate element");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			((ProjectView)MainFrame.getMainFrame().getSplit().getRightComponent()).setRotateState();
			System.out.println("state rotate");
		} catch (Exception e) {
			ErrorHandler.handle(Errors.noProject);
		}
		
	}

}
