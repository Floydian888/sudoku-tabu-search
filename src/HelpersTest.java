import static org.junit.Assert.*;

import org.junit.Test;

public class HelpersTest {

	@Test
	public void isCorrectTest() {
		
		SudokuCell [][] board1 =
			{{new SudokuCell(0),new SudokuCell(0),new SudokuCell(0),new SudokuCell(0),new SudokuCell(0),new SudokuCell(0),new SudokuCell(0),new SudokuCell(0),new SudokuCell(0)},
		  	 {new SudokuCell(0),new SudokuCell(0),new SudokuCell(0),new SudokuCell(0),new SudokuCell(0),new SudokuCell(0),new SudokuCell(0),new SudokuCell(0),new SudokuCell(0)},
		  	 {new SudokuCell(0),new SudokuCell(0),new SudokuCell(0),new SudokuCell(0),new SudokuCell(0),new SudokuCell(0),new SudokuCell(0),new SudokuCell(0),new SudokuCell(0)},
			 {new SudokuCell(0),new SudokuCell(0),new SudokuCell(0),new SudokuCell(0),new SudokuCell(0),new SudokuCell(0),new SudokuCell(0),new SudokuCell(0),new SudokuCell(0)},
			 {new SudokuCell(0),new SudokuCell(0),new SudokuCell(0),new SudokuCell(0),new SudokuCell(0),new SudokuCell(0),new SudokuCell(0),new SudokuCell(0),new SudokuCell(0)},
			 {new SudokuCell(0),new SudokuCell(0),new SudokuCell(0),new SudokuCell(0),new SudokuCell(0),new SudokuCell(0),new SudokuCell(0),new SudokuCell(0),new SudokuCell(0)},
			 {new SudokuCell(0),new SudokuCell(0),new SudokuCell(0),new SudokuCell(0),new SudokuCell(0),new SudokuCell(0),new SudokuCell(0),new SudokuCell(0),new SudokuCell(0)},
			 {new SudokuCell(0),new SudokuCell(0),new SudokuCell(0),new SudokuCell(0),new SudokuCell(0),new SudokuCell(0),new SudokuCell(0),new SudokuCell(0),new SudokuCell(0)},
			 {new SudokuCell(0),new SudokuCell(0),new SudokuCell(0),new SudokuCell(0),new SudokuCell(0),new SudokuCell(0),new SudokuCell(0),new SudokuCell(0),new SudokuCell(0)}};
		
		assertFalse(Helpers.isCorrect(board1));
		
		SudokuCell [][] board2 =
			{{new SudokuCell(1),new SudokuCell(2),new SudokuCell(3),new SudokuCell(4),new SudokuCell(5),new SudokuCell(6),new SudokuCell(7),new SudokuCell(8),new SudokuCell(9)},
		  	 {new SudokuCell(9),new SudokuCell(8),new SudokuCell(7),new SudokuCell(3),new SudokuCell(2),new SudokuCell(1),new SudokuCell(6),new SudokuCell(5),new SudokuCell(4)},
		  	 {new SudokuCell(6),new SudokuCell(5),new SudokuCell(4),new SudokuCell(9),new SudokuCell(8),new SudokuCell(7),new SudokuCell(3),new SudokuCell(2),new SudokuCell(1)},
			 {new SudokuCell(2),new SudokuCell(3),new SudokuCell(1),new SudokuCell(5),new SudokuCell(6),new SudokuCell(4),new SudokuCell(8),new SudokuCell(9),new SudokuCell(7)},
			 {new SudokuCell(8),new SudokuCell(7),new SudokuCell(9),new SudokuCell(2),new SudokuCell(1),new SudokuCell(3),new SudokuCell(5),new SudokuCell(4),new SudokuCell(6)},
			 {new SudokuCell(5),new SudokuCell(4),new SudokuCell(6),new SudokuCell(8),new SudokuCell(7),new SudokuCell(9),new SudokuCell(2),new SudokuCell(1),new SudokuCell(3)},
			 {new SudokuCell(3),new SudokuCell(1),new SudokuCell(2),new SudokuCell(6),new SudokuCell(4),new SudokuCell(5),new SudokuCell(9),new SudokuCell(7),new SudokuCell(8)},
			 {new SudokuCell(7),new SudokuCell(9),new SudokuCell(8),new SudokuCell(1),new SudokuCell(3),new SudokuCell(2),new SudokuCell(4),new SudokuCell(6),new SudokuCell(5)},
			 {new SudokuCell(4),new SudokuCell(6),new SudokuCell(5),new SudokuCell(7),new SudokuCell(9),new SudokuCell(8),new SudokuCell(1),new SudokuCell(3),new SudokuCell(2)}};

		assertTrue(Helpers.isCorrect(board2));
		
	}
	
	
	@Test
	public void getNumbersTest() {
		Integer [] expected = {1,2,3};
		Integer [] actual = Helpers.getNumbers(1,3);
		assertArrayEquals(expected, actual);
	}
}
