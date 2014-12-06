import java.util.Collections;
import java.util.ArrayList;
import java.util.Random;

public class BoardGenerator {

	private SudokuCell [][] board;
	private int size;

	public boolean isCorrect(int size){
		return Helpers.isCorrect(board);
	}

	private boolean isSafe(int num, int row, int col) {
		return Helpers.isSafe(board, num, row, col);
	}

	private int variantsPerCell() {
        return size;
    }

	private int getRandomIndex() {
        return (int) (Math.random() * 10) % size + 1;
    }

	private Coordinates nextCell(int row, int col) {
		return Helpers.nextCell(row, col, size);
	}

	private void generateCorrectBoard(final int row, final int col) {
		if (!board[size - 1][size - 1].isFilled() ) {
			while (board[row][col].numberOfTried() < variantsPerCell()) {
				int candidate = 0;
				do {
					candidate = getRandomIndex();
				} while (board[row][col].isTried(candidate));

				if (isSafe(candidate, row, col)) {
					board[row][col].set(candidate);
					Coordinates nextCell = nextCell(row, col);
					if (nextCell.x < size && nextCell.y < size)
						generateCorrectBoard(nextCell.y, nextCell.x);
				}
				else
					board[row][col].tryNumber(candidate);
			}
			if (!board[size - 1][size - 1].isFilled())
				board[row][col].reset();
		}
	}

	public void generateCorrectBoard(int s){
		size = s;

		board = new SudokuCell[size][size];
		for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
            	board[i][j] = new SudokuCell();
            }
        }

		generateCorrectBoard(0, 0);

	}

	public void removeNumbers(int leftNumbersNmb){
		
	}

	public int [][] getCurrentBoard(){
		int [][] intBoard = new int[board.length][board.length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				intBoard[i][j] = board[i][j].get();
			}
		}
		return intBoard;
	}
}
