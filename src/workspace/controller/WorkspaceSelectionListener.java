package workspace.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import app.MainFrame;
import rightPanelView.DocumentView;
import rightPanelView.ProjectView;
import workspace.model.Document;
import workspace.model.Page;
import workspace.model.Project;
import workspace.model.Workspace;

public class WorkspaceSelectionListener implements TreeSelectionListener{

	@Override
	public void valueChanged(TreeSelectionEvent selectedNode) {
		TreePath path = selectedNode.getPath();
		MainFrame.getMainFrame().getWorkspace().addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2) {
					DefaultMutableTreeNode node = (DefaultMutableTreeNode) path.getLastPathComponent();
					if(node instanceof Workspace) {
						MainFrame.getMainFrame().openProjectView(null);
					}
					
					else if(node instanceof Project) {
						for(ProjectView view: ProjectView.projectViews) {
							if(view.getProject().equals(node)) {
								MainFrame.getMainFrame().openProjectView(view);
							}
						}
					}
					else if(node instanceof Document) {
						Document d = (Document)node;
						Project p = (Project) d.getParent();
						for(ProjectView view: ProjectView.projectViews) {
							if(view.getProject().equals(p)) {
								MainFrame.getMainFrame().openProjectView(view);
								view.addClickedTab(d);
								view.getDocuments().setSelectedIndex(p.getIndex(d));
							}
						}					
					}
					else if(node instanceof Page) {
						Page page = (Page)node;
						Document d = (Document) page.getParent();
						Project p = (Project) d.getParent();
						for(ProjectView view: ProjectView.projectViews) {
							if(view.getProject().equals(p)) {
								MainFrame.getMainFrame().openProjectView(view);
								view.getDocuments().setSelectedIndex(p.getIndex(d));
								
							}
						}
					}
				}
			}
		});
		MainFrame.getMainFrame().getWorkspace().addMouseListener(new PopupListener());
		
		DefaultMutableTreeNode d = (DefaultMutableTreeNode) path.getPathComponent(path.getPathCount() - 1);
		System.out.println(d.toString());
	}
}
