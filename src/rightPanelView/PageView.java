package rightPanelView;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import app.MainFrame;
import comands.CommandManager;
import graphics2D.elements.CircleElement;
import graphics2D.elements.PageElement;
import graphics2D.elements.PageSlot;
import graphics2D.elements.RectangleElement;
import graphics2D.elements.TriangleElement;
import graphics2D.painters.CirclePainter;
import graphics2D.painters.RectanglePainter;
import graphics2D.painters.SlotPainter;
import graphics2D.painters.TrianglePainter;
import observer.IListener;
import state.StateManager;
import workspace.controller.MousePainter;
import workspace.model.Page;
import workspace.model.PageElementsSelection;
import workspace.model.Project;

import java.awt.*;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.geom.AffineTransform;
import java.io.IOException;
import java.util.ArrayList;

public class PageView extends JPanel implements IListener {
	
	private JLabel ispis;
	private Page page;
	private CommandManager commandManager;
	
	public static final int rectangle = 1;
	public static final int circle = 2;
	public static final int triangle = 3;
	
	
	
	public PageView(Page page) {
		this.page = page;
		page.addListener(this);
		page.getSelectedElements().addListener(this);
		commandManager = new CommandManager();
		ispis = new JLabel(page.getName());
		this.setBackground(Color.WHITE);
		add(ispis);
		setPreferredSize(new Dimension(950, 560));
		addMouseListener(new MousePainter(page, this));
		addMouseMotionListener(new MousePainter(page, this));
	}

	@Override
	public void update(Object event) {
		Project pr = (Project)this.page.getParent().getParent();
		pr.setChanged(true);
		ispis.setText(page.getName());
		revalidate();
		repaint();
		System.out.println("radi mi update za page view");
		
	}

	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.8f));
		for(PageElement s: page.getSlotovi()) {
			s.getElementPainter().paint(g2, s, this);
		}
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

//	public void paste() {
//		// TODO Auto-generated method stub
//		Transferable clipboardContent = MainFrame.getMainFrame().getClipboard().getContents(MainFrame.getMainFrame());
//		if ((clipboardContent != null) && (clipboardContent.isDataFlavorSupported (PageElementsSelection.dataFlavor))) {
//			try {
//				ArrayList<PageSlot> tempElements = (ArrayList<PageSlot>) clipboardContent.getTransferData (PageElementsSelection.dataFlavor);
//				
//				for(PageSlot slotovi : tempElements) {
//					if(slotovi instanceof RectangleElement) {
//						RectangleElement rEl = new RectangleElement(slotovi);
//						AffineTransform transform = new AffineTransform();
//			            transform.rotate(Math.toRadians(rEl.getOriginalAngle()), rEl.getPosition().getX(), rEl.getPosition().getY());
//			            ((SlotPainter)rEl.getElementPainter()).setShape(transform.createTransformedShape(((SlotPainter)rEl.getElementPainter()).getOriginalShape()));
//						this.getPage().addSlot(rEl);
//					}else if(slotovi instanceof CircleElement){
//						CircleElement cEl = new CircleElement(slotovi);
//						AffineTransform transform = new AffineTransform();
//			            transform.rotate(Math.toRadians(cEl.getOriginalAngle()), cEl.getPosition().getX(), cEl.getPosition().getY());
//			            ((SlotPainter)cEl.getElementPainter()).setShape(transform.createTransformedShape(((SlotPainter)cEl.getElementPainter()).getOriginalShape()));
//						this.getPage().addSlot(cEl);
//					}else if(slotovi instanceof TriangleElement) {
//						TriangleElement tEl = new TriangleElement(slotovi);
//						AffineTransform transform = new AffineTransform();
//			            transform.rotate(Math.toRadians(tEl.getOriginalAngle()), tEl.getPosition().getX(), tEl.getPosition().getY());
//			            ((SlotPainter)tEl.getElementPainter()).setShape(transform.createTransformedShape(((SlotPainter)tEl.getElementPainter()).getOriginalShape()));
//						this.getPage().addSlot(tEl);
//					}
//					
//				}
//			} catch (UnsupportedFlavorException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}					
//	 		
//		}
//		
//	}

	public CommandManager getCommandManager() {
		return commandManager;
	}

	public void setCommandManager(CommandManager commandManager) {
		this.commandManager = commandManager;
	}
	
}
