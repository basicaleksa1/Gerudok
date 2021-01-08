package action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import menubar.view.AboutView;

public class AboutAction extends MyAbstractAction {

	public AboutAction() {
		putValue(NAME, "About");
		putValue(SHORT_DESCRIPTION, "About");
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		AboutView about = new AboutView();
		about.show();
		
	}
}
