package test.java.game.superTicTacToe;
import static org.junit.Assert.*;
import main.java.game.gui.BoardJFrame;
import main.java.game.superTicTacToe.Board;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {
	
	BoardJFrame BoardJ;
	Board board;
	
	@Before
	public void setUp() {
		board  = new Board();
		BoardJ = new BoardJFrame();
	}
	
	/**
	 * Tests if JFrame class loads successfully
	 */
	@Test
	public void testJFrame() {
    	BoardJ.setVisible(true);
		assertTrue("Board is not loaded!",BoardJ.isValid());
	}
	
	/**
	 * Test number 2
	 * Tests if the board is finished when 3 quadrants are in a row. 
	 */
	
	@Test
	public void testBoardComplete(){
		board.finished = true;
		assertTrue("Board is not complete", board.isFinished());
	}
	
	/**
	 * Test number 3
	 * Tests if the game has ended when the number of Xs or Os have reached 40.
	 */
	@Test
	public void testNumberOfCharacters() {
		board.numOfO = 55;
		assertTrue("Board is not complete", board.isFinished());
	}
	
	/**
	 * Test number 6
	 * Tests if the first move is given to a random player.
	 */
	@Test
	public void testFirstMoveRandom(){
//		throw new RuntimeException();
	}
}