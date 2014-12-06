import java.util.ArrayList;


public class Helpers {

	public static boolean isCorrect(SudokuCell [][] board, int size){
		for (int i = 0; i < size; i++)
			if (!isCorrectCol(board, i, size) || !isCorrectRow(board, i, size))
				return false;
		for (int row = 0; row < size; row += 3)
			for (int col = 0; col < size; col += 3)
				if (!isCorrectBox(board, row, col, size))
					return false;
		
		return true;
	}
	
	public static boolean isSafe(SudokuCell [][] board, int num, int row, int col, int size) {
		return (!usedInCol(board, num, col, size) && !usedInRow(board, num, row, size) && !usedInBox(board, num, row - row%3, col - col%3, size));
	}
	
	private static boolean isCorrectCol(SudokuCell [][] board, int col, int size) {
		ArrayList<Integer> availableNumbers = new ArrayList<Integer>();
		for (int i = 1; i <= size; i++)
			availableNumbers.add(i);
		
		for (int row = 0; row < size; row++)
			availableNumbers.remove(new Integer(board[row][col].get()));
		
		if (availableNumbers.size() == 0)
			return true;
		
		return false;
			
	}
	
	private static boolean isCorrectRow(SudokuCell [][] board, int row, int size) {
		ArrayList<Integer> availableNumbers = new ArrayList<Integer>();
		for (int i = 1; i <= size; i++)
			availableNumbers.add(i);
		
		for (int col = 0; col < size; col++)
			availableNumbers.remove(new Integer(board[row][col].get()));
		
		if (availableNumbers.size() == 0)
			return true;
		
		return false;
			
	}
	
	private static boolean isCorrectBox(SudokuCell [][] board, int boxStartRow, int boxStartCol, int size) {
		ArrayList<Integer> availableNumbers = new ArrayList<Integer>();
		for (int i = 1; i <= size; i++)
			availableNumbers.add(i);
		
		for (int row = 0; row < 3; row++)
			for (int col = 0; col < 3; col++)
				availableNumbers.remove(new Integer(board[row + boxStartRow][col + boxStartCol].get()));
		
		if (availableNumbers.size() == 0)
			return true;
		
		return false;
	}
	
	private static boolean usedInCol(SudokuCell [][] board, int num, int col, int size) {
		for (int row = 0; row < size; row++)
			if (board[row][col].get() == num)
				return true;

		return false;
	}
	
	private static boolean usedInRow(SudokuCell [][] board, int num, int row, int size) {
		for (int col = 0; col < size; col++)
			if (board[row][col].get() == num)
				return true;

		return false;
	}
	
	private static boolean usedInBox(SudokuCell [][] board, int num, int boxStartRow, int boxStartCol, int size) {
		for (int row = 0; row < 3; row++)
			for (int col = 0; col < 3; col++)
				if (board[row + boxStartRow][col + boxStartCol].get() == num)
					return true;
		
		return false;
	}
}
