package graphics2D.elements;

import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Stroke;

import graphics2D.painters.TrianglePainter;


public class TriangleElement extends PageSlot {

	public TriangleElement(Dimension size, Point position) {
		super(size, position);
		
		elementPainter = new TrianglePainter(this); 
	}
	
	public TriangleElement(PageSlot pageSlot) {
		super(pageSlot);
		
		elementPainter = new TrianglePainter(this); 
	}

}
