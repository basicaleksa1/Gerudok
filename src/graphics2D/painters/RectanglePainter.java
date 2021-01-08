package graphics2D.painters;

import java.awt.Shape;
import java.awt.geom.GeneralPath;

import graphics2D.elements.PageElement;
import graphics2D.elements.RectangleElement;

public class RectanglePainter extends SlotPainter{
	
	public RectanglePainter(PageElement element) {
		super(element);
		shape = new GeneralPath();
		
		RectangleElement rectangle = (RectangleElement)element;
		
		double ulx = rectangle.getPosition().getX() - rectangle.getSize().width / 2;
		double uly = rectangle.getPosition().getY() - rectangle.getSize().height / 2;
		double urx = rectangle.getPosition().getX() + rectangle.getSize().width / 2;
		double ury = rectangle.getPosition().getY() - rectangle.getSize().height / 2;
		double llx = rectangle.getPosition().getX() - rectangle.getSize().width / 2;
		double lly = rectangle.getPosition().getY() + rectangle.getSize().height / 2;
		double lrx = rectangle.getPosition().getX() + rectangle.getSize().width / 2;
		double lry = rectangle.getPosition().getY() + rectangle.getSize().height / 2;
		
		((GeneralPath)shape).moveTo(ulx, uly);
		((GeneralPath)shape).lineTo(urx, ury);
		((GeneralPath)shape).lineTo(lrx, lry);
		((GeneralPath)shape).lineTo(llx, lly);
		((GeneralPath)shape).closePath();
		
		originalShape = shape;
	}

}
