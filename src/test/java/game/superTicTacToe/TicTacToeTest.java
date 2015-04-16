package test.java.game.superTicTacToe;
import static org.junit.Assert.assertTrue;
import main.java.game.gui.BoardJFrame;

import org.junit.*;

public class TicTacToeTest {
	
	BoardJFrame boardJ;
	
	@Before
	public void setUp() {
		boardJ = new BoardJFrame();
	}
	
	/**
	 * Tests if a TicTacToe game within a quadrant loads successfully
	 */
	@Test
	public void testLoad() {
    	boardJ.setVisible(true);

    	// Give it time to load
    	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	
		assertTrue("TicTacToe is not loaded!",boardJ.isValid());
	}
	
	/**
	 * Tests if a TicTacToe is finished
	 */
	@Test
	public void testFinished() {
		// Makes AI go three times so it completes the tictactoe
		for(int i = 0; i < 3; i++){
			boardJ.AIMoves(0, i);
		}
		
		// Tests if tictactoe is done
		assertTrue("Board is not completed.",boardJ.boardQuads[0].tictactoe.isOver());
	}
}
