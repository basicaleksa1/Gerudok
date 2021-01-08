package graphics2D.elements;

import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Stroke;

import graphics2D.painters.CirclePainter;


public class CircleElement extends PageSlot{

	public CircleElement(Dimension size, Point position) {
		super(size, position);
		elementPainter = new CirclePainter(this);
	}
	
	public CircleElement(PageSlot pageSlot) {
		super(pageSlot);
		elementPainter = new CirclePainter(this);
	}

}
