package graphics2D.painters;

import java.awt.Graphics2D;
import java.awt.Point;
import java.io.Serializable;

import graphics2D.elements.PageElement;
import rightPanelView.PageView;

public abstract class ElementPainter implements Serializable {

	public ElementPainter(PageElement element) {};
	
	public abstract void paint(Graphics2D g, PageElement element, PageView pageView);
	
	public abstract boolean elementAt(Point position, PageElement p);
}
