import java.util.ArrayList;


public class Helpers {

	public static boolean isCorrect(SudokuCell [][] board){
		for (int i = 0; i < board.length; i++)
			if (!isCorrectCol(board, i) || !isCorrectRow(board, i))
				return false;
		for (int row = 0; row < board.length; row += 3)
			for (int col = 0; col < board.length; col += 3)
				if (!isCorrectBox(board, row, col))
					return false;
		
		return true;
	}
	
	public static boolean isSafe(SudokuCell [][] board, int num, int row, int col) {
		return (!usedInCol(board, num, col) && !usedInRow(board, num, row) && !usedInBox(board, num, row - row%3, col - col%3));
	}
	
	private static boolean isCorrectCol(SudokuCell [][] board, int col) {
		ArrayList<Integer> availableNumbers = new ArrayList<Integer>();
		for (int i = 1; i <= board.length; i++)
			availableNumbers.add(i);
		
		for (int row = 0; row < board.length; row++)
			availableNumbers.remove(new Integer(board[row][col].get()));
		
		if (availableNumbers.size() == 0)
			return true;
		
		return false;
			
	}
	
	private static boolean isCorrectRow(SudokuCell [][] board, int row) {
		ArrayList<Integer> availableNumbers = new ArrayList<Integer>();
		for (int i = 1; i <= board.length; i++)
			availableNumbers.add(i);
		
		for (int col = 0; col < board.length; col++)
			availableNumbers.remove(new Integer(board[row][col].get()));
		
		if (availableNumbers.size() == 0)
			return true;
		
		return false;
			
	}
	
	private static boolean isCorrectBox(SudokuCell [][] board, int boxStartRow, int boxStartCol) {
		ArrayList<Integer> availableNumbers = new ArrayList<Integer>();
		for (int i = 1; i <= board.length; i++)
			availableNumbers.add(i);
		
		for (int row = 0; row < 3; row++)
			for (int col = 0; col < 3; col++)
				availableNumbers.remove(new Integer(board[row + boxStartRow][col + boxStartCol].get()));
		
		if (availableNumbers.size() == 0)
			return true;
		
		return false;
	}
	
	private static boolean usedInCol(SudokuCell [][] board, int num, int col) {
		for (int row = 0; row < board.length; row++)
			if (board[row][col].get() == num)
				return true;

		return false;
	}
	
	private static boolean usedInRow(SudokuCell [][] board, int num, int row) {
		for (int col = 0; col < board.length; col++)
			if (board[row][col].get() == num)
				return true;

		return false;
	}
	
	private static boolean usedInBox(SudokuCell [][] board, int num, int boxStartRow, int boxStartCol) {
		for (int row = 0; row < 3; row++)
			for (int col = 0; col < 3; col++)
				if (board[row + boxStartRow][col + boxStartCol].get() == num)
					return true;
		
		return false;
	}
}
