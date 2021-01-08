package errorHandler;

import javax.swing.JOptionPane;

public class ErrorHandler {

	public static void handle(Errors e) {
		JOptionPane.showMessageDialog(null, message(e), "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	private static String message(Errors e) {
		if(e ==  Errors.nullRename) return "Please enter a valid name";
		else if(e == Errors.workspaceRename) return "You can't rename the workspace";
		else if(e == Errors.workspaceRemove) return "You can't remove the workspace";
		else if(e == Errors.nodeLeaf) return "Nothing is selected";
		else if(e == Errors.nullSelection) return "Please select a node";
		else if(e == Errors.projectSameName) return "Project with the same name already exists in the workspace";
		else if(e == Errors.documentSave) return "Please select the project you wish to save";
		else if(e == Errors.nothingSelected) return "Nothing is selected, please select something";
		else if(e == Errors.wrongFileType) return "Can't open files this type";
		else if(e == Errors.noProject) return "No project is open";
		else if(e == Errors.noImageFound) return "Image cant be found";
		else if(e == Errors.noProjectToImport) return "No projects in workspace to import documents";
		return null;
	}
}
