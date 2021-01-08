package action;

import java.awt.event.ActionEvent;

import app.MainFrame;
import errorHandler.ErrorHandler;
import errorHandler.Errors;
import rightPanelView.PageView;
import rightPanelView.ProjectView;

public class ResizeAction extends MyAbstractAction{

	public ResizeAction() {
		putValue(SMALL_ICON, loadIcon("/ikonice/resize.png"));
		putValue(SHORT_DESCRIPTION, "Resize element");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//napraviti metode u project view u koje menjaju state kako bi se smanjila zavisnost
		
		try {
			((ProjectView)MainFrame.getMainFrame().getSplit().getRightComponent()).setResizeState();	
			System.out.println("state resize");
		} catch (Exception e1) {
			ErrorHandler.handle(Errors.noProject);
		}
	}

}
