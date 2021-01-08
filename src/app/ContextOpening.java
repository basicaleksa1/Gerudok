package app;

import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import action.ActionManager;


public class ContextOpening extends WindowAdapter {

	private JFrame frame;
	
	public ContextOpening(JFrame frame) {
		this.frame = frame;
	}
	
	public void windowOpened(WindowEvent windowEvent) {
		
		Object[] options = {"Yes","No"};
		
		int answer = JOptionPane.showOptionDialog(frame, "Would you like to open one of the previous workspace?", "Open previous workspace", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		
		ActionEvent a = new ActionEvent(options, answer, null);
		
		if(answer == JOptionPane.YES_OPTION) {
			ActionManager.getInstance().getOpenWorkspace().actionPerformed(a);
		}
		else if(answer == JOptionPane.NO_OPTION) {
			return;
		}
	}
		
		
		
}
