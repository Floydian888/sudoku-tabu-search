package test;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import main.Coordinates;
import main.Helpers;
import main.Movement;
import main.SudokuEngine;

import org.junit.Test;

import exception.WrongSudokuNumberException;
import exception.WrongSudokuSizeException;

public class SudokuEngineTest {

	@Test(expected=WrongSudokuSizeException.class)
	public void constructorTest1() throws WrongSudokuSizeException, WrongSudokuNumberException{
		int [][] wrongSizeBoard =
			{{1,2,3,4,5,6,7,8,9,1},
			 {9,8,7,3,2,1,6,5,4},
			 {6,5,4,9,8,7,3,2,1},
			 {2,3,1,5,6,4,8,9,7},
			 {8,7,9,2,1,3,5,4,6},
			 {5,4,6,8,7,9,2,1,3},
			 {3,1,2,6,4,5,9,7,8},
			 {7,9,8,1,3,2,4,6,5},
			 {4,6,5,7,9,8,1,3,2}};
		SudokuEngine e1 = new SudokuEngine(wrongSizeBoard,1);
	}
	
	@Test(expected=WrongSudokuNumberException.class)
	public void constructorTest2() throws WrongSudokuSizeException, WrongSudokuNumberException{
		int [][] wrongNumbersBoard =
			{{1,2,3,4,5,6,7,8,10},
			 {9,8,7,3,2,1,6,5,4},
			 {6,5,4,9,8,7,3,2,1},
			 {2,3,1,5,6,4,8,9,7},
			 {8,7,9,2,1,3,5,4,6},
			 {5,4,6,8,7,9,2,1,3},
			 {3,1,2,6,4,5,9,7,8},
			 {7,9,8,1,3,2,4,6,5},
			 {4,6,5,7,9,8,1,3,2}};
		SudokuEngine e1 = new SudokuEngine(wrongNumbersBoard,1);
	}
	
	@Test
	public void getCurrentConflictsNumberTest() throws WrongSudokuSizeException, WrongSudokuNumberException {
		int [][] b1 =
			{{1,2,3,4,5,6,7,8,9},
			 {9,8,7,3,2,1,6,5,4},
			 {6,5,4,9,8,7,3,2,1},
			 {2,3,1,5,6,4,8,9,7},
			 {8,7,9,2,1,3,5,4,6},
			 {5,4,6,8,7,9,2,1,3},
			 {3,1,2,6,4,5,9,7,8},
			 {7,9,8,1,3,2,4,6,5},
			 {4,6,5,7,9,8,1,3,2}};
		SudokuEngine e1 = new SudokuEngine(b1,1);
		assertEquals(0, e1.getCurrentConflictsNumber());
		
		int [][] b2 =
			{{3,2,1,4,5,6,7,8,9},
			 {9,8,7,3,2,1,6,5,4},
			 {6,5,4,9,8,7,3,2,1},
			 {2,3,1,5,6,4,8,9,7},
			 {8,7,9,2,1,3,5,4,6},
			 {5,4,6,8,7,9,2,1,3},
			 {3,1,2,6,4,5,9,7,8},
			 {7,9,8,1,3,2,4,6,5},
			 {4,6,5,7,9,8,1,3,2}};
		SudokuEngine e2 = new SudokuEngine(b2,1);
		assertEquals(2, e2.getCurrentConflictsNumber());
		
		int [][] b3 =
			{{1,1,1,1,1,1,1,1,1},
			 {1,1,1,1,1,1,1,1,1},
			 {1,1,1,1,1,1,1,1,1},
			 {1,1,1,1,1,1,1,1,1},
			 {1,1,1,1,1,1,1,1,1},
			 {1,1,1,1,1,1,1,1,1},
			 {1,1,1,1,1,1,1,1,1},
			 {1,1,1,1,1,1,1,1,1},
			 {1,1,1,1,1,1,1,1,1}};
		SudokuEngine e3 = new SudokuEngine(b3,1);
		assertEquals(2*8*9, e3.getCurrentConflictsNumber());
	}
	
