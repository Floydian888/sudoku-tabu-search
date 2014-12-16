package test;
import static org.junit.Assert.*;

import java.util.Arrays;

import main.Helpers;
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
}



