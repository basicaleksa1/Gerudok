package action;

import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;

import app.MainFrame;
import errorHandler.ErrorHandler;
import errorHandler.Errors;
import rightPanelView.DocumentView;
import rightPanelView.PageView;
import rightPanelView.ProjectView;
import rightPanelView.SmallPage;
import workspace.model.Document;
import workspace.model.Page;
import workspace.model.Project;
import workspace.model.Workspace;



public class OpenProjectAction extends MyAbstractAction {

	public OpenProjectAction() {
		putValue(SMALL_ICON, loadIcon("/ikonice/openProject.png"));
		putValue(NAME, "Open project");
		putValue(SHORT_DESCRIPTION, "Open project");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		JFileChooser jfc = new JFileChooser();
		jfc.setFileFilter(new ProjectFileFilterAction());
		
		if(jfc.showOpenDialog(MainFrame.getMainFrame())==JFileChooser.APPROVE_OPTION){
			try {
				ObjectInputStream os = new ObjectInputStream(new FileInputStream(jfc.getSelectedFile()));
				System.out.println("usao u try za otvaranje projekta");
				Project p=null;
				try {
					p = (Project) os.readObject();
					System.out.println(p.toString());
				} catch (ClassNotFoundException | ClassCastException e1) {
					ErrorHandler.handle(Errors.wrongFileType);
					return;
				}
				p.setFile(jfc.getSelectedFile());
				
				boolean exists = false;
			    for(Project pr: ((Workspace)MainFrame.getMainFrame().getWorkspacemodel().getRoot()).getProjects()) {
			    	if(pr.toString().equalsIgnoreCase(p.toString())) {
			    		ErrorHandler.handle(Errors.projectSameName);
			    		exists = true;
			    		break;
			    	}
			    }
				if(exists == false) {
					((Workspace)MainFrame.getMainFrame().getWorkspacemodel().getRoot()).add(p);
					p.setParenta((Workspace)MainFrame.getMainFrame().getWorkspacemodel().getRoot());
					System.out.println(p.getParent().toString());
					ProjectView pv = new ProjectView(p);
					ProjectView.projectViews.add(pv);
					MainFrame.getMainFrame().getSplit().setRightComponent(pv);
					for(Document d: pv.getProject().getDocuments()) {
						DocumentView dView = new DocumentView(d);
						for(Page page: d.getPages()) {
							if(!(d.getChildCount() == 0) && !(d.getChildCount() == dView.getPageCounter())) {
								PageView pView = new PageView(page);
								SmallPage sp = new SmallPage(page,pView,dView);
								dView.getSplit().setRightComponent(pView);
								dView.getPanj().add(sp);
								dView.getSmallPages().add(sp);
								dView.getPages().add(pView);
								dView.setPageCounter(dView.getPageCounter() + 1);
								dView.revalidate();
								dView.repaint();
							}
						}
						pv.getDocumentViews().add(dView);
						pv.getDocuments().addTab(dView.getName(), dView);
					}
				}
				SwingUtilities.updateComponentTreeUI(MainFrame.getMainFrame().getWorkspace());
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			} 
		
		}
	
	}

}
