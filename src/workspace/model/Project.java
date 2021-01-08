package workspace.model;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

import action.ActionEnum;
import observer.IListener;
import observer.IObserver;

public class Project extends DefaultMutableTreeNode implements IObserver,Serializable{

	private String name;
	private ArrayList<Document> documents;
	transient private ArrayList<IListener> listeners;
	private Workspace parent;
	private boolean changed = false;
	private File file;

	public Project(String name, Workspace parent) {
		super();
		this.name = name;
		this.parent = parent;
		documents = new ArrayList<Document>();
	}

	@Override
	public void add(MutableTreeNode newChild) {
		Document document = (Document)newChild;
		documents.add(document);
		this.notifyListeners(ActionEnum.ACTION_ADD);
	}

	@Override
	public Enumeration<TreeNode> children() {
		return (Enumeration<TreeNode>) documents;
	}

	@Override
	public boolean getAllowsChildren() {
		return true;
	}

	@Override
	public TreeNode getChildAt(int index) {
		return this.documents.get(index);
	}

	@Override
	public int getChildCount() {
		return this.documents.size();
	}

	@Override
	public int getIndex(TreeNode aChild) {
		return this.documents.indexOf(aChild);
	}

	@Override
	public TreeNode getParent() {
		return parent;
	}
	
	public void setParenta(TreeNode node) {
		parent = (Workspace) node;
	}

	@Override
	public void removeFromParent() {
		parent.remove(this);
	}

	@Override
	public void insert(MutableTreeNode arg0, int arg1) {
		this.documents.add(arg1, (Document)arg0);
	}

	@Override
	public boolean isLeaf() {
		return false;
	}

	@Override
	public void remove(int childIndex) {
		this.documents.remove(childIndex);
	}

	@Override
	public void remove(MutableTreeNode aChild) {
		this.notifyListeners(ActionEnum.ACTION_REMOVE);
		this.documents.remove(aChild);
	}

	@Override
	public String toString() {
		return this.name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		this.notifyListeners(ActionEnum.ACTION_RENAME);
	}

	public ArrayList<Document> getDocuments() {
		 return documents;
	}
	
	public boolean isChanged() {
		return changed;
	}

	public void setChanged(boolean changed) {
		if(!this.changed) {
			this.changed = changed;
			System.out.println("PROMENA NA PROJEKTUUUUU");
		}else {
			this.changed = changed;
			System.out.println("PROMENA FALSE PROJEKTUUUUU");
		}
	}

	public File getFile() {
		return file;
	}


	@Override
	public void addListener(IListener listener) {
		if(listener == null) return;
		if(listeners == null) listeners = new ArrayList<IListener>();
		if(listeners.contains(listener)) return;
		listeners.add(listener);
		
	}

	@Override
	public void removeListener(IListener listener) {
		if(listener == null || listeners == null || !listeners.contains(listener)) return;
		listeners.remove(listener);	
	}

	@Override
	public void notifyListeners(Object event) {
		if(this.listeners == null || this.listeners.isEmpty() || event == null)
			return;
		for(IListener l: listeners) {
			l.update(event);
		}
	}

	public void setFile(File file) {
		this.file = file;
	}

	

}
