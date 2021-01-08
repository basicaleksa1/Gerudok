package workspace.view;

import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultTreeCellRenderer;

import app.MainFrame;
import rightPanelView.ProjectView;
import workspace.controller.WorkspaceSelectionListener;
import workspace.model.Project;
import workspace.model.WorkspaceModel;

public class WorkspaceView extends JTree{

	public WorkspaceView() {
		setCellRenderer(new WorkspaceTreeCellRenderer());
		addTreeSelectionListener(new WorkspaceSelectionListener());
		
		setCellEditor(new WorkspaceTreeCellEditor(this, new DefaultTreeCellRenderer()));
		setEditable(true);
	
	}
	
}
