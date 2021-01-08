package graphics2D.elements;

import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.datatransfer.Transferable;

import slot.model.SlotType;

public abstract class PageSlot extends PageElement{


	protected Dimension size;
	protected Point position;
	protected Point originalPosition;
	protected double angle;
	protected Dimension originalSize;
	protected double originalAngle;
	protected SlotType slotType;
	//staviti abstraktnu klasu koju ce nasledjivati ili slika view ili text view ali se nece instancirati sve dok se ne izabere
	//neki od ponudjenih preko SlotTypeChoser a 

	public PageSlot(Dimension size, Point position) {
		this.size = size;
		this.position = position;
		slotType = null;
		originalSize = size;
		originalAngle = 0;
		originalPosition = position;
	}

	public PageSlot(PageSlot pageSlot) {
		this.size = pageSlot.size;
		this.position = pageSlot.position;
		originalSize = pageSlot.originalSize;
		originalAngle = pageSlot.originalAngle;
		originalPosition = pageSlot.originalPosition;
		this.slotType = pageSlot.slotType;
	}

	public double getOriginalAngle() {
		return originalAngle;
	}

	public void setOriginalAngle(double originalAngle) {
		this.originalAngle = originalAngle;
	}
	
	public Dimension getSize() {
		return size;
	}

	public void setSize(Dimension size) {
		this.size = size;
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}
	
	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}

	public Dimension getOriginalSize() {
		return originalSize;
	}

	public void setOriginalSize(Dimension originalSize) {
		this.originalSize = originalSize;
	}

	public SlotType getSlotType() {
		return slotType;
	}

	public void setSlotType(SlotType slotType) {
		this.slotType = slotType;
	}
	
	public Point getOriginalPosition() {
		return originalPosition;
	}

	public void setOriginalPosition(Point originalPosition) {
		this.originalPosition = originalPosition;
	}

}
