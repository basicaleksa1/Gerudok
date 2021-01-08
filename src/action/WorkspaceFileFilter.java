package action;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class WorkspaceFileFilter extends FileFilter {

	@Override
	public String getDescription() {
		return "GeRuDok Workspace File (*.gwf)";
	}

	@Override
	public boolean accept(File f) {
		return (f.isDirectory() || 
                f.getName().toLowerCase().endsWith(".gwf"));
	}
}
