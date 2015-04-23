package test.java.game.superTicTacToe;

import static org.junit.Assert.assertTrue;
import main.java.game.gui.BoardJFrame;
import main.java.game.superTicTacToe.Character;

import org.junit.Before;
import org.junit.Test;

public class CharacterTest {

	BoardJFrame boardJ;
	
	@Before
	public void setUp() {
		boardJ = new BoardJFrame();
		boardJ.AIMoves(0, 0);
	}
	
	/**
	 * Tests if a Character loads successfully
	 */
	@Test
	public void testLoad() {
		assertTrue("Character did not load.", boardJ.boardBoxes[0][0].getCharacter().type != "");
	}
	
	/**
	 * Tests if a character type exists
	 */
	@Test
	public void testCharType() {
		assertTrue("Character type does not exist.", boardJ.boardBoxes[0][0].getCharacter().getType() != null);
	}
}
