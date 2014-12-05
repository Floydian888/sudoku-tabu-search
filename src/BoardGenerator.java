import java.util.Collections;
import java.util.ArrayList;

public class BoardGenerator {

	private SudokuCell [][] board;

	public boolean isCorrect(int size){
		return Helpers.isCorrect(board, size);
	}
	
	private boolean isSafe(int num, int row, int col, int size) {
		return Helpers.isSafe(board, num, row, col, size);
	}
	
	private void clearCell(int cell, int size) {
		int col = cell % size;
		int row = cell / size;
		board[row][col].clear();
	}
	
	private boolean generateCorrectBoard(int size, int currentCell, ArrayList<Integer> availableNumbers) {
		if (currentCell == size*size )
			return true;
		
		int col = currentCell % size;
		int row = currentCell / size;

		if (availableNumbers.size() > 0) {
			Collections.shuffle(availableNumbers);
			int num = availableNumbers.get(0);
			if (isSafe(num, row, col, size)) {
				board[row][col].set(num);
				availableNumbers.clear();
				for (int i = 1; i <= size; i++)
					availableNumbers.add(i);
				if (generateCorrectBoard(size, currentCell + 1, availableNumbers) )
					return true;
			} 
			else{
				availableNumbers.remove(new Integer(num));
				if(generateCorrectBoard(size, currentCell, availableNumbers))
					return true;
			}
		}
		else {
			for (int i = 1; i <= size; i++)
				availableNumbers.add(i);
			
			clearCell(currentCell - 1, size);
			clearCell(currentCell - 2, size);
			clearCell(currentCell - 3, size);
			clearCell(currentCell - 4, size);
			clearCell(currentCell - 5, size);
			clearCell(currentCell - 6, size);
			clearCell(currentCell - 7, size);
			clearCell(currentCell - 8, size);
			clearCell(currentCell - 9, size);
			if(generateCorrectBoard(size, currentCell - 9, availableNumbers))
				return true;
		}
		return false;
	}
	public void generateCorrectBoard(int size){
		
		board = new SudokuCell[size][size];
		for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
            	board[i][j] = new SudokuCell();
            }
        }
		ArrayList<Integer> availableNumbers = new ArrayList<Integer>();
		for (int i = 1; i <= 9; i++)
			availableNumbers.add(i);
		generateCorrectBoard(size, 0, availableNumbers);	

	}
	
	public void removeNumbers(int leftNumbersNmb){
		
	}
	
	public SudokuCell [][] getCurrentBoard(){
		return board;
	}
	
}
