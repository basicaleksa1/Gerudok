package graphics2D.painters;


import java.awt.geom.Ellipse2D;

import graphics2D.elements.CircleElement;
import graphics2D.elements.PageElement;

public class CirclePainter extends SlotPainter{

	public CirclePainter(PageElement element) {
		super(element);
		CircleElement circle = (CircleElement)element;
		
		shape = new Ellipse2D.Float(circle.getPosition().x - circle.getSize().width / 2,
				circle.getPosition().y - circle.getSize().height / 2,
				circle.getSize().width, circle.getSize().height);
		originalShape = shape;

	}

}
