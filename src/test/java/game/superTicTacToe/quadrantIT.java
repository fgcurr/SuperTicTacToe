package test.java.game.superTicTacToe;
import static org.junit.Assert.*;
import main.java.game.gui.BoardJFrame;
import main.java.game.superTicTacToe.Character;
import main.java.game.superTicTacToe.Quadrant;

import org.junit.Before;
import org.junit.Test;

public class quadrantIT {
	
	Quadrant q;
	
	@Before
	public void setUp() {
		q = new Quadrant();
	}
	
	/**
	 * Tests if the TicTacToe is done
	 */
	@Test
	public void testTicTacToeDone(){
		q.complete = true;
		assertTrue("TicTacToe not Done", q.isComplete());
	}
	
	/**
	 * Tests who was the victor of a quadrant
	 */
	@Test
	public void testWhoWonQuadrant(){
		BoardJFrame boardJ = new BoardJFrame();
		
		// AI wins in this case
		for(int i = 0; i < 3; i++){
			boardJ.AIMoves(0, i);
		}
		
		boolean aiWin = boardJ.boardQuads[0].tictactoe.isLinedUp(new Character(1));
		assertTrue("Quadrand not won by AI.", aiWin);
	}
}
