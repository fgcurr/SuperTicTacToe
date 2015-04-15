package test.java.game.superTicTacToe;
import static org.junit.Assert.*;
import main.java.game.superTicTacToe.Box;
import main.java.game.superTicTacToe.Character;

import org.junit.Before;
import org.junit.Test;


public class BoxIT {
	
	Character ai;
	Character human;
	Character chara;
	Box[][] boardBoxes;
	
	@Before
	public void setUp() {
    	boardBoxes = new Box[9][9];
    	boardBoxes[0][0] = new Box();
    	ai = new Character(Character.AI);
    	human = new Character(Character.HUMAN);
	}
	
	/**
	 * Tests if the box has a O character
	 */
	@Test
	public void testIsO(){
		chara = new Character(Character.AI);
		boardBoxes[0][0].set(chara);
		assertTrue("Character is not an O", boardBoxes[0][0].getCharacter().type == ai.type);
	}
	
	/**
	 * Tests if the box has a X character
	 */
	@Test
	public void testIsX(){
		chara = new Character(Character.HUMAN);
		boardBoxes[0][0].set(chara);
		assertTrue("Character is not an X", boardBoxes[0][0].getCharacter().type == human.type);
	}
	
	/**
	 * Tests if the character in the box is nothing
	 */
	@Test
	public void testIsEmpty(){
		chara = new Character(Character.AI);
		assertTrue("Character is not empty", boardBoxes[0][0].getCharacter().type == "N/A");
	}
}
