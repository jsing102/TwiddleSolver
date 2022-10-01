public class BoardSolver {

	private Board board;
	private int[][] boardArray;

	public BoardSolver(Board board) {
		this.board = board;
		boardArray = new int[board.getLength()][board.getHeight()];
		init();
	}

	private void init() {
		for (int i = 0; i < board.getLength(); i++) {
			for (int j = 0; j < board.getHeight(); j++) {
				boardArray[i][j] = board.get(i, j);
			}
		}
	}

	// return something
	void solve() {
		System.out.println("Solving...");

	}

	// return something
	void solveEfficiently() {
		System.out.println("Solving efficiently...");
	}
}
