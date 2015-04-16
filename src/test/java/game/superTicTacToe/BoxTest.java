package test.java.game.superTicTacToe;
import static org.junit.Assert.assertTrue;
import main.java.game.gui.BoardJFrame;
import main.java.game.superTicTacToe.Box;
import main.java.game.superTicTacToe.Character;

import org.junit.Before;
import org.junit.Test;

public class BoxTest {
	
	Box box;
	Character chara;
	BoardJFrame BoardJ;
	
	@Before
	public void setUp() {
		BoardJ = new BoardJFrame();
		
		box = new Box();
		chara = new Character(Character.AI);
		box.set(chara);
	}
	
	/**
	 * Tests if a Box was loaded in a TicTacToe
	 */
	@Test
	public void testLoad() {
    	BoardJ.setVisible(true);
    	
    	// Give it time to load
    	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	
		assertTrue("Box is not loaded!",BoardJ.isValid());
	}
	
	/**
	 * Tests if a Box is disabled
	 */
	@Test
	public void testDisabledBox() {
		throw new RuntimeException();
	}
	
	/**
	 * Tests if a Box has a character placed
	 */
	@Test
	public void testCharacterPlacedinBox(){
		assertTrue("Box is empty",!box.isEmpty());
	}
}
