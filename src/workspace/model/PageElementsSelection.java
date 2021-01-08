package workspace.model;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;

import graphics2D.elements.PageSlot;


public class PageElementsSelection implements Transferable,ClipboardOwner {

	static public DataFlavor dataFlavor;
	
	private DataFlavor[] supportedFlavors = { dataFlavor };
	public ArrayList<PageSlot> pageSlots = new ArrayList<PageSlot>();

	public PageElementsSelection(ArrayList<PageSlot> slots) {
		pageSlots = slots;
		try {

			dataFlavor = new DataFlavor(Class.forName("java.util.ArrayList"), "Elements");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	

	@Override
	public DataFlavor[] getTransferDataFlavors() {
		return (supportedFlavors);
	}

	@Override
	public boolean isDataFlavorSupported(DataFlavor flavor) {
		return (flavor.equals(dataFlavor));
	}

	@Override
	public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {

		if (flavor.equals(dataFlavor))
			return pageSlots;
		else
			throw new UnsupportedFlavorException(dataFlavor);
	}
	
	@Override
	public void lostOwnership(Clipboard clipboard, Transferable contents) {
		// TODO Auto-generated method stub
		
	}

}
