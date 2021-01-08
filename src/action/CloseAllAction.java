package action;

import java.awt.event.ActionEvent;

import javax.swing.tree.DefaultMutableTreeNode;

import app.MainFrame;
import errorHandler.ErrorHandler;
import errorHandler.Errors;
import rightPanelView.DocumentView;
import rightPanelView.ProjectView;
import workspace.model.Document;
import workspace.model.Page;
import workspace.model.Project;
import workspace.model.Workspace;

public class CloseAllAction extends MyAbstractAction{

	
	public CloseAllAction() {
		putValue(SMALL_ICON, loadIcon("/ikonice/close.png"));
		putValue(NAME, "Close all");
		putValue(SHORT_DESCRIPTION, "Close all");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {

		try {
			Object selectedNode = MainFrame.getMainFrame().getWorkspace().getSelectionPath().getLastPathComponent();
			if(selectedNode != null) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode)selectedNode;
				if(node instanceof Workspace) {
					MainFrame.getMainFrame().openProjectView(null);		
				}
				else if(node instanceof Project) {
					Project p = (Project)node;
					for(ProjectView project: ProjectView.projectViews) {
						if(project.getProject().equals(p)) {
							project.getDocuments().removeAll();							
						}
					}
				}
			}
		} catch (NullPointerException e) {
			ErrorHandler.handle(Errors.nullSelection);
			System.out.println("nista nije selektovano");
		}
		
	}

}
