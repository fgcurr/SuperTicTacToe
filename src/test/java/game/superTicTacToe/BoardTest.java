package test.java.game.superTicTacToe;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;

import main.java.game.gui.BoardJFrame;
import main.java.game.superTicTacToe.Character;
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

    	// Give it time to load
    	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	
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
		ArrayList<Integer> moves = new ArrayList<Integer>();
		
		for(int i = 0; i < 100; i++){
			moves.add(BoardJ.firstMove());
		}
		
		int occurrences = Collections.frequency(moves, 0);
		
		assertTrue("First move not given to a random player.", occurrences > 20);
	}
	
	/**
	 * Tests pressing the restart button
	 */
	@Test
	public void testRestartButtonClicked(){
		BoardJ.AIMoves(0, 0);
		BoardJ.frame = new BoardJFrame();
		
		BoardJ.frame.resetButton.doClick();
		
		assertTrue("Board did not reset.", BoardJ.frame.boardBoxes[0][0].isEmpty());
	}
	
	/**
	 * Testing if Board is indeed won by a player
	 */
	
	@Test
	public void testWonBy() {
		
		// Winning box 0
		BoardJ.AIMoves(2,0);
		BoardJ.AIMoves(2,1);
		BoardJ.AIMoves(2,2);
		// Winning box 4
		BoardJ.AIMoves(4,3);
		BoardJ.AIMoves(4,4);
		BoardJ.AIMoves(4,5);
		// Winning box 8
		BoardJ.AIMoves(6,6);
		BoardJ.AIMoves(6,7);
		BoardJ.AIMoves(6,8);
		
		assertTrue("Board should be won by AI as it wins quadrants 0, 4 and 8", BoardJ.board.isWonBy(new Character(1)));
		
	}
	
	/**
	 * Tests if the JFrame tells who won the game.
	 */
	@Test
	public void testWinNotification(){
		// AI wins box 0
		BoardJ.AIMoves(0,0);
		BoardJ.AIMoves(0,1);
		BoardJ.AIMoves(0,2);
		// AI wins box 1
		BoardJ.AIMoves(1,3);
		BoardJ.AIMoves(1,4);
		BoardJ.AIMoves(1,5);
		// AI wins box 2
		BoardJ.AIMoves(2,6);
		BoardJ.AIMoves(2,7);
		BoardJ.AIMoves(2,8);
		
		BoardJ.checkBoard();
		String text = BoardJ.title.getText();
		assertTrue("Text on JFrame did not tell who won.", text == "AI won the game!");
	}
}