import java.util.HashSet;
import java.util.Set;

public class Board {

	private int[][] board;
	private int size;
	private int length;
	private int height;

	public Board(int len, int hei) {
		length = len;
		height = hei;
		this.size = len * hei;
		board = new int[len][hei];
	}

	public int getSize() {
		return size;
	}

	public int getLength() {
		return length;
	}

	public int getHeight() {
		return height;
	}

	/**
	 * Gets the value of the board at (x,y)
	 * 
	 * @param x
	 * @param y
	 * @return the value at the given coordinates x,y
	 */
	public int get(int x, int y) {
		return board[x][y];
	}

	/**
	 * Sets the value of the board at (x,y)
	 * 
	 * @param x
	 * @param y
	 * @param value
	 */
	public void set(int x, int y, int value) {
		board[x][y] = value;
	}

	/**
	 * Checks if the board is null or the size is zero
	 * Should return true if the board was never initialized or the length and
	 * height are zero
	 * 
	 * @return true if the board is null or the size is zero
	 */

	public boolean isEmpty() {
		if (size == 0 || board == null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Checks to see if the board contains zeroes (if it does, then the board is not
	 * initializes) and returns true if it does.
	 * 
	 * @return true if the board contains zeroes, false if it does not.
	 */

	public boolean containsZero() {
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < height; j++) {
				if (board[i][j] == 0) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Prints the board to the console
	 */
	public void print() {
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < height; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	// fix the method to actually set the rows/columns to be valid, being 1-9 for
	// both rows and columns or 1-3 if only rows or columns are being randomized
	public Board randomizeRowColumn(boolean rows, boolean columns) {
		Set<Integer> rowSet = new HashSet<Integer>();
		Set<Integer> columnSet = new HashSet<Integer>();
		Set<Integer> rowAndColumnSet = new HashSet<Integer>();
		int counter = 1;

		if (rows && !columns) {

			for (int i = 0; i < length; i++) {
				while (rowSet.size() < length) {
					rowSet.add(counter);
					counter++;
				}
				for (int j = 0; j < height; j++) {
					board[i][j] = rowSet.iterator().next();
					rowSet.remove(board[i][j]);
				}
			}
		}
		if (columns && !rows) {
			for (int i = 0; i < length; i++) {
				while (columnSet.size() < height) {
					columnSet.add(counter);
					counter++;
				}
				for (int j = 0; j < height; j++) {
					board[j][i] = columnSet.iterator().next();
					columnSet.remove(board[j][i]);
				}
			}
		}

		if (rows && columns) {
			for (int i = 0; i < length; i++) {
				while (rowAndColumnSet.size() < size) {
					rowAndColumnSet.add(counter);
					counter++;
				}
				for (int j = 0; j < height; j++) {
					board[i][j] = rowAndColumnSet.iterator().next();
					rowAndColumnSet.remove(board[i][j]);
				}
			}
		}
		return this;
	}
}
