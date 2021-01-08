package comands;

import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.geom.AffineTransform;
import java.io.IOException;
import java.util.ArrayList;

import app.MainFrame;
import graphics2D.elements.CircleElement;
import graphics2D.elements.PageSlot;
import graphics2D.elements.RectangleElement;
import graphics2D.elements.TriangleElement;
import graphics2D.painters.SlotPainter;
import rightPanelView.PageView;
import workspace.model.Page;
import workspace.model.PageElementsSelection;

public class PasteCommand extends AbstractCommand{

	private Page page;
	private ArrayList<PageSlot> slotovi;
	private PageView pv;
	
	public PasteCommand(Page page, PageView pv) {
		this.page = page;
		this.pv = pv;
		slotovi = new ArrayList<PageSlot>();
		
	}
	
	@Override
	public void doCommand() {
		Transferable clipboardContent = MainFrame.getMainFrame().getClipboard().getContents(MainFrame.getMainFrame());
		if ((clipboardContent != null) && (clipboardContent.isDataFlavorSupported (PageElementsSelection.dataFlavor))) {
			try {
				ArrayList<PageSlot> tempElements = (ArrayList<PageSlot>) clipboardContent.getTransferData (PageElementsSelection.dataFlavor);
				
				for(PageSlot slot : tempElements) {
					if(slot instanceof RectangleElement) {
						RectangleElement rEl = new RectangleElement(slot);
						AffineTransform transform = new AffineTransform();
			            transform.rotate(Math.toRadians(rEl.getOriginalAngle()), rEl.getPosition().getX(), rEl.getPosition().getY());
			            ((SlotPainter)rEl.getElementPainter()).setShape(transform.createTransformedShape(((SlotPainter)rEl.getElementPainter()).getOriginalShape()));
						page.addSlot(rEl);
			            slotovi.add(rEl);
					}else if(slot instanceof CircleElement){
						CircleElement cEl = new CircleElement(slot);
						AffineTransform transform = new AffineTransform();
			            transform.rotate(Math.toRadians(cEl.getOriginalAngle()), cEl.getPosition().getX(), cEl.getPosition().getY());
			            ((SlotPainter)cEl.getElementPainter()).setShape(transform.createTransformedShape(((SlotPainter)cEl.getElementPainter()).getOriginalShape()));
			            page.addSlot(cEl);
			            slotovi.add(cEl);
					}else if(slot instanceof TriangleElement) {
						TriangleElement tEl = new TriangleElement(slot);
						AffineTransform transform = new AffineTransform();
			            transform.rotate(Math.toRadians(tEl.getOriginalAngle()), tEl.getPosition().getX(), tEl.getPosition().getY());
			            ((SlotPainter)tEl.getElementPainter()).setShape(transform.createTransformedShape(((SlotPainter)tEl.getElementPainter()).getOriginalShape()));
						page.addSlot(tEl);
			            slotovi.add(tEl);
					}
					
				}
			} catch (UnsupportedFlavorException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}					
	 		
		}
		
	}

	@Override
	public void undoCommand() {
		page.removeAllSlots(slotovi);
		
	}

	
}
