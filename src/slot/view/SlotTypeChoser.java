package slot.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import app.MainFrame;
import graphics2D.elements.PageSlot;

public class SlotTypeChoser extends JDialog {

	private JButton text;
	private JButton image;
	private PageSlot slot;
	
	public SlotTypeChoser(PageSlot slot, Point p) {
		super(MainFrame.getMainFrame());
		this.slot = slot;
		setLayout(new FlowLayout());
		setSize(250, 150);
		setTitle("Choose slot type");
		setLocation(p);
		text = new JButton("Text");
		text.setPreferredSize(new Dimension(100, 100));
		text.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TextTypeView tt = new TextTypeView(slot);
				tt.setVisible(true);
				tt.setLocationRelativeTo(SlotTypeChoser.this);
				SlotTypeChoser.this.setVisible(false);
			}
		});
		
		image = new JButton("Image");
		image.setPreferredSize(new Dimension(100, 100));
		image.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ImageTypeView it = new ImageTypeView(slot);
				it.setVisible(true);
				it.setLocationRelativeTo(SlotTypeChoser.this);
				SlotTypeChoser.this.setVisible(false);
			}
		});
		add(text);
		add(image);	
	}

	public PageSlot getSlot() {
		return slot;
	}

	public void setSlot(PageSlot slot) {
		this.slot = slot;
	}
	
}
