package slot.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;


import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.StyledDocument;
import javax.swing.text.StyledEditorKit;

import app.MainFrame;
import graphics2D.elements.PageSlot;
import slot.model.ImageType;
import slot.model.TextType;

public class TextTypeView extends JDialog{

	private JButton save;
	private JTextPane text;
	private PageSlot slot;
	private int brojac = 12;
	private JLabel labela;
	JComboBox<String> styles = new JComboBox<String>();
	
	public TextTypeView(PageSlot slot) {
		super(MainFrame.getMainFrame());
		setLayout(new BorderLayout());
		this.setSize(700, 500);
		this.slot = slot;
		JPanel toolbar = new JPanel(new FlowLayout());
		
		
		labela = new JLabel("Font: " + brojac);
		
		JButton bold = new JButton(new StyledEditorKit.BoldAction());
		ImageIcon iconBold = (ImageIcon) loadIcon("/ikonice/bold.png");
		bold.setIcon(iconBold);
		bold.setText("");
		
		JButton italic = new JButton(new StyledEditorKit.ItalicAction());
		ImageIcon iconItalic = (ImageIcon) loadIcon("/ikonice/italic.png");
		italic.setIcon(iconItalic);
		italic.setText("");
		
		JButton underline = new JButton(new StyledEditorKit.UnderlineAction());
		ImageIcon iconUnderline = (ImageIcon) loadIcon("/ikonice/underline.png");
		underline.setIcon(iconUnderline);
		underline.setText("");
		
		JButton plusFont = new JButton("Font+");
			plusFont.addActionListener(new ActionListener() {

			    @Override
			    public void actionPerformed(ActionEvent e) {
			        //your actions
					Font font = text.getFont();
					float size = font.getSize() + 1.0f;
					text.setFont( font.deriveFont(size) );
					if(brojac < 0) {
						brojac = 0;
					}
					brojac ++;
					labela.setText("Font: " + brojac);
			    }
			});

			JButton minusFont = new JButton("Font-");
			minusFont.addActionListener(new ActionListener() {

			    @Override
			    public void actionPerformed(ActionEvent e) {
			        //your actions
					Font font = text.getFont();
					float size = font.getSize() - 1.0f;
					text.setFont( font.deriveFont(size) );
					brojac --;
					if(brojac < 0) {
						labela.setText("Font: 0" );
					}else{
						labela.setText("Font: " + brojac);
					}
			    }
			});
		
			
		styles.addItem("serif");
		styles.addItem("dialog");
		styles.addItem("dialogInput");
		
		styles.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(styles.getSelectedItem().equals("serif")) {
					text.setFont(new Font(Font.SERIF, Font.PLAIN, brojac));
				}
				
				if(styles.getSelectedItem().equals("dialog")) {
					text.setFont(new Font(Font.DIALOG, Font.PLAIN, brojac));
				}
				
				if(styles.getSelectedItem().equals("dialogInput")) {
					text.setFont(new Font(Font.DIALOG_INPUT, Font.PLAIN, brojac));
				}
			}
		});
		
		
		toolbar.add(styles);
		toolbar.add(labela);
		toolbar.add(plusFont);
		toolbar.add(minusFont);
		toolbar.add(bold);
		toolbar.add(italic);
		toolbar.add(underline);
		
		this.add(toolbar, BorderLayout.NORTH);
		
		text = new JTextPane();
		
		JPanel dole = new JPanel(new FlowLayout());
		save = new JButton("Save");
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				saveAction();
				setVisible(false);
			}
		});
		dole.add(save);
		
		
		this.add(dole, BorderLayout.SOUTH);
		this.add(text, BorderLayout.CENTER);
		
		if(slot.getSlotType() != null) {
			TextType it = (TextType) slot.getSlotType();
			text.removeAll();
			text.setText(it.getText());
			text.setFont(it.getFont());
			brojac = it.getBrojac();
			labela.setText("Font:" + brojac);
			
			
		}
	}

	
	
	private void saveAction() {

		TextType tt = new TextType(slot);
		tt.setText(text.getText());
		tt.setFont(text.getFont());
		tt.setBrojac(brojac);
		slot.setSlotType(tt);
		
	}
	
	private Icon loadIcon(String fileName){
		URL imageURL = getClass().getResource(fileName);
		Icon icon = null;
		
		if (imageURL != null)                       
	        icon = new ImageIcon(imageURL);
		
		return icon;
	}
}
