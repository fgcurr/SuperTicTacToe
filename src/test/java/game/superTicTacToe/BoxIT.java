package test.java.game.superTicTacToe;
import static org.junit.Assert.*;
import main.java.game.superTicTacToe.Box;

import org.junit.Before;
import org.junit.Test;


public class BoxIT {
	
	Box box;
	main.java.game.superTicTacToe.Character chara;
	
	@Before
	public void setUp() {
		chara = new main.java.game.superTicTacToe.Character();
		box = new Box();
	}
	
	/**
	 * Tests if the box has a O character
	 */
	@Test
	public void testIsO(){
		chara.type = "O";
		box.charcter = chara;
		assertTrue("Character is not an O", box.charcter.type == "O");
	}
	
	/**
	 * Tests if the box has a X character
	 */
	@Test
	public void testIsX(){
		chara.type = "X";
		box.charcter = chara;
		assertTrue("Character is not an X", box.charcter.type == "X");
	}
	
	/**
	 * Tests if the character in the box is nothing
	 */
	@Test
	public void testIsEmpty(){
		box.charcter = chara;
		assertTrue("Character is not empty", box.charcter.type == null);
	}
}
