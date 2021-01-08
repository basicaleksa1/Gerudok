package factory;

import javax.swing.tree.TreeNode;

import workspace.model.Document;
import workspace.model.Page;

public class PageFactory extends NodeFactory{

	@Override
	public TreeNode makeNode(TreeNode node) {
		return new Page("page " + node.getChildCount(), (Document)node);
	}

}
