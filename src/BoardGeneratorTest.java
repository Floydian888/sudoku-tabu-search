import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

public class BoardGeneratorTest {

	@Test
	public void isCorrectTest() {
		BoardGenerator bg = new BoardGenerator();
		
		bg.generateCorrectBoard(9);
		/*int [][] board1	 = {{0,0,0,0,0,0,0,0,0},
						  {0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0}};
		
		assertFalse(Helpers.isCorrect(board1, 9));*/
		
	}
	@Test
	public void generateCorrectBoardTest() {
		BoardGenerator bg = new BoardGenerator();
		bg.generateCorrectBoard(9);
		assertTrue(bg.isCorrect(9));
	}

}
