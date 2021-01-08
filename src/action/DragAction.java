package action;

import java.awt.event.ActionEvent;

import app.MainFrame;
import errorHandler.ErrorHandler;
import errorHandler.Errors;
import rightPanelView.ProjectView;

public class DragAction extends MyAbstractAction{

	public DragAction() {
		putValue(SHORT_DESCRIPTION, "Drag");
		putValue(SMALL_ICON, loadIcon("/ikonice/drag.png"));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			((ProjectView)MainFrame.getMainFrame().getSplit().getRightComponent()).setMoveState();
			
			System.out.println("move state");
		} catch (Exception ee) {			
			ErrorHandler.handle(Errors.noProject);

		}
		
	}

}
