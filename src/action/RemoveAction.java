package action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

import app.MainFrame;
import errorHandler.ErrorHandler;
import errorHandler.Errors;
import rightPanelView.DocumentView;
import rightPanelView.PageView;
import rightPanelView.ProjectView;
import rightPanelView.SmallPage;
import workspace.model.Document;
import workspace.model.Page;
import workspace.model.Project;
import workspace.model.Workspace;
import workspace.model.WorkspaceModel;

public class RemoveAction extends MyAbstractAction {

	public RemoveAction() {
		putValue(SMALL_ICON, loadIcon("/ikonice/delete-icon.png"));
		putValue(NAME, "Delete node");
		putValue(SHORT_DESCRIPTION, "Delete node");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		try {
			Object selectedNode = MainFrame.getMainFrame().getWorkspace().getSelectionPath().getLastPathComponent();
			if(selectedNode != null) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode)selectedNode;
				if(node instanceof Workspace)
					ErrorHandler.handle(Errors.workspaceRemove);
				if(node instanceof Project) {
					Project p = (Project)node;
					Object[] options = {"Yes","No"};
					int answer = JOptionPane.showOptionDialog(MainFrame.getMainFrame(), "Would you like to import this projects documents into another project?",
							"Import documents",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE,
							null,
							options,
							options[0]);
					
					if(answer == JOptionPane.YES_OPTION) {
						Project pr = null;
						if(((Workspace)MainFrame.getMainFrame().getWorkspacemodel().getRoot()).getChildAfter(p) != null) {
							pr = (Project) ((Workspace)MainFrame.getMainFrame().getWorkspacemodel().getRoot()).getChildAfter(p);
							for(Document d: p.getDocuments()) {
								ArrayList<Page> pages = new ArrayList<Page>(d.getPages());
								System.out.println(d.toString());
								d.getPages().clear();
								for(Page page: pages) {
									d.add(page);
									System.out.println(page.toString());
								}
								d.setParent(pr);
								pr.add(d);
								//makeViews(pr);
							}
						}
						else if(((Workspace)MainFrame.getMainFrame().getWorkspacemodel().getRoot()).getChildBefore(p) != null) {
							pr = (Project) ((Workspace)MainFrame.getMainFrame().getWorkspacemodel().getRoot()).getChildBefore(p);
							for(Document d: p.getDocuments()) {
								System.out.println(d.toString());
								ArrayList<Page> pages = new ArrayList<Page>(d.getPages());
								d.getPages().clear();
								for(Page page: pages) {
									d.add(page);
									System.out.println(page);
								}
								pr.add(d);
								d.setParent(pr);
								//makeViews(pr);
							}
						}
						else {
							ErrorHandler.handle(Errors.noProjectToImport);
							
						}
						
					}
					
					else if(answer == JOptionPane.NO_OPTION) {
						
					}
					
					else if(answer == JOptionPane.CLOSED_OPTION) {
						return;
					}

					ProjectView pv = null;
					for(ProjectView pView: ProjectView.projectViews) {
						if(pView.getProject() == p)
							pv = pView;
					}
					ProjectView.projectViews.remove(pv);
					p.removeFromParent();
					MainFrame.getMainFrame().openProjectView(null);
				}
				else if(node instanceof Document) {
					Document d = (Document)node;
//					Project p = (Project) d.getParent();
					d.removeFromParent();
					
				}
				else if(node instanceof Page) {
					Page p = (Page)node;
//					Document d = (Document)node.getParent();
					p.removeFromParent();
				}
			}
			SwingUtilities.updateComponentTreeUI(MainFrame.getMainFrame().getWorkspace());
			selectedNode = null;
			System.out.println("uspesno remove");
		} catch (NullPointerException e) {
			ErrorHandler.handle(Errors.nullSelection);
			System.out.println("nista nije selektovano");
		}
	}

}
