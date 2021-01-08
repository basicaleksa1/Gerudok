package action;

import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;

import app.MainFrame;
import workspace.model.Project;
import workspace.model.Workspace;

public class SaveWorkspaceAction {

	public void actionPerformed(WindowEvent e) {

		JFileChooser jfc = new JFileChooser();
		jfc.setFileFilter(new WorkspaceFileFilter());
		
		Workspace workspace=(Workspace) MainFrame.getMainFrame().getWorkspacemodel().getRoot();
		File workspaceFile=workspace.getFile();
		
		if(workspace.getFile()==null){
		         if(jfc.showSaveDialog(MainFrame.getMainFrame())==JFileChooser.APPROVE_OPTION){
		                   workspaceFile=jfc.getSelectedFile();           	 
		        	 
		         }else{
		        	return; 
		         }
		         
		}     
	      
		         
	    ObjectOutputStream os;
		try {
			os = new ObjectOutputStream(new FileOutputStream(workspaceFile));
			os.writeObject(workspace);
			workspace.setFile(workspaceFile);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
			
	
	}
}
