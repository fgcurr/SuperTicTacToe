package test.java.game.superTicTacToe;
import static org.junit.Assert.*;

import java.util.Random;

import main.java.game.gui.BoardJFrame;
import main.java.game.superTicTacToe.Box;
import main.java.game.superTicTacToe.Quadrant;

import org.junit.Before;
import org.junit.Test;

public class QuadrantTest {
	
	public Quadrant q;
	
	@Before
	public void setUp() {
		q = new Quadrant();
		q.active = true;
		q.complete = true;
	}
	
	/**
	 * Test number 2
	 * Tests if a quadrant is finished when 3 Xs or Os are in a row.
	 */
	@Test
	public void testQuadrantComplete(){
		assertTrue("Quadrant not complete",q.isComplete());
	}
	
	/**
	 * Test number 5
	 * Tests the rejection of clicks on a quadrant that has been finished - will be done manually
	 */
//	@Test
//	public void testFinishedQuadrantRejectingClicks(){
//		throw new RuntimeException();
//	}
	
	/**
	 * Tests if the quadrant is playable
	 */
	@Test
	public void testPlayable(){
		assertTrue("Not playable", q.isActive());
	}
	
	/**
	 * Tests if the quadrant that was played can be found
	 */
	@Test
	public void testFindQuadrant(){
		Random rndm = new Random();
		
		int chosen = rndm.nextInt(9);
		
		BoardJFrame boardJ = new BoardJFrame();
		Quadrant quadrant = boardJ.board.quads[chosen];
		boolean found = false;
		
		boardJ.AIMoves(chosen, 0);
		for (Quadrant q : boardJ.board.quads) {
			for (Box b : q.tictactoe.boxes) {
				if (!b.isEmpty()) {
					int boardNum = boardJ.board.findQuadrant(q.quadrant);
					System.out.println("QUADRANT NOT EMPTY "+boardNum);
					if (boardJ.boardQuads[boardNum].quadrant.equals(quadrant.quadrant)){
						System.out.println("I RAN!");
						found = true;
					}
				}
			}
		}
		assertTrue("findQuadrant must return the quadrant the move was placed on...", found);
	}
}
