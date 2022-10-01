import java.util.Scanner;

public class Twiddle {

	public static void main(String[] args) {

		int choice;
		int length;
		int height;

		Scanner key = new Scanner(System.in);
		do {
			System.out.print("Enter the Length of the board: ");
			length = key.nextInt();
			System.out.print("Enter the height of the board: ");
			height = key.nextInt();
		} while (!(length > 2 && height > 2));
		Board board = new Board(length, height);
		do {
			System.out.println("What would you like to do? Choose a Number: ");
			System.out.println("1. Set values");
			System.out.println("2. Make a random Board");
			System.out.println("3. Solve the board");
			System.out.println("4. Solve the board efficiently");
			System.out.println("5. Print out the board");
			System.out.println("6. Exit");
			choice = key.nextInt();
			switch (choice) {
				case 1:
					System.out.println("Enter the values of the board: ");
					int input = key.nextInt();
					int inputLength = Integer.toString(input).length();
					if (inputLength > 1) {
						if (inputLength == board.getSize()) {
							for (int j = height - 1; j >= 0; j--) {
								for (int i = length - 1; i >= 0; i--) {
									board.set(i, j, input % 10);
									input /= 10;
								}
							}

						} else {

						}

					} else {
						for (int i = 0; i < length; i++) {
							for (int j = 0; j < height; j++) {
								board.set(i, j, key.nextInt());
							}
						}
					}
					break;
				case 2:

					System.out.println(
							"Do you want have a Rows Only board, Columns Only board, or Rows and Columns board?");
					System.out.println("1. Rows Only");
					System.out.println("2. Columns Only");
					System.out.println("3. Both");
					int choice2 = key.nextInt();
					switch (choice2) {
						case 1:
							board = board.randomizeRowColumn(true, false);
							break;
						case 2:
							board = board.randomizeRowColumn(false, true);
							break;
						case 3:
							board = board.randomizeRowColumn(true, true);
							break;
						default:
							System.out.println("Invalid Choice");
							break;
					}
					board.print();
					break;
				case 3:
					if (checkBoard(board)) {
						System.out.println("The board is empty or contains a zero. Please enter a valid board.");
					} else {
						BoardSolver solver = new BoardSolver(board);
						solver.solve();
					}
					break;

				case 4:

					if (checkBoard(board)) {
						System.out.println("The board is empty or contains a zero. Please enter a valid board.");
					} else {
						BoardSolver solver2 = new BoardSolver(board);
						solver2.solveEfficiently();
					}
					break;

				case 5:
					board.print();
					break;
				case 6:
					System.out.println("Goodbye!");
					break;
				default:
					System.out.println("Invalid Choice");
					break;

			}
		} while (choice != 6);

		key.close();

	}

	/**
	 * Checks if the board is empty or contains a zero
	 * 
	 * @param board
	 * @return true if the board is empty or contains a zero
	 */
	private static boolean checkBoard(Board board) {
		if (board.isEmpty() || board.containsZero()) {
			return true;
		}
		return false;
	}

}
