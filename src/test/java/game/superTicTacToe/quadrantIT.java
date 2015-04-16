package test.java.game.superTicTacToe;
import static org.junit.Assert.*;
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
//		throw new RuntimeException();
	}
}
