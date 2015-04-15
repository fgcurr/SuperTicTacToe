package test.java.game.superTicTacToe;
import static org.junit.Assert.*;

import main.java.game.superTicTacToe.Character;
import org.junit.Before;
import org.junit.Test;


public class CharacterIT {

	Character chara;
	
	@Before
	public void setUp() {
		chara = new Character(Character.AI);
	}
	
	/**
	 * Tests if the character is of the type String.
	 */
	@Test
	public void testIsString(){
		assertTrue("Not of type string.", chara.type.getClass() == String.class);
	}
}
