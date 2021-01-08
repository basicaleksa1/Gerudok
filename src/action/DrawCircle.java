package action;

import java.awt.event.ActionEvent;

import app.MainFrame;
import errorHandler.ErrorHandler;
import errorHandler.Errors;
import rightPanelView.PageView;
import rightPanelView.ProjectView;

public class DrawCircle extends MyAbstractAction {

	public DrawCircle() {
		putValue(SHORT_DESCRIPTION, "Circle");
		putValue(SMALL_ICON, loadIcon("/ikonice/circle.png"));
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			((ProjectView)MainFrame.getMainFrame().getSplit().getRightComponent()).setCircleState();;
			
			System.out.println("state draw circle");
		} catch (Exception e) {			
			ErrorHandler.handle(Errors.noProject);

		}
	}

}
