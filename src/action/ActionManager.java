package action;

public class ActionManager {

	private static ActionManager instance;
	
	private NewAction newAction;
	private AboutAction aboutAction;
	private RemoveAction removeAction;
	private CloseAction closeAction;
	private CloseAllAction closeAllAction;
	private DrawTriangle drawTriangle;
	private DrawCircle drawCircle;
	private DrawRectangle drawRectangle;
	private SaveAction saveAction;
	private RotateAction rotateAction;
	private ResizeAction resizeAction;
	private SaveAsAction saveAsAction;
	private OpenProjectAction openProject;
	private SaveWorkspaceAction saveWorkspace;
	private OpenWorkspaceAction openWorkspace;
	private DragAction dragAction;

	private CutAction cutAction;
	private CopyAction copyAction;
	private PasteAction pasteAction;

	private SelectAction selectAction;
	private DeleteElementAction deleteElementAction;
	
	public UndoAction undoAction;
	public RedoAction redoAction;

	
	

	private ActionManager() {
		init();
	}

	private void init() {
		newAction = new NewAction();
		aboutAction = new AboutAction();
		removeAction = new RemoveAction();
		closeAction = new CloseAction();
		closeAllAction = new CloseAllAction();
		drawTriangle = new DrawTriangle();
		drawCircle = new DrawCircle();
		drawRectangle = new DrawRectangle();
		saveAction = new SaveAction();

		rotateAction = new RotateAction();
		resizeAction = new ResizeAction();
		dragAction = new DragAction();
		deleteElementAction = new DeleteElementAction();

		saveAsAction = new SaveAsAction();
		openProject = new OpenProjectAction();
		saveWorkspace = new SaveWorkspaceAction();
		openWorkspace = new OpenWorkspaceAction();

		
		cutAction = new CutAction();
		copyAction = new CopyAction();
		pasteAction = new PasteAction();
		
		undoAction = new UndoAction();
		undoAction.setEnabled(false);
		redoAction = new RedoAction();
		redoAction.setEnabled(false);

		setSelectAction(new SelectAction());

	}


	public OpenWorkspaceAction getOpenWorkspace() {
		return openWorkspace;
	}

	public void setOpenWorkspace(OpenWorkspaceAction openWorkspace) {
		this.openWorkspace = openWorkspace;
	}

	public SaveWorkspaceAction getSaveWorkspace() {
		return saveWorkspace;
	}

	public void setSaveWorkspace(SaveWorkspaceAction saveWorkspace) {
		this.saveWorkspace = saveWorkspace;
	}

	public ResizeAction getResizeAction() {
		return resizeAction;
	}

	public void setResizeAction(ResizeAction resizeAction) {
		this.resizeAction = resizeAction;
	}
	

	public RotateAction getRotateAction() {
		return rotateAction;
	}

	public void setRotateAction(RotateAction rotateAction) {
		this.rotateAction = rotateAction;
	}

	public static ActionManager getInstance() {
		if(instance == null) 
			instance = new ActionManager();
		return instance;
	}

	public NewAction getNewAction() {
		return newAction;
	}

	public void setNewAction(NewAction newAction) {
		this.newAction = newAction;
	}
	
	public AboutAction getAboutAction() {
		return aboutAction;
	}

	public void setAboutAction(AboutAction aboutAction) {
		this.aboutAction = aboutAction;
	}

	public RemoveAction getRemoveAction() {
		return removeAction;
	}

	public void setRemoveAction(RemoveAction removeAction) {
		this.removeAction = removeAction;
	}
	
	public CloseAllAction getCloseAllAction() {
		return closeAllAction;
	}

	public void setCloseAllAction(CloseAllAction closeAllAction) {
		this.closeAllAction = closeAllAction;
	}

	public CloseAction getCloseAction() {
		return closeAction;
	}

	public void setCloseAction(CloseAction closeAction) {
		this.closeAction = closeAction;
	}

	public DrawTriangle getDrawTriangle() {
		return drawTriangle;
	}

	public void setDrawTriangle(DrawTriangle drawTriangle) {
		this.drawTriangle = drawTriangle;
	}

	public DrawCircle getDrawCircle() {
		return drawCircle;
	}

	public void setDrawCircle(DrawCircle drawCircle) {
		this.drawCircle = drawCircle;
	}

	public DrawRectangle getDrawRectangle() {
		return drawRectangle;
	}

	public void setDrawRectangle(DrawRectangle drawRectangle) {
		this.drawRectangle = drawRectangle;
	}
	
	public SaveAsAction getSaveAsAction() {
		return saveAsAction;
	}

	public void setSaveAsAction(SaveAsAction saveAsAction) {
		this.saveAsAction = saveAsAction;
	}

	public SaveAction getSaveAction() {
		return saveAction;
	}

	public void setSaveAction(SaveAction saveAction) {
		this.saveAction = saveAction;
	}
	

	public OpenProjectAction getOpenProject() {
		return openProject;
	}

	public void setOpenProject(OpenProjectAction openProject) {
		this.openProject = openProject;
	}

	public DragAction getDragAction() {
		return dragAction;
	}

	public void setDragAction(DragAction dragAction) {
		this.dragAction = dragAction;
	}
	

	public CutAction getCutAction() {
		return cutAction;
	}

	public void setCutAction(CutAction cutAction) {
		this.cutAction = cutAction;
	}

	public CopyAction getCopyAction() {
		return copyAction;
	}

	public void setCopyAction(CopyAction copyAction) {
		this.copyAction = copyAction;
	}

	public PasteAction getPasteAction() {
		return pasteAction;
	}

	public void setPasteAction(PasteAction pasteAction) {
		this.pasteAction = pasteAction;
	}

	public SelectAction getSelectAction() {
		return selectAction;
	}

	public void setSelectAction(SelectAction selectAction) {
		this.selectAction = selectAction;
	}

	public DeleteElementAction getDeleteElementAction() {
		return deleteElementAction;
	}

	public void setDeleteElementAction(DeleteElementAction deleteElementAction) {
		this.deleteElementAction = deleteElementAction;
	}
	
	public UndoAction getUndoAction() {
		return undoAction;
	}

	public void setUndoAction(UndoAction undoAction) {
		this.undoAction = undoAction;
	}

	public RedoAction getRedoAction() {
		return redoAction;
	}

	public void setRedoAction(RedoAction redoAction) {
		this.redoAction = redoAction;
	}
}
