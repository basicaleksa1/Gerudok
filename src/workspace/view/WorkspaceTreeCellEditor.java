package workspace.view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.EventObject;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeNode;

import action.ActionEnum;
import app.MainFrame;
import errorHandler.ErrorHandler;
import errorHandler.Errors;
import workspace.model.Document;
import workspace.model.Page;
import workspace.model.Project;
import workspace.model.Workspace;

public class WorkspaceTreeCellEditor extends DefaultTreeCellEditor implements ActionListener{

	private Object selektovanObjekat = null;
	private JTextField ispis = null;
	
	public WorkspaceTreeCellEditor(JTree arg0, DefaultTreeCellRenderer arg1) {
		super(arg0, arg1);	
	}

	@Override
	public Component getTreeCellEditorComponent(JTree arg0,
												Object arg1,
												boolean arg2,
												boolean arg3,
												boolean arg4,
												int arg5) {
		
		//super.getTreeCellEditorComponent(arg0, arg1, arg2, arg3, arg4, arg5);
		
		selektovanObjekat = arg1;
		ispis = new JTextField(arg1.toString());
		ispis.addActionListener(this);
		return ispis;
	}

	@Override
	public boolean isCellEditable(EventObject event) {
		
		if(event instanceof MouseEvent) {
			if(((MouseEvent)event).getClickCount() == 3) return true;
		}
		return false;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(selektovanObjekat instanceof Workspace) 
			ErrorHandler.handle(Errors.workspaceRename);
		
		if(selektovanObjekat instanceof Project) {
			if(arg0.getActionCommand().trim().equals(""))
				ErrorHandler.handle(Errors.nullRename);
			else
				((Project)selektovanObjekat).setName(arg0.getActionCommand());
		}
		else if(selektovanObjekat instanceof Document) {
			if(arg0.getActionCommand().trim().equals(""))
				ErrorHandler.handle(Errors.nullRename);
			else
				((Document)selektovanObjekat).setName(arg0.getActionCommand());
		}
		else if(selektovanObjekat instanceof Page) {
			if(arg0.getActionCommand().trim().equals(""))
				ErrorHandler.handle(Errors.nullRename);
			else
				((Page)selektovanObjekat).setName(arg0.getActionCommand());
		}
		System.out.println("radi mi menjane");
	}

}
