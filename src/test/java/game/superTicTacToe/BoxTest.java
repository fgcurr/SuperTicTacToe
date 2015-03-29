package test.java.game.superTicTacToe;
import static org.junit.Assert.*;
import main.java.game.superTicTacToe.Box;

import org.junit.Before;
import org.junit.Test;

public class BoxTest {
	
	Box box;
	main.java.game.superTicTacToe.Character chara;
	
	@Before
	public void setUp() {
		box = new Box();
		chara = new main.java.game.superTicTacToe.Character();
		chara.type = "X";
		box.charcter = chara;
	}
	
	/**
	 * Tests if a Box was loaded in a TicTacToe
	 */
	@Test
	public void testLoad() {
		throw new RuntimeException();
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
		assertTrue("Box is empty",box.charcter != null);
	}
}
