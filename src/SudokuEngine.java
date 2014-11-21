import java.util.Queue;


public class SudokuEngine {

	private SudokuBoard currentState;
	private Queue<Tuple<Coordinates, Coordinates>> shortTermTabuList;
	private Queue<Tuple<Coordinates, Coordinates>> longTermTabuList;
	
	public SudokuEngine(int [][] initialBoard){
		currentState = new SudokuBoard(initialBoard);
	}
	
	public int [][] getCurrentState(){
		return currentState.getBoard();
	}
	
	public void fillBoardWithRandomNumbers(){
		
	}
	
	// sprawdzamy każde pole
	// jeśl dla tego pola jest konflikt w wierszu lub kolumnie lub kwadracie, inkrementujemy licznik
	public int getCurrentConflictsNumber(){
		return 0;
	}
}
