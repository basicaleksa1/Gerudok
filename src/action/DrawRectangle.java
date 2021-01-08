package action;

import java.awt.event.ActionEvent;

import app.MainFrame;
import errorHandler.ErrorHandler;
import errorHandler.Errors;
import rightPanelView.PageView;
import rightPanelView.ProjectView;

public class DrawRectangle extends MyAbstractAction{

	public DrawRectangle() {
		putValue(SMALL_ICON, loadIcon("/ikonice/rectangle.png"));
		putValue(SHORT_DESCRIPTION, "Rectangle");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			((ProjectView)MainFrame.getMainFrame().getSplit().getRightComponent()).setRectangleState();
			System.out.println(((ProjectView)MainFrame.getMainFrame().getSplit().getRightComponent()).getProject());
			
			System.out.println("state draw rectangle");
		} catch (Exception e1) {
			ErrorHandler.handle(Errors.noProject);
		}
	}
	
}
