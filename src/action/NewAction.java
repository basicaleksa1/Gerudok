package action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

import app.MainFrame;
import errorHandler.ErrorHandler;
import errorHandler.Errors;
import factory.DocumentFactory;
import factory.NodeFactory;
import factory.PageFactory;
import factory.ProjectFactory;
import workspace.model.Document;
import workspace.model.Page;
import workspace.model.Project;
import workspace.model.Workspace;

public class NewAction extends MyAbstractAction {
	

	public NewAction() {
		putValue(SMALL_ICON, loadIcon("/ikonice/new.png"));
		putValue(NAME, "New node");
		putValue(SHORT_DESCRIPTION, "New node");
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			Object selectedNode = MainFrame.getMainFrame().getWorkspace().getSelectionPath().getLastPathComponent();
			if(selectedNode != null) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode)selectedNode;
				
				NodeFactory factory = factory(node);
				node.add((MutableTreeNode) factory.makeNode(node));
				
				SwingUtilities.updateComponentTreeUI(MainFrame.getMainFrame().getWorkspace());
				MainFrame.getMainFrame().getWorkspace().expandPath(MainFrame.getMainFrame().getWorkspace().getSelectionPath());
			}
				
		} catch (NullPointerException e) {
			ErrorHandler.handle(Errors.nullSelection);
			System.out.println("nista nije selektovano");
		}
		
	}
	
	private static NodeFactory factory(DefaultMutableTreeNode node) {
		if(node instanceof Workspace) return new ProjectFactory();
		else if(node instanceof Project) return new DocumentFactory();
		else if(node instanceof Document) return new PageFactory();
		return null;
	}

}
