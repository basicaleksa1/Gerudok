package slot.model;

import java.io.File;
import java.io.Serializable;

import graphics2D.elements.PageSlot;
import slot.view.ImageTypeView;

public class ImageType implements SlotType, Serializable{

	private PageSlot slot;
	private File image;

	public ImageType(PageSlot slot) {
		this.slot = slot;
	}

	@Override
	public void showView() {
		ImageTypeView it = new ImageTypeView(slot);
		it.setVisible(true);
	}
	
	public PageSlot getSlot() {
		return slot;
	}

	public void setSlot(PageSlot slot) {
		this.slot = slot;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

}
