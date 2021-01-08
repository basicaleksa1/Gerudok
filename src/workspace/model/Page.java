package workspace.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

import action.ActionEnum;
import graphics2D.elements.PageElement;
import graphics2D.elements.PageSlot;
import observer.IListener;
import observer.IObserver;

public class Page extends DefaultMutableTreeNode implements IObserver,Serializable{
	
	private String name;
	transient private ArrayList<IListener> listeners;
	private Document parent;
	private ArrayList<PageSlot> slotovi;
	transient private PageSelectionModel selectedElements;
	
	public Page(String name, Document parent) {
		this.name = name;
		this.parent = parent;
		selectedElements = new PageSelectionModel();
		slotovi = new ArrayList<PageSlot>();
	}
	
	public Page(Page p) {
		this.name = p.name;
		this.parent = p.parent;
		selectedElements = new PageSelectionModel();
		this.slotovi = p.slotovi;
	}
	
	public PageSelectionModel getSelectedElements() {
		return selectedElements;
	}


	public void setSelectedElements(PageSelectionModel selectedElements) {
		this.selectedElements = selectedElements;
	}


	private Object readResolve(){
		 listeners = new ArrayList<IListener>();
		 selectedElements = new PageSelectionModel();
		 return this;
	}

	public void addSlot(PageSlot p) {
		slotovi.add(p);
		this.notifyListeners(p);
	}
	
	public void addAllSlots(ArrayList<PageSlot> lista) {
        slotovi.addAll(lista);
        this.notifyListeners(lista);
    }
	
	public void removeSlot(PageSlot p) {
		slotovi.remove(p);
		this.notifyListeners(p);
	}
	
	public void removeAllSlots(ArrayList<PageSlot> lista) {
		slotovi.removeAll(lista);
		this.notifyListeners(lista);
	}
	
	public ArrayList<PageSlot> getSlotovi() {
		return slotovi;
	}

	public void setSlotovi(ArrayList<PageSlot> slotovi) {
		this.slotovi = slotovi;
	}

	public void setParent(Document parent) {
		this.parent = parent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		this.notifyListeners(ActionEnum.ACTION_RENAME);
	}

	@Override
	public void add(MutableTreeNode newChild) {
		return;
	}

	@Override
	public Enumeration<TreeNode> children() {
		return null;
	}

	@Override
	public boolean getAllowsChildren() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TreeNode getChildAt(int index) {
		return null;
	}

	@Override
	public int getChildCount() {
		// TODO Auto-generated method stub
		return super.getChildCount();
	}

	@Override
	public int getIndex(TreeNode aChild) {
		// TODO Auto-generated method stub
		return super.getIndex(aChild);
	}

	@Override
	public TreeNode getParent() {
		return parent;
	}

	@Override
	public boolean isLeaf() {
		return true;
	}

	@Override
	public void remove(MutableTreeNode aChild) {
		return;
	}

	@Override
	public void removeAllChildren() {
		return;
	}

	@Override
	public void removeFromParent() {
		parent.remove(this);
	}

	@Override
	public String toString() {
		return name;
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
