package action;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;

import app.MainFrame;
import errorHandler.ErrorHandler;
import errorHandler.Errors;
import workspace.model.Project;


public class SaveAsAction extends MyAbstractAction {

	public SaveAsAction() {
		putValue(SMALL_ICON, loadIcon("/ikonice/save.png"));
		putValue(NAME, "SaveAs");
		putValue(SHORT_DESCRIPTION, "SaveAs");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		JFileChooser jfc = new JFileChooser();
		jfc.setFileFilter(new ProjectFileFilterAction());
		
		Project project = null;
		
		try {
			project = (Project)MainFrame.getMainFrame().getWorkspace().getLastSelectedPathComponent();
		} catch (Exception e2) {
			ErrorHandler.handle(Errors.documentSave);
			return;
		}
		
		File projectFile = null;
		
		if (project.getFile()!=null){
		         if(jfc.showSaveDialog(MainFrame.getMainFrame())==JFileChooser.APPROVE_OPTION){
		                   projectFile=jfc.getSelectedFile();           	 
		        	 
		         }else{
		        	return; 
		         }
		         
		}else {
			return;
		}
	      
		         
	    ObjectOutputStream os;
		try {
			os = new ObjectOutputStream(new FileOutputStream(projectFile));
			os.writeObject(project);
			project.setFile(projectFile);
			project.setChanged(false);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
			
	
	}
	
}
