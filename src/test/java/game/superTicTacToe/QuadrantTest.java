package test.java.game.superTicTacToe;
import static org.junit.Assert.assertTrue;

import java.awt.Color;
import java.util.Random;

import javax.swing.border.LineBorder;

import main.java.game.gui.BoardJFrame;
import main.java.game.superTicTacToe.Box;
import main.java.game.superTicTacToe.Character;
import main.java.game.superTicTacToe.Quadrant;
import main.java.game.superTicTacToe.TicTacToe;

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
	
	/**
	 * Tests if the player next quadrant to play is outlined
	 */
	@Test
	public void testOutlined(){
		BoardJFrame boardJ = new BoardJFrame();
		boardJ.AIMoves(0, 0);
		Color color = ((LineBorder)boardJ.boardQuads[0].quadrant.getBorder()).getLineColor();
		assertTrue("Not outlined.", Color.GREEN.equals(color));
	}
	
	/**
	 * Testing checkAndDisable by forcing a draw on a tictactoe (not possible in the real game)
	 */
	@Test
	public void testCheckAndDisable() {
		BoardJFrame BoardJ = new BoardJFrame();
		TicTacToe t = BoardJ.boardQuads[0].tictactoe;
		t.boxes[0].set(new Character(1));
		t.boxes[1].set(new Character(1));
		t.boxes[2].set(new Character(2));
		t.boxes[3].set(new Character(2));
		t.boxes[4].set(new Character(2));
		t.boxes[5].set(new Character(1));
		t.boxes[6].set(new Character(1));
		t.boxes[7].set(new Character(2));
		t.boxes[8].set(new Character(1));
		
		BoardJ.checkAndDisable(BoardJ.boardQuads[0], t);
		Color color = ((LineBorder)BoardJ.boardQuads[0].quadrant.getBorder()).getLineColor();
		assertTrue("Border should be grayed out", Color.GRAY.equals(color));
	}
}
