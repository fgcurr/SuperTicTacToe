package test.java.game.superTicTacToe;
import static org.junit.Assert.*;
import main.java.game.superTicTacToe.Move;
import main.java.game.superTicTacToe.TicTacToe;
import main.java.game.superTicTacToe.Character;

import org.junit.Before;
import org.junit.Test;

public class MoveTest {
	
	public TicTacToe ttt;
	public Move move;
	
	@Before
	public void setUp() {
		ttt = new TicTacToe();
		move = new Move();
	}
	
	/**
	 * Tests if a Move was placed within a box
	 */
	@Test
	public void testMovePlaced() {
		move.move(new Character(Character.HUMAN), ttt.boxes[0]);
		assertFalse("Correct move not placed", ttt.boxes[0].isEmpty());
	}
	
	/**
	 * Tests if a Move was accessed
	 */
	@Test
	public void testGetMove() {
//		throw new RuntimeException();
	}
}
