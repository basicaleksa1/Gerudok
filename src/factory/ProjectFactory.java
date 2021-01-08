package factory;

import javax.swing.tree.TreeNode;

import app.MainFrame;
import workspace.model.Project;
import workspace.model.Workspace;

public class ProjectFactory extends NodeFactory{

	@Override
	public TreeNode makeNode(TreeNode node) {
		Project p = new Project("project " + node.getChildCount(), (Workspace)node);
		MainFrame.getMainFrame().projectViewMaker(p);
		return p;
	}

}
