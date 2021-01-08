package comands;

import java.awt.Point;
import java.util.ArrayList;

import graphics2D.elements.PageSlot;
import workspace.model.Page;

public class DeleteCommand extends AbstractCommand{

	private Page page;
	private ArrayList<PageSlot> group;
	
	public DeleteCommand(Page page) {
		
		this.page = page;
		this.group = new ArrayList<PageSlot>(page.getSelectedElements().getSelectionList());
	}
	
	@Override
	public void doCommand() {
		
		page.removeAllSlots(group);
		page.getSelectedElements().clearSelection();
	}

	@Override
	public void undoCommand() {
		
		page.addAllSlots(group);
	}

}
