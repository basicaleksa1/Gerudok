package comands;

import java.awt.Dimension;
import java.awt.Point;

import graphics2D.elements.CircleElement;
import graphics2D.elements.PageSlot;
import graphics2D.elements.RectangleElement;
import graphics2D.elements.TriangleElement;
import rightPanelView.PageView;
import workspace.model.Page;

public class AddCommand extends AbstractCommand {

	private Page page;
	private PageSlot pageSlot;
	private Point position;
	private int slotType;
	
	public AddCommand(Page page,PageSlot pageSlot,Point position, int slotType) {
		this.page = page;
		this.pageSlot = pageSlot;
		this.position = position;
		this.slotType = slotType;
	}
	
	
	@Override
	public void doCommand() {
		if(pageSlot == null) {
			if(slotType == PageView.rectangle) {
				pageSlot = new RectangleElement(new Dimension(100,70),position);
				page.addSlot(pageSlot);
			}
			if(slotType == PageView.circle) {
				pageSlot = new CircleElement(new Dimension(100,100), position);
				page.addSlot(pageSlot);
			}
			if(slotType == PageView.triangle) {
				pageSlot = new TriangleElement(new Dimension(99,99),position);
				page.addSlot(pageSlot);
			}
		}
		else
			page.addSlot(pageSlot);
	}
	
	@Override
	public void undoCommand() {
		page.removeSlot(pageSlot);
	
	}

}
