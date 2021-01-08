package workspace.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

import action.ActionEnum;
import observer.IListener;
import observer.IObserver;

public class Document extends DefaultMutableTreeNode implements IObserver,Serializable{

	private String name;
	private ArrayList<Page> pages;
	transient private ArrayList<IListener> listeners;
	private Project parent;
	
	public Document(Document d) {
		this.name = d.name;
		this.parent = d.parent;
		this.pages = new ArrayList<Page>(d.getPages());
	}
	
	public Document(String name, Project parent) {
		this.name = name;
		this.parent = parent;
		pages = new ArrayList<Page>();
	}

	@Override
	public void add(MutableTreeNode newChild) {
		Page page = (Page)newChild;
		pages.add(page);
		this.notifyListeners(ActionEnum.ACTION_ADD);
	}

	@Override
	public Enumeration<TreeNode> children() {
		return (Enumeration<TreeNode>) pages;
	}

	@Override
	public boolean getAllowsChildren() {
		return true;
	}

	@Override
	public TreeNode getChildAt(int index) {
		return this.pages.get(index);
	}

	@Override
	public int getChildCount() {
		return this.pages.size();
	}

	@Override
	public int getIndex(TreeNode aChild) {
		return this.pages.indexOf(aChild);
	}

	@Override
	public TreeNode getParent() {
		return parent;
	}
	
	@Override
	public void setParent(MutableTreeNode node) {
		parent = (Project) node;
	}

	@Override
	public void insert(MutableTreeNode arg0, int arg1) {
		this.pages.add(arg1, (Page)arg0);
	}

	@Override
	public boolean isLeaf() {
		return false;
	}

	@Override
	public void remove(int childIndex) {
		this.pages.remove(childIndex);
	}

	@Override
	public void remove(MutableTreeNode aChild) {
		this.notifyListeners(ActionEnum.ACTION_REMOVE);
		this.pages.remove((Page)aChild);
	}

	@Override
	public void removeFromParent() {
		parent.remove(this);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		this.notifyListeners(ActionEnum.ACTION_RENAME);
	}
	
	public ArrayList<Page> getPages() {
		return pages;
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
}
