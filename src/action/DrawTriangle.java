package action;

import java.awt.event.ActionEvent;

import app.MainFrame;
import errorHandler.ErrorHandler;
import errorHandler.Errors;
import rightPanelView.PageView;
import rightPanelView.ProjectView;

public class DrawTriangle extends MyAbstractAction {

	public DrawTriangle(){
		putValue(SMALL_ICON, loadIcon("/ikonice/triangle.png"));
		putValue(SHORT_DESCRIPTION, "Triangle");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			((ProjectView)MainFrame.getMainFrame().getSplit().getRightComponent()).setTriangleState();

			System.out.println("state draw triangle");
		} catch (Exception e1) {			
			ErrorHandler.handle(Errors.noProject);
		}
	}
}
