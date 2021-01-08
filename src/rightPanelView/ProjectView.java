package rightPanelView;

import javax.swing.*;

import action.ActionEnum;
import app.MainFrame;
import comands.CommandManager;
import observer.IListener;
import state.StateManager;
import workspace.model.Document;
import workspace.model.Project;

import java.awt.*;
import java.util.ArrayList;

public class ProjectView extends JPanel implements IListener{

	private JLabel projectName;
	private JTabbedPane documents;
	private Project project;
	public static ArrayList<ProjectView> projectViews = new ArrayList<ProjectView>();
	private ArrayList<DocumentView> documentViews;
	private StateManager stateManager;
	
	public ProjectView(Project project) {
		this.project = project;
		this.project.addListener(this);
		documentViews = new ArrayList<DocumentView>();
		stateManager = new StateManager();
		projectName = new JLabel(project.getName());
		
		this.setLayout(new BorderLayout());
		
		JPanel panel = new JPanel(new BorderLayout());

		documents = new JTabbedPane(JTabbedPane.TOP);
		
		panel.add(documents, BorderLayout.CENTER);
		add(panel, BorderLayout.CENTER);
		add(projectName, BorderLayout.NORTH);
	}

	public void setDeleteState() {
		stateManager.setCurrentState(stateManager.getDeleteState());
	}
	
	public void setSelectState() {
		stateManager.setCurrentState(stateManager.getSelectState());
	}
	
	public void setMoveState() {
		stateManager.setCurrentState(stateManager.getMoveState());
	}
	
	public void setTriangleState() {
		stateManager.setCurrentState(stateManager.getTriangleState());
	}
	
	public void setCircleState() {
		stateManager.setCurrentState(stateManager.getCircleState());
	}
	
	public void setRectangleState() {
		stateManager.setCurrentState(stateManager.getRectangleState());
	}
	
	public void setResizeState() {
		stateManager.setCurrentState(stateManager.getResizeState());
	}
	
	public void setRotateState() {
		stateManager.setCurrentState(stateManager.getRotateState());
	}
	
	public StateManager getStateManager() {
		return stateManager;
	}

	public void setStateManager(StateManager stateManager) {
		this.stateManager = stateManager;
	}

	public JLabel getProjectName() {
		return projectName;
	}

	public void setProjectName(JLabel projectName) {
		this.projectName = projectName;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
	

	public JTabbedPane getDocuments() {
		return documents;
	}

	public void setDocuments(JTabbedPane documents) {
		this.documents = documents;
	}
	
	public ArrayList<DocumentView> getDocumentViews() {
		return documentViews;
	}

	public void setDocumentViews(ArrayList<DocumentView> documentViews) {
		this.documentViews = documentViews;
	}
	
	public void addClickedTab(Document document) {
		documents.removeAll();
		for(DocumentView d: documentViews) {
			documents.add(d);
		}
	}
	
	private void addTab() {
		
		//if(!(documents.getTabCount() == project.getChildCount())) {
			Document d = (Document)project.getChildAt(project.getChildCount() - 1);
			DocumentView dView = new DocumentView(d);
			documentViews.add(dView);
			documents.addTab(dView.getName(), dView);
		//}
	}

	private void removeTab() {
		Document d = (Document) MainFrame.getMainFrame().getWorkspace().getSelectionPath().getLastPathComponent();
		Project p = (Project) d.getParent();
		

		this.getDocumentViews().remove(p.getIndex(d));
		try {
			this.getDocuments().remove(p.getIndex(d));
		} catch(IndexOutOfBoundsException e) {
			System.out.println("Special case...");
		}
		
		/*for(ProjectView pView: ProjectView.projectViews) {
			if(pView.getProject().equals(p)) {
				pView.getDocuments().remove(p.getIndex(d));
				pView.getDocumentViews().remove(p.getIndex(d));
			}
		}*/
	}
	
	@Override
	public void update(Object event) {
		this.project.setChanged(true);
		if(event == ActionEnum.ACTION_ADD) {
			addTab();
		}
		else if(event == ActionEnum.ACTION_RENAME) {
			projectName.setText(project.getName());
		}
		else if(event == ActionEnum.ACTION_REMOVE) {
			removeTab();
		}
		System.out.println("radi observer");
	}
	
}
