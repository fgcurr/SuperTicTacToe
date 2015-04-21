package test.java.game.superTicTacToe;
import static org.junit.Assert.*;
import main.java.game.gui.BoardJFrame;
import main.java.game.superTicTacToe.Character;

import org.junit.Before;
import org.junit.Test;

public class TicTacToeIT {
	
	BoardJFrame boardJ;
	
	@Before
	public void setUp() {
		boardJ = new BoardJFrame();
	}
	
	/**
	 * Tests if an X can be successfully placed
	 */
	@Test
	public void testPlaceX(){
		boardJ.boardBoxes[0][0].set(new Character(Character.HUMAN));
		String x = boardJ.boardTictactoes[0].boxes[0].getCharacter().type;
		assertTrue("X placed unsuccessfully.", x == "X");
	}

	/**
	 * Tests if an O can be successfully placed
	 */
	@Test
	public void testPlaceO(){
		boardJ.boardBoxes[0][0].set(new Character(Character.AI));
		String o = boardJ.boardTictactoes[0].boxes[0].getCharacter().type;
		assertTrue("X placed unsuccessfully.", o == "O");
	}

	/**
	 * Tests if an X can win this TicTacToe
	 */
	@Test
	public void testXWins(){
		for(int i = 0; i < 3; i++){
			boardJ.boardTictactoes[0].boxes[i].set(new Character(Character.HUMAN));
		}

		boolean humanWin = boardJ.boardQuads[0].tictactoe.isLinedUp(new Character(2));
		assertTrue("TicTacToe not won by human.", humanWin);
	}

	/**
	 * Tests if an O can win this TicTacToe
	 */
	@Test
	public void testOWins(){
		for(int i = 0; i < 3; i++){
			boardJ.boardTictactoes[0].boxes[i].set(new Character(Character.AI));
		}

		boolean aiWin = boardJ.boardQuads[0].tictactoe.isLinedUp(new Character(1));
		assertTrue("TicTacToe not won by AI.", aiWin);
	}
	
}
