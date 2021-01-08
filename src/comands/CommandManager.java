package comands;

import java.util.ArrayList;

import action.ActionManager;

public class CommandManager {

	private ArrayList<AbstractCommand> commands;
	
	public CommandManager() {
		commands = new ArrayList<AbstractCommand>();
	}
	
	private int currentCommand = 0;
	
	public void addCommand(AbstractCommand command) {
		while(currentCommand < commands.size())
			commands.remove(currentCommand);
		commands.add(command);
		doCommand();
	}
	
	
	public void doCommand() {
		if(currentCommand < commands.size()) {
			commands.get(currentCommand++).doCommand();
			ActionManager.getInstance().getUndoAction().setEnabled(true);
		}
		
		if(currentCommand == commands.size()) {
			ActionManager.getInstance().getRedoAction().setEnabled(false);
		}
	}
	
	public void undoCommand() {
		if(currentCommand > 0) {
			ActionManager.getInstance().getRedoAction().setEnabled(true);
			commands.get(--currentCommand).undoCommand();
		}
		
		if(currentCommand == 0) {
			ActionManager.getInstance().getUndoAction().setEnabled(false);
		}
	}
	
}
