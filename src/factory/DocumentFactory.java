package factory;

import javax.swing.tree.TreeNode;

import workspace.model.Document;
import workspace.model.Project;

public class DocumentFactory extends NodeFactory{

	@Override
	public TreeNode makeNode(TreeNode node) {
		return new Document("document " + node.getChildCount(), (Project)node);
	}

}
