package workspace.model;

import java.util.ArrayList;

import javax.swing.DefaultSingleSelectionModel;
import javax.swing.event.ChangeListener;

import graphics2D.elements.PageSlot;
import observer.IListener;
import observer.IObserver;

public class PageSelectionModel extends DefaultSingleSelectionModel implements IObserver{
	
	private ArrayList<PageSlot> selectionList = new ArrayList<PageSlot>();
	private ArrayList<IListener> listeners = new ArrayList<IListener>();
	
	public void addElementToSelection(PageSlot p) {
		selectionList.add(p);
		notifyListeners(this);
	}
	
	public void removeElementFromSelection(PageSlot p) {
		selectionList.remove(p);
		notifyListeners(this);
	}
	
	public ArrayList<PageSlot> getSelectionList() {
		return selectionList;
	}

	public void setSelectionList(ArrayList<PageSlot> selectionList) {
		this.selectionList = selectionList;
	}
	
	@Override
	public void clearSelection() {
		selectionList.clear();
		notifyListeners(this);
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
