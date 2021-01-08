package menubar.view;

import javax.swing.*;



import app.MainFrame;

import java.awt.*;
import java.net.URL;

public class AboutView extends JDialog{
	
	public AboutView() {
		super(MainFrame.getMainFrame(), "About");
		BoxLayout box = new BoxLayout(this.getContentPane(),BoxLayout.X_AXIS);
		this.setLayout(box);
		add(Box.createHorizontalStrut(30));
		add(rastkoSplit());
		add(Box.createHorizontalStrut(30));
		add(aleksaSplit());
		this.setSize(700, 500);
	}
	
	
	
	private JPanel rastkoSplit() {
		JPanel panel = new JPanel();
		BoxLayout box = new BoxLayout(panel,BoxLayout.Y_AXIS);
		panel.setLayout(box);
		URL link = getClass().getResource("/Slike/Rastko.jpg");
		ImageIcon slika = new ImageIcon(link);
		JLabel lSlika = (new JLabel(slika));
		lSlika.setPreferredSize(new Dimension(200,200));
		panel.add(lSlika);
		panel.add(Box.createVerticalStrut(30));
		JLabel lIme = new JLabel("Rastko Aleksandar Naunovic");
		lIme.setFont(new Font(lIme.getFont().getName(),lIme.getFont().getStyle(),20));
		lIme.setForeground(Color.BLUE);
		panel.add(lIme);
		panel.add(Box.createVerticalStrut(30));
		JLabel lIndeks = new JLabel("RN107/19");
		lIndeks.setForeground(Color.RED);
		panel.add(lIndeks);
		return panel;
	}



	private JPanel aleksaSplit() {
		JPanel panel = new JPanel();
		BoxLayout box = new BoxLayout(panel,BoxLayout.Y_AXIS);
		panel.setLayout(box);
		URL link = getClass().getResource("/Slike/Aleksa.jpg");
		ImageIcon slika = new ImageIcon(link);
		JLabel lSlika = (new JLabel(slika));
		lSlika.setPreferredSize(new Dimension(200,200));
		panel.add(lSlika);
		panel.add(Box.createVerticalStrut(30));
		JLabel lIme = new JLabel("Aleksa Basic");
		lIme.setFont(new Font(lIme.getFont().getName(),lIme.getFont().getStyle(),20));
		lIme.setForeground(Color.BLUE);
		panel.add(lIme);
		panel.add(Box.createVerticalStrut(30));
		JLabel lIndeks = new JLabel("RN86/19");
		lIndeks.setForeground(Color.RED);
		panel.add(lIndeks);
		return panel;
	}
}
