package rightPanelView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import observer.IListener;
import workspace.model.Page;

public class SmallPage extends JPanel implements IListener{

	private JLabel pageName;
	private Page page;
	private PageView pv;

	public SmallPage(Page page, PageView pv, DocumentView dv) {
		pageName = new JLabel(page.getName());
		this.page = page;
		this.pv = pv;
		page.addListener(this);
		setLayout(new BorderLayout());
		add(pageName, BorderLayout.CENTER);
		setBackground(Color.lightGray);
		setPreferredSize(new Dimension(50, 50));
		
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2) {
					dv.getSplit().setRightComponent(pv);
				}
				
			}
		});
		
	}

	public JLabel getPageName() {
		return pageName;
	}

	public void setPageName(JLabel pageName) {
		this.pageName = pageName;
	}

	@Override
	public void update(Object event) {
		pageName.setText(page.getName());
		
	}
	
	public PageView getPv() {
		return pv;
	}

	public void setPv(PageView pv) {
		this.pv = pv;
	}

}