	@Test
	public void fillBoardTest() throws WrongSudokuSizeException, WrongSudokuNumberException {
		int [][] inputBoard =
			{{1,0,0,0,0,0,0,0,0},
			 {0,0,0,0,0,0,0,0,3},
			 {0,0,0,0,0,0,0,0,0},
			 {0,0,0,0,0,0,0,0,0},
			 {0,0,0,0,0,0,0,0,0},
			 {0,0,0,0,0,0,0,0,0},
			 {0,0,0,0,0,0,0,0,0},
			 {0,0,0,0,0,0,0,0,0},
			 {0,0,0,0,0,0,0,0,2}};
		SudokuEngine engine = new SudokuEngine(inputBoard,1);
		
		engine.fillBoard();
		int [][] filledBoard = engine.getCurrentState();
		
		assertTrue(Helpers.areCorrectAllBoxes(Helpers.convertToSudokuCells(filledBoard)));
		
		assertEquals(1, filledBoard[0][0]);
		assertEquals(3, filledBoard[1][8]);
		assertEquals(2, filledBoard[8][8]);
	}

	@Test
	public void generateNotBlockedMovements() throws WrongSudokuSizeException, WrongSudokuNumberException{
		
		
		
		Coordinates c1 = new Coordinates(0, 0);
		Coordinates c2 = new Coordinates(0, 1);
		
		Set<Coordinates> positions = new HashSet<Coordinates>();
		positions.add(c1);
		positions.add(c2);
		
		Coordinates c3 = new Coordinates(0, 1);
		
		//System.out.print(positions.contains(new Coordinates(0, 1)));
		
		int [][] b1 =
			{{1,2,3,4,5,6,7,8,9},
			 {9,8,7,3,2,1,6,5,4},
			 {6,5,4,9,8,7,3,2,1},
			 {2,3,1,5,6,4,8,9,7},
			 {8,7,9,2,1,3,5,4,6},
			 {5,4,6,8,7,9,2,1,3},
			 {3,1,2,6,4,5,9,7,8},
			 {7,9,8,1,3,2,4,6,5},
			 {4,6,5,7,9,8,1,3,2}};
		SudokuEngine engine = new SudokuEngine(b1,1);
		assertEquals(0, engine.generateNotBlockedMovements().size());
		
		int [][] b2 =
			{{0,2,3,4,5,6,7,8,9},
			 {9,8,7,3,2,1,6,5,4},
			 {6,5,4,9,8,7,3,2,1},
			 {2,3,1,5,6,4,8,9,7},
			 {8,7,9,2,1,3,5,4,6},
			 {5,4,6,8,7,9,2,1,3},
			 {3,1,2,6,4,5,9,7,8},
			 {7,9,8,1,3,2,4,6,5},
			 {4,6,5,7,9,8,1,3,2}};
		SudokuEngine engine2 = new SudokuEngine(b2,1);
		assertEquals(0, engine2.generateNotBlockedMovements().size());
		
		int [][] b3 =
			{{0,0,3,4,5,6,7,8,9},
			 {9,8,7,3,2,1,6,5,4},
			 {6,5,4,9,8,7,3,2,1},
			 {2,3,1,5,6,4,8,9,7},
			 {8,7,9,2,1,3,5,4,6},
			 {5,4,6,8,7,9,2,1,3},
			 {3,1,2,6,4,5,9,7,8},
			 {7,9,8,1,3,2,4,6,5},
			 {4,6,5,7,9,8,1,3,2}};
		SudokuEngine engine3 = new SudokuEngine(b3,1);
		assertEquals(1, engine3.generateNotBlockedMovements().size());
		
		int [][] b4 =
			{{0,0,0,0,0,0,0,0,0},
			 {0,0,0,0,0,0,0,0,0},
			 {0,0,0,0,0,0,0,0,0},
			 {0,0,0,0,0,0,0,0,0},
			 {0,0,0,0,0,0,0,0,0},
			 {0,0,0,0,0,0,0,0,0},
			 {0,0,0,0,0,0,0,0,0},
			 {0,0,0,0,0,0,0,0,0},
			 {0,0,0,0,0,0,0,0,0}};
		SudokuEngine engine4 = new SudokuEngine(b4,1);
		assertEquals(36*9, engine4.generateNotBlockedMovements().size());
		
	}
}



