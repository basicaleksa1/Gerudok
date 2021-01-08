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


public class SaveAction extends MyAbstractAction {

	public SaveAction() {
		putValue(SMALL_ICON, loadIcon("/ikonice/save.png"));
		putValue(NAME, "Save");
		putValue(SHORT_DESCRIPTION, "Save");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		JFileChooser jfc = new JFileChooser();
		jfc.setFileFilter(new ProjectFileFilterAction());
		
		Project project = null;
		
		try {
			project = (Project)MainFrame.getMainFrame().getWorkspace().getLastSelectedPathComponent();
		} catch (ClassCastException e2) {
			ErrorHandler.handle(Errors.documentSave);
			return;
			//e2.printStackTrace();
		}
		
		File projectFile = null;
		try {
			projectFile = project.getFile();
		} catch (NullPointerException e2) {
			ErrorHandler.handle(Errors.nullSelection);
			return;
		}
		
		if (!project.isChanged()){
			return;
		}
		
		if (project.getFile()==null){
		         if(jfc.showSaveDialog(MainFrame.getMainFrame())==JFileChooser.APPROVE_OPTION){
		                   projectFile=jfc.getSelectedFile();           	 
		        	 
		         }else{
		        	return; 
		         }
		         
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
