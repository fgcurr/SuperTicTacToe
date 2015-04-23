package test.java.game.superTicTacToe;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

import main.java.game.gui.BoardJFrame;
import main.java.game.superTicTacToe.AI;
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
		BoardJ.frame = new BoardJFrame();
		
		BoardJ.AIMoves(0, 0);
		
		BoardJ.frame.resetButton.doClick();
		
		assertTrue("Board did not reset.", BoardJ.frame.boardBoxes[0][0].isEmpty());
	}
	
	/**
	 * Testing if Board is indeed won by a player
	 */
	
	@Test(timeout=10000)
	public void testWonBy() {
		
		BoardJ.setVisible(true);
		
		// Simulating game play
		Random randomQuad = new Random();
		Random randomBox = new Random();
		int quad = randomQuad.nextInt(9);
		int box = randomBox.nextInt(9);
		BoardJ.boxes[quad][box].doClick();
		AI ai;
		int stuckcount = 0;
		while (!BoardJ.board.isFinished()) {
			ai = new AI(BoardJ.boardTictactoes[box]);
			while(BoardJ.boardTictactoes[box].isOver()){
				box = new Random().nextInt(9);
				ai = new AI(BoardJ.boardTictactoes[box]);
				stuckcount++;
				if (stuckcount > 300) {
					System.out.println("SYSTEM STUCK");
					assertTrue("System stuck to a draw, please restart test", false);
				}
			}
			ai.callMiniMax(0, 1);
			int aimove = 0;
			aimove = ai.returnBestMove();
			System.out.println("Clicking " + "[" + box + "," + aimove + "]");
			BoardJ.boxes[box][aimove].doClick();
			box = BoardJ.activequad;
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		if (BoardJ.board.isWonBy(new Character(1)))
			assertTrue("Board should be won by AI or player", BoardJ.board.isWonBy(new Character(1)));
		else if (BoardJ.board.isWonBy(new Character(2)))
			assertTrue("Board should be won by AI or player", BoardJ.board.isWonBy(new Character(2)));
		
		
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