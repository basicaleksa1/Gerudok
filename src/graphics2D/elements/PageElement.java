package graphics2D.elements;

import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Stroke;
import java.io.Serializable;

import graphics2D.painters.ElementPainter;
import serijalizacija.SerializableStrokeAdapter;

public abstract class PageElement implements Serializable {

	protected Paint paint;
	protected SerializableStrokeAdapter stroke;
	
	protected String name;
	protected String description;
	
	protected ElementPainter elementPainter;

	public Paint getPaint() {
		return paint;
	}

	public void setPaint(Paint paint) {
		this.paint = paint;
	}

	public Stroke getStroke() {
		return stroke;
	}

	public void setStroke(Stroke stroke) {
		this.stroke = new SerializableStrokeAdapter(stroke);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ElementPainter getElementPainter() {
		return elementPainter;
	}

	public void setElementPainter(ElementPainter elementPainter) {
		this.elementPainter = elementPainter;
	}
	
}
