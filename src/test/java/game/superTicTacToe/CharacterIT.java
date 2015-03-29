package test.java.game.superTicTacToe;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class CharacterIT {

	boardElements.Character chara;
	
	@Before
	public void setUp() {
		chara = new boardElements.Character();
		chara.type ="X";
	}
	
	/**
	 * Tests if the character is of the type String.
	 */
	@Test
	public void testIsString(){
		assertTrue("Not of type string.", chara.type.getClass() == String.class);
	}
}
