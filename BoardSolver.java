
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

	private void rotateCounterClockwise(int x, int y) {
		boolean sideOfBoard = checkifCoordinatesonSide(x, y);
		if (sideOfBoard) {
			if (y != 0) {
				y -= 1;
			}
			x -= 1;
		}

		int temp = boardArray[x][y];
		boardArray[x][y] = boardArray[x][y + 1];
		boardArray[x][y + 1] = boardArray[x + 1][y + 1];
		boardArray[x + 1][y + 1] = boardArray[x + 1][y];
		boardArray[x + 1][y] = temp;
	}

	private boolean checkifCoordinatesonSide(int x, int y) {
		boolean sideOfBoard = false;
		if (x == board.getLength() - 1) {
			for (int i = 0; i < board.getHeight(); i++) {
				if (y == i) {
					sideOfBoard = true;
				}
			}
		}
		return sideOfBoard;
	}

	private void rotateClockwise(int x, int y) {
		boolean sideOfBoard = checkifCoordinatesonSide(x, y);
		if (sideOfBoard) {
			if (y != 0) {
				y -= 1;
			}
			x -= 1;
		}
		int temp = boardArray[x][y];
		boardArray[x][y] = boardArray[x - 1][y];
		boardArray[x - 1][y] = boardArray[x + 1][y - 1];
		boardArray[x - 1][y - 1] = boardArray[x][y - 1];
		boardArray[x][y - 1] = temp;
	}
}
