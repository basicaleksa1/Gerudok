package state;

import java.awt.Point;

import workspace.model.Page;

public interface IState {

	void mousePressed(Point point, Page page, Point currentPoint);
	
	void mouseDragged(Point clicked, Point current, Page page);
	
	void mouseReleased(Point point, Page page);
}
