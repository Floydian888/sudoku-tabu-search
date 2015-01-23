package main;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import org.apache.commons.collections4.queue.*;

import exception.WrongSudokuNumberException;
import exception.WrongSudokuSizeException;

public class SudokuEngine {

	private SudokuBoard currentState;
	private int size(){
		return 9;
	}
	private int boxSize(){
		return 3;
	}
	
	private Queue<Tuple<Coordinates, Coordinates>> shortTermTabuList;
	
	private Set<Coordinates> blockedPositions = new HashSet<Coordinates>();
	
	public SudokuEngine(int [][] initialBoard, int shortTermTabuListSize) throws WrongSudokuSizeException, WrongSudokuNumberException{
		
		if (!Helpers.hasProperSize(initialBoard))
			throw new WrongSudokuSizeException("In SudokuEngine constructor");
		if (!Helpers.hasProperNumbers(initialBoard))
			throw new WrongSudokuNumberException("In SudokuEngine constructor");
		
		shortTermTabuList = new CircularFifoQueue<Tuple<Coordinates, Coordinates>>(shortTermTabuListSize);
		currentState = new SudokuBoard(initialBoard);
		for (int i = 0; i < size(); i++) {
			for (int j = 0; j < size(); j++) {
				if(initialBoard[i][j] != 0)
					blockedPositions.add(new Coordinates(i,j));
			}
		}
	}
	
	public int [][] getCurrentState(){
		return currentState.getBoard();
	}
	
	public Set<Coordinates> getBlockedPositions(){
		return blockedPositions;
	}
	
	private void fillBox(int x, int y){
		
		Set<Integer> numbersInBox = new HashSet<Integer>();
		List<Coordinates> positionsToFill = new ArrayList<Coordinates>();
		
		for (int i = x * boxSize(); i < (x+1) * boxSize(); i++) {
			for (int j = y * boxSize(); j < (y+1) * boxSize(); j++) {
				int number = currentState.getBoard()[i][j];
				if(number != 0){
					numbersInBox.add(number);
				}
				else
					positionsToFill.add(new Coordinates(i, j));
			}
		}
		
		Set<Integer> allNumbers = new HashSet<Integer>(Arrays.asList(Helpers.getNumbers(1, 9)));
		allNumbers.removeAll(numbersInBox);
		
		Integer [] numbersToInsert = allNumbers.toArray(new Integer[allNumbers.size()]);
		
		for (int i = 0; i < numbersToInsert.length; i++) {
			currentState.insert(positionsToFill.get(i), numbersToInsert[i]);
		}
	}
	
	// filling with random numbers
	// but preserving numbers from initial board
	// and making sure there are no conflicts in boxes
	public void fillBoard(){
		for (int i = 0; i < boxSize(); i++) {
			for (int j = 0; j < boxSize(); j++) {
				fillBox(i,j);
			}
		}
	}
	
	// checking how many positions are conflicting
	// we don't check boxes assuming that boxes don't contain conflicts
	public int getCurrentConflictsNumber(){
		
		int conflictsNumber = 0;
		
		for (int i = 0; i < size(); i++) {
			ArrayList<Integer> row = new ArrayList<Integer>();
			for (int j = 0; j < size(); j++) {
				row.add(currentState.getBoard()[i][j]);
			}
			Set<Integer> rowUniq = new HashSet<Integer>(row);
			conflictsNumber += row.size() - rowUniq.size();
		}
		
		for (int i = 0; i < size(); i++) {
			ArrayList<Integer> column = new ArrayList<Integer>();
			for (int j = 0; j < size(); j++) {
				column.add(currentState.getBoard()[j][i]);
			}
			Set<Integer> columnUniq = new HashSet<Integer>(column);
			conflictsNumber += column.size() - columnUniq.size();
		}
		
		return conflictsNumber;
	}
	
	public List<Tuple<Movement,Integer>> generateNeighborhood(){
		SudokuBoard current = new SudokuBoard(currentState.getBoard());
		return null;
	}

	public List<Movement> generateNotBlockedMovements(){
		List<Movement> movements = new LinkedList<Movement>(); 
		for (int i = 0; i < boxSize(); i++) {
			for (int j = 0; j < boxSize(); j++) {
				movements.addAll(Helpers.generateAllPossibleMovements(i, j));
			}
		}
		
		
		Iterator<Movement> iter = movements.iterator();
		while (iter.hasNext()) {
		  Movement theMovement = iter.next();
		  if (blockedPositions.contains(theMovement.from) || blockedPositions.contains(theMovement.to))
		  {
			  iter.remove();
		  }
		}
		
		return movements;
	}
}
