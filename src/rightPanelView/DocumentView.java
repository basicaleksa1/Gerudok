package rightPanelView;

import javax.swing.*;

import action.ActionEnum;
import app.MainFrame;
import observer.IListener;
import workspace.model.Document;
import workspace.model.Page;
import workspace.model.Project;

import java.awt.*;
import java.util.ArrayList;

public class DocumentView extends JPanel implements IListener{
	
	private Document document;
	private JLabel name;
	private ArrayList<PageView> pages;
	private int pageCounter = 0;
	private ArrayList<SmallPage> smallPages;
	private JSplitPane split;
	private JScrollPane scroll;
	private JPanel panel;
	
	private JPanel panj;

	public DocumentView(Document document) {
		super(new BorderLayout());
		this.document = document;
		pages = new ArrayList<PageView>();
		smallPages = new ArrayList<SmallPage>();
		split = new JSplitPane();
		scroll = new JScrollPane();
		panel = new JPanel();
		GridLayout grid = new GridLayout(0, 1);
		grid.setVgap(20);
		panj = new JPanel(grid);
		scroll.setViewportView(panj);
		
		split.setLeftComponent(scroll);
		split.setRightComponent(panel);
		
		scroll.setMinimumSize(new Dimension(145, 145));
		panel.setMinimumSize(new Dimension(800, 500));
		
		name = new JLabel(document.toString());		
		document.addListener(this);
		
		add(split);
	}

	public JPanel getPanel() {
		return panel;
	}
	
	public JSplitPane getSplit() {
		return split;
	}

	public void setSplit(JSplitPane split) {
		this.split = split;
	}

	public ArrayList<SmallPage> getSmallPages() {
		return smallPages;
	}

	public void setSmallPages(ArrayList<SmallPage> smallPages) {
		this.smallPages = smallPages;
	}

	public String getName() {
		return name.getText();
	}

	public void setName(JLabel name) {
		this.name = name;
	}
	
	public ArrayList<PageView> getPages() {
		return pages;
	}

	public void setPages(ArrayList<PageView> pages) {
		this.pages = pages;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public JScrollPane getScroll() {
		return scroll;
	}

	public void setScroll(JScrollPane scroll) {
		this.scroll = scroll;
	}

	public int getPageCounter() {
		return pageCounter;
	}

	public void setPageCounter(int pageCounter) {
		this.pageCounter = pageCounter;
	}

	private void renameDocument() {
		Project p = (Project) document.getParent();
		
		for(ProjectView projectView: ProjectView.projectViews) {
			if(projectView.getProject().equals(p)) {
				projectView.getDocuments().setTitleAt(p.getIndex(document), document.getName());
				((DocumentView)projectView.getDocumentViews().get(p.getIndex(document))).setName(new JLabel(document.getName()));
			}
		}
	}
	
	private void removePage() {
		try {
			Page p = (Page) MainFrame.getMainFrame().getWorkspace().getSelectionPath().getLastPathComponent();
			Document d = (Document)p.getParent();
			
			if(split.getRightComponent() instanceof PageView) {
				if(((PageView)split.getRightComponent()).getPage() == p) {
					split.setRightComponent(new JPanel());
				}
			}
			this.getPanj().remove(this.getSmallPages().get(d.getIndex(p)));
			this.revalidate();
			this.repaint();
			this.setPageCounter(this.getPageCounter() - 1);
			this.getPages().remove(this.getPages().get(d.getIndex(p)));
			getSmallPages().remove(this.getSmallPages().get(d.getIndex(p)));
		} catch (IndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
		}
		
	}
	
	public JPanel getPanj() {
		return panj;
	}

	private void addPage() {
		System.out.println("uso u add page metodu");
		if(!(document.getChildCount() == 0) && !(document.getChildCount() == pageCounter)) {
			System.out.println("usao u if");
			PageView p = new PageView((Page) document.getChildAt(document.getChildCount() - 1));
			SmallPage sp = new SmallPage((Page) document.getChildAt(document.getChildCount() - 1), p, this);
			split.setRightComponent(p);
			pages.add(p);
			smallPages.add(sp);
			panj.add(sp);
			pageCounter++;
			revalidate();
			repaint();
		}
	}
	
	@Override
	public void update(Object event) {
		Project pr = (Project)this.document.getParent();
		pr.setChanged(true);
		if(event == ActionEnum.ACTION_ADD)
			addPage();

		else if(event == ActionEnum.ACTION_RENAME) {
			renameDocument();
		}
		else if(event == ActionEnum.ACTION_REMOVE) 
			removePage();
		System.out.println("Uradio update za document view");
	}
	
}
