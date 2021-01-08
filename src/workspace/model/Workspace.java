package workspace.model;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

import app.MainFrame;

public class Workspace extends DefaultMutableTreeNode implements Serializable {

	private ArrayList<Project> projects;
	private File file;
	

	public Workspace() {
		super();
		projects = new ArrayList<Project>();
	}
	
	@Override
	public void add(MutableTreeNode newChild) {
		Project project = (Project)newChild;
		projects.add(project);
	}

	@Override
	public Enumeration<TreeNode> children() {
		return (Enumeration<TreeNode>)projects;
	}

	@Override
	public boolean getAllowsChildren() {
		return true;
	}

	@Override
	public TreeNode getChildAt(int index) {
		return this.projects.get(index);
	}

	@Override
	public int getChildCount() {
		return this.projects.size();
	}

	@Override
	public int getIndex(TreeNode aChild) {
		return this.projects.indexOf(aChild);
	}

	@Override
	public TreeNode getParent() {
		return null;
	}

	@Override
	public void insert(MutableTreeNode arg0, int arg1) {
		this.projects.add(arg1, (Project)arg0);
	}

	@Override
	public boolean isLeaf() {
		return false;
	}

	@Override
	public void remove(int childIndex) {
		this.projects.remove(childIndex);
	}

	@Override
	public void remove(MutableTreeNode aChild) {
		this.projects.remove(aChild);
	}

	@Override
	public boolean isRoot() {
		return true;
	}
	
	@Override
	public String toString() {
		return "Workspace";
	}
	
	public ArrayList<Project> getProjects() {
		return projects;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
}
