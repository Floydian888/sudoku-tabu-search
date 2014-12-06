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
		
		assertFalse(Helpers.isCorrect(board1, 9));
		
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

		assertTrue(Helpers.isCorrect(board2, 9));
		
	}
}
