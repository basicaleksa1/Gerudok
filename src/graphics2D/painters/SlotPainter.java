package graphics2D.painters;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;

import graphics2D.elements.PageElement;
import rightPanelView.PageView;

public class SlotPainter extends ElementPainter{

	protected Shape shape;
	protected Shape originalShape;
	
	public SlotPainter(PageElement element) {
		super(element);
	}

	@Override
	public void paint(Graphics2D g, PageElement element, PageView pageView) {
		g.setPaint(Color.CYAN);
		if(pageView.getPage().getSelectedElements().getSelectionList().contains(element))
			g.setPaint(Color.MAGENTA);
		g.setStroke(new BasicStroke(4f));
		g.draw(getShape());
		g.setPaint(new Color(255, 255, 255));
		g.fill(getShape());
		
		
	}

	@Override
	public boolean elementAt(Point position, PageElement element) {
		return getShape().contains(position);
	}
	
	public Shape getShape() {
		return shape;
	}

	public void setShape(Shape shape) {
		this.shape = shape;
	}

	public Shape getOriginalShape() {
		return originalShape;
	}

	public void setOriginalShape(Shape originalShape) {
		this.originalShape = originalShape;
	}

}
