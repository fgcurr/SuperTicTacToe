package test.java.game.superTicTacToe;

import static org.junit.Assert.assertTrue;
import main.java.game.gui.BoardJFrame;
import main.java.game.superTicTacToe.AI;
import main.java.game.superTicTacToe.TicTacToe;

import org.junit.Before;
import org.junit.Test;

public class AITest {
	
	AI ai;
	TicTacToe ttt;
	
	@Before
	public void setUp() {
		ttt = new TicTacToe();
		ai = new AI(ttt);
	}
	
	/**
	 * Tests if AI class loads successfully
	 */
	@Test
	public void testLoadAI() {
		assertTrue("AI not loaded", ai != null);
	}
	
	
	/**
	 * Test number 9
	 * Tests if AI's move is indeed in a valid box.
	 */
	@Test
	public void testAIsNextTurn(){
		ai.callMiniMax(0, 1);
		int boxNum = ai.returnBestMove();
		
		assertTrue("The AI move of "+boxNum+" was not valid", boxNum <= 8 && boxNum >= 0);
	}
	
	/**
	 * Test number 11
	 * Tests the existence of an AI playing the game
	 */
	@Test
	public void testAIExistence(){
		ai.callMiniMax(0, 1);

		BoardJFrame boardJ = new BoardJFrame();
		
		boardJ.AIMoves(0, ai.returnBestMove());
		
		// If ai is playing then a box should be filled
		assertTrue("AI is not playing.", 
				boardJ.boardTictactoes[0].getEmptyBoxes().size() != 8);
	}
	
}