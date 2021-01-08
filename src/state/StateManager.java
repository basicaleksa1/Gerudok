package state;

public class StateManager {

	private CircleState circleState;
	private RectangleState rectangleState;
	private RotateState rotateState;
	private ResizeState resizeState;
	private TriangleState triangleState;
	private MoveState moveState;
	private SelectState selectState;
	private DeleteState deleteState;
	
	private IState currentState;
	
	public StateManager() {
		circleState = new CircleState();
		rectangleState = new RectangleState();
		rotateState = new RotateState();
		resizeState = new ResizeState();
		triangleState = new TriangleState();
		moveState = new MoveState();
		selectState = new SelectState();
		deleteState = new DeleteState();
		
		currentState = rectangleState;
	}

	public CircleState getCircleState() {
		return circleState;
	}

	public void setCircleState(CircleState circleState) {
		this.circleState = circleState;
	}

	public RectangleState getRectangleState() {
		return rectangleState;
	}

	public void setRectangleState(RectangleState rectangleState) {
		this.rectangleState = rectangleState;
	}

	public RotateState getRotateState() {
		return rotateState;
	}

	public void setRotateState(RotateState rotateState) {
		this.rotateState = rotateState;
	}

	public ResizeState getResizeState() {
		return resizeState;
	}

	public void setResizeState(ResizeState resizeState) {
		this.resizeState = resizeState;
	}

	public TriangleState getTriangleState() {
		return triangleState;
	}

	public void setTriangleState(TriangleState triangleState) {
		this.triangleState = triangleState;
	}

	public IState getCurrentState() {
		return currentState;
	}

	public void setCurrentState(IState currentState) {
		this.currentState = currentState;
	}

	public MoveState getMoveState() {
		return moveState;
	}

	public void setMoveState(MoveState moveState) {
		this.moveState = moveState;
	}

	public SelectState getSelectState() {
		return selectState;
	}

	public void setSelectState(SelectState selectState) {
		this.selectState = selectState;
	}

	public DeleteState getDeleteState() {
		return deleteState;
	}

	public void setDeleteState(DeleteState deleteState) {
		this.deleteState = deleteState;
	}

}
