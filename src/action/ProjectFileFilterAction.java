package action;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class ProjectFileFilterAction extends FileFilter {

	@Override
	public String getDescription() {
		return "GeRuDok Project File (*.gpf)";
	}

	@Override
	public boolean accept(File f) {
		return (f.isDirectory() || 
                f.getName().toLowerCase().endsWith(".gpf"));
	}


}