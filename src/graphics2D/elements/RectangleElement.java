package graphics2D.elements;

import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Stroke;

import graphics2D.painters.RectanglePainter;


public class RectangleElement extends PageSlot{
	
	
	public RectangleElement(Dimension size, Point position) {
		super(size, position);
		elementPainter = new RectanglePainter(this);
	}
	
	public RectangleElement(PageSlot pageSlot) {
		super(pageSlot);
		elementPainter = new RectanglePainter(this);
	}
	
}
