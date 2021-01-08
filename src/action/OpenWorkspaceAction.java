package action;

import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

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

public class OpenWorkspaceAction extends MyAbstractAction{

	
	public OpenWorkspaceAction() {
		putValue(SMALL_ICON, loadIcon("/ikonice/switchIcon.png"));
		putValue(NAME, "Switch workspace");
		putValue(SHORT_DESCRIPTION, "Switch workspace");
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		JFileChooser jfc = new JFileChooser();
		jfc.setFileFilter(new WorkspaceFileFilter());
		
		if(jfc.showOpenDialog(MainFrame.getMainFrame())==JFileChooser.APPROVE_OPTION){
			try {
				ObjectInputStream os = new ObjectInputStream(new FileInputStream(jfc.getSelectedFile()));
				System.out.println("usao u try za otvaranje workspace");
				Workspace w = null;
				try {
					w = (Workspace) os.readObject();
					System.out.println(w.toString());
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			    // override - ovati equals metodu u klasi projekat tako da funcionise po imenu npr
				
				boolean exists = false;
			    
				if(exists == false) {
					MainFrame.getMainFrame().getWorkspacemodel().setRoot(w);
					w.setFile(jfc.getSelectedFile());
					
					for(Project p : w.getProjects()) {
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
