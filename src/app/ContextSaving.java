package app;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import action.ActionManager;

public class ContextSaving extends WindowAdapter {

	private JFrame frame;
	
	public ContextSaving(JFrame frame) {
		this.frame = frame;
	}
	
	
	public void windowClosing(WindowEvent windowEvent) {
		
		
		Object[] choice = {"Yes","No","Cancel"};
		
		int answer = JOptionPane.showOptionDialog(frame, "Do you wish to save the current workspace", "Exit", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, choice, choice[0]);
		
		if(answer == JOptionPane.YES_OPTION) {
			ActionManager.getInstance().getSaveWorkspace().actionPerformed(windowEvent);
			frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			//System.exit(0);
		}
		else if(answer == JOptionPane.NO_OPTION) {
			frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			//System.exit(0);
		}
		else if(answer == JOptionPane.CANCEL_OPTION) {
			return;
		}
		
	}
	
	
	
}
