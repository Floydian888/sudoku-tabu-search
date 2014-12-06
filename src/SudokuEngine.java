import java.util.ArrayList;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;


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
	
	// checking how many positions are conflicting
	// we don't check boxes assuming that boxes don't contain conflicts
	public int getCurrentConflictsNumber(){
		
		int boardLength = currentState.getBoard().length;
		
		int conflictsNumber = 0;
		
		for (int i = 0; i < boardLength; i++) {
			ArrayList<Integer> row = new ArrayList<Integer>();
			for (int j = 0; j < boardLength; j++) {
				row.add(currentState.getBoard()[i][j]);
			}
			Set<Integer> rowUniq = new HashSet<Integer>(row);
			conflictsNumber += row.size() - rowUniq.size();
		}
		
		for (int i = 0; i < boardLength; i++) {
			ArrayList<Integer> column = new ArrayList<Integer>();
			for (int j = 0; j < boardLength; j++) {
				column.add(currentState.getBoard()[j][i]);
			}
			Set<Integer> columnUniq = new HashSet<Integer>(column);
			conflictsNumber += column.size() - columnUniq.size();
		}
		
		return conflictsNumber;
	}
}
