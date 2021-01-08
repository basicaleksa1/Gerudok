package slot.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import app.MainFrame;
import errorHandler.ErrorHandler;
import errorHandler.Errors;
import graphics2D.elements.PageSlot;
import slot.model.ImageType;

public class ImageTypeView extends JDialog{

	private JButton save;
	private JButton chooseImage;
	private JPanel view;
	private PageSlot slot;
	private JLabel slika;
	private ImageIcon image;
	private File file;
	private static final Dimension d = new Dimension(500, 350);
	
	public ImageTypeView(PageSlot slot) {
		super(MainFrame.getMainFrame());
		setLayout(new BorderLayout());
		setMinimumSize(d);
		this.slot = slot;
		save = new JButton("Save");
		slika = null;
		
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				saveAction();
				setVisible(false);
			}
		});
		chooseImage = new JButton("Choose image");
		chooseImage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				chooseImage();
				
			}
		});
		view = new JPanel();
		JLabel choosePic = new JLabel("Please choose an image to show");
		view.add(choosePic);
		
		JPanel buttons = new JPanel(new FlowLayout());
		buttons.add(save);
		buttons.add(chooseImage);
		
		add(buttons, BorderLayout.SOUTH);
		add(view, BorderLayout.CENTER);
		
		if(slot.getSlotType() != null) {
			ImageType it = (ImageType) slot.getSlotType();
			try {
				slika = new JLabel(new ImageIcon(setImage(it.getImage().getAbsoluteFile())));
			} catch (Exception e1) {
				ErrorHandler.handle(Errors.noImageFound);
				slot.setSlotType(null);
				return;
			}
			view.removeAll();
			view.add(slika);
		}
	}
	
	private void saveAction() {
		ImageType it = new ImageType(slot);
		it.setImage(file);
		slot.setSlotType(it);
	}
	
	private void chooseImage() {
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("*.png", "png");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(MainFrame.getMainFrame());
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			file = new File(chooser.getSelectedFile().getAbsoluteFile().toString());
			image = new ImageIcon(setImage(chooser.getSelectedFile().getAbsoluteFile()));
			slika = new JLabel(image);
			view.removeAll();
			view.add(slika, BorderLayout.NORTH);
			this.revalidate();
			this.repaint();
		}
	}
	
	private Image setImage(File file) {
		Image image = null;
		try {
			image = ImageIO.read(file);
		} catch (IOException e) {
			ErrorHandler.handle(Errors.noImageFound);
			URL imageURL = getClass().getResource("/ikonice/delete-icon.png");
			try {
				image = ImageIO.read(imageURL);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		//image = (Image) image.getScaledInstance(view.getWidth(), view.getHeight(), Image.SCALE_SMOOTH);
		return image;
	}
	

	public PageSlot getSlot() {
		return slot;
	}

	public void setSlot(PageSlot slot) {
		this.slot = slot;
	}
	
	
}
