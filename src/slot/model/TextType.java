package slot.model;

import java.awt.Font;
import java.io.File;
import java.io.Serializable;

import javax.swing.JTextPane;

import graphics2D.elements.PageSlot;
import slot.view.TextTypeView;

public class TextType implements SlotType, Serializable{

	
	private PageSlot slot;
	private String text;
	private Font font;
	private int brojac;
	
	public TextType(PageSlot slot) {
		this.slot = slot;
	}

	@Override
	public void showView() {
		// TODO Auto-generated method stub
		TextTypeView ttv = new TextTypeView(slot);
		ttv.setVisible(true);
	}



	public PageSlot getSlot() {
		return slot;
	}



	public void setSlot(PageSlot slot) {
		this.slot = slot;
	}



	public String getText() {
		return text;
	}



	public void setText(String text) {
		this.text = text;
	}



	public Font getFont() {
		return font;
	}



	public void setFont(Font font) {
		this.font = font;
	}



	public int getBrojac() {
		return brojac;
	}



	public void setBrojac(int brojac) {
		this.brojac = brojac;
	}
	
	

}
