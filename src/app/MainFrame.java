package app;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.Transferable;
import java.net.URL;

import javax.swing.*;

import menubar.view.MenuBar;
import rightPanelView.ProjectView;
import toolbar.view.Pallete;
import toolbar.view.ToolBar;
import workspace.model.Project;
import workspace.model.WorkspaceModel;
import workspace.view.WorkspaceView;

public class MainFrame extends JFrame implements ClipboardOwner{

	private static MainFrame instance = null;
	
	private MenuBar menu;
	private ToolBar toolBar;
	private Pallete pallete;
	
	private WorkspaceView workspace;
	private WorkspaceModel workspacemodel;
	
	private JSplitPane split;

	private Clipboard clipboard = new Clipboard("GeRuDok clipboard");

	private MainFrame() {
		initElements();
		addElements();
	}
	
	private void addElements() {
		setTitle("Gerudok");

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new ContextSaving(this));
		addWindowListener(new ContextOpening(this));

        setExtendedState(MAXIMIZED_BOTH);
        
        setJMenuBar(menu);
        
        split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        JScrollPane scroll = new JScrollPane(workspace);
        scroll.setMinimumSize(new Dimension(145, 145));
        split.add(scroll);
        
        add(toolBar, BorderLayout.NORTH);
        add(pallete, BorderLayout.EAST);
        add(split, BorderLayout.CENTER);
	}
	
	private void initElements() {
		menu = new MenuBar();
		toolBar = new ToolBar();
		workspacemodel = new WorkspaceModel();
		workspace = new WorkspaceView();
		workspace.setModel(workspacemodel);
		pallete = new Pallete();
		
	}
	
	public static MainFrame getMainFrame() {
		if(instance == null) {
			instance = new MainFrame();
		}
		return instance;
	}
	public MenuBar getMenu() {
		return menu;
	}

	public void setMenu(MenuBar menu) {
		this.menu = menu;
	}

	public ToolBar getToolBar() {
		return toolBar;
	}

	public void setToolBar(ToolBar toolBar) {
		this.toolBar = toolBar;
	}

	public WorkspaceView getWorkspace() {
		return workspace;
	}

	public void setWorkspace(WorkspaceView workspace) {
		this.workspace = workspace;
	}

	public WorkspaceModel getWorkspacemodel() {
		return workspacemodel;
	}

	public void setWorkspacemodel(WorkspaceModel workspacemodel) {
		this.workspacemodel = workspacemodel;
	}
	
	public void projectViewMaker(Project project) {
		
		ProjectView p = new ProjectView(project);
		ProjectView.projectViews.add(p);
	
		split.setRightComponent(p);
	}
	
	public JSplitPane getSplit() {
		return split;
	}

	public void setSplit(JSplitPane split) {
		this.split = split;
	}

	public void openProjectView(ProjectView p) {
		split.setRightComponent(p);
	}
	
	public Icon loadIcon(String fileName){
		URL imageURL = getClass().getResource(fileName);
		Icon icon = null;
		
		if (imageURL != null)                       
	        icon = new ImageIcon(imageURL);
		
		return icon;
	}
	
	public Clipboard getClipboard() {
		return clipboard;
	}

	@Override
	public void lostOwnership(Clipboard clipboard, Transferable contents) {
		// TODO Auto-generated method stub
		
	}
}
