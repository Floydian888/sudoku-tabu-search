
public class SudokuBoard {

	private int [][] board;
	
	public SudokuBoard(int [][] initialBoard){
		board = initialBoard;
	}
	
	public int size(){
		return board.length;
	}
	
	public int [][] getBoard(){
		return board;
	}
	
	public void insert(Coordinates position, int value){
		board[position.x][position.y] = value;
	}
	
	public void swapNumbersByCoordinates(Coordinates source, Coordinates destination){
		
	}
}
