package action;

import java.awt.Component;
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

public class CloseAction extends MyAbstractAction{

	public CloseAction() {
		putValue(SMALL_ICON, loadIcon("/ikonice/close.png"));
		putValue(NAME, "Close tab");
		putValue(SHORT_DESCRIPTION, "Close tab");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		try {
			Object selectedNode = MainFrame.getMainFrame().getWorkspace().getSelectionPath().getLastPathComponent();
			if(selectedNode != null) {
				//DefaultMutableTreeNode node = (DefaultMutableTreeNode)selectedNode;
				
				ProjectView pv = (ProjectView) MainFrame.getMainFrame().getSplit().getRightComponent();
				pv.getDocuments().remove(pv.getDocuments().getSelectedComponent());
				
//				if(node instanceof Project) {
//					Project p = (Project)node;
//					for(ProjectView view: ProjectView.projectViews) {
//						if(view.getProject().equals(p)) {
//							if(MainFrame.getMainFrame().getSplit().getRightComponent() == view) {
//								MainFrame.getMainFrame().getSplit().setRightComponent(null);
//							}
//						}
//					}
//				}
//				else if(node instanceof Document) {
//					Document d = (Document)node;
//					Project p = (Project) d.getParent();
//					for(ProjectView project: ProjectView.projectViews) {
//						if(project.getProject().equals(p)) {
//							for(Component dView: project.getDocuments().getComponents()) {
//								if(((DocumentView)dView).getDocument().equals(d)) {
//									project.getDocuments().remove(dView);
//								}
//							}
//							
//						}
//					}
//					
//				}
			}
		} catch (NullPointerException | IndexOutOfBoundsException k) {
			ErrorHandler.handle(Errors.nullSelection);
			System.out.println("nista nije selektovano");
		}
	}

}
