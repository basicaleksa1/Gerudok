package graphics2D.painters;

import java.awt.geom.GeneralPath;

import graphics2D.elements.PageElement;
import graphics2D.elements.TriangleElement;

public class TrianglePainter extends SlotPainter{

	public TrianglePainter(PageElement element) {
		super(element);
		
		shape = new GeneralPath();
		
		TriangleElement triangle = (TriangleElement)element;
		
		double angle = triangle.getAngle();
		
		double cx = triangle.getPosition().getX();
		double cy = triangle.getPosition().getY();
		
		double ux = cx;
		double uy = cy - (double)(2.0/3.0 * triangle.getSize().height);
		
		double lx = cx - triangle.getSize().width / 2;
		double ly = cy + triangle.getSize().height / 3;
		
		double rx = cx + triangle.getSize().width / 2;
		double ry = cy + triangle.getSize().height / 3;
		
//		double nux = cx + (ux - cx) * Math.cos(angle) - (uy - cy) * Math.sin(angle);
//		double nuy = cy + (ux - cx) * Math.sin(angle) + (uy - cy) * Math.cos(angle);
//		double nlx = cx + (lx - cx) * Math.cos(angle) - (ly - cy) * Math.sin(angle);
//		double nly = cy + (lx - cx) * Math.sin(angle) + (ly - cy) * Math.cos(angle);
//		double nrx = cx + (rx - cx) * Math.cos(angle) - (ry - cy) * Math.sin(angle);
//		double nry = cy + (rx - cx) * Math.sin(angle) + (ry - cy) * Math.cos(angle);
//		
		((GeneralPath) shape).moveTo(ux, uy);
		((GeneralPath) shape).lineTo(lx, ly);
		((GeneralPath) shape).lineTo(rx, ry);
		((GeneralPath) shape).lineTo(ux, uy);
		((GeneralPath) shape).closePath();
		originalShape = shape;

	}

}
