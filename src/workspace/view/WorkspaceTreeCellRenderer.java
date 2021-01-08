package workspace.view;

import java.awt.Component;
import java.awt.Dimension;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

import workspace.model.Document;
import workspace.model.Page;
import workspace.model.Project;
import workspace.model.Workspace;

public class WorkspaceTreeCellRenderer extends DefaultTreeCellRenderer{

	
	@Override
	public Component getTreeCellRendererComponent(JTree tree,
													Object value,
													boolean selected,
													boolean expanded,
													boolean leaf,
													int row,
													boolean hasFocus) {
		
		super.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);
		
		if(value instanceof Project) {
			URL image = getClass().getResource("/ikonice/project.png");
			Icon icon = null;
			if(image != null) {
				icon = new ImageIcon(image);
				this.setIcon(icon);
			}
		}
		else if(value instanceof Document) {
			URL image = getClass().getResource("/ikonice/document.png");
			Icon icon = null;
			if(image != null) {
				icon = new ImageIcon(image);
				this.setIcon(icon);
			}
		}
		else if(value instanceof Workspace) {
			URL image = this.getClass().getResource("/ikonice/workspace.png");
			Icon icon = null;
			if(image != null) {
				icon = new ImageIcon(image);
				this.setIcon(icon);
			}
		}
		else if(value instanceof Page) {
			URL image = this.getClass().getResource("/ikonice/page.png");
			Icon icon = null;
			if(image != null) {
				icon = new ImageIcon(image);
				this.setIcon(icon);
			}
		}
		return this;
	}
}
