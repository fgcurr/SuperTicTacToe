package main.java.game.superTicTacToe;

import java.util.Random;

public class Move {
	
	int firstMove;
	
	public Move() {
		
	}
	
	public void move(Character character, Box b) {
		b.set(character);
	}
	
	/**
	 * Picks who will take the first move.
	 * 
	 * @return
	 * 0 - The AI will take the first move.<br>
	 * 1 - The Human will take the first move.
	 */
	public int pickFirstMove(){
		Random rndm = new Random();
		
		firstMove = rndm.nextInt(2);
		
		System.out.println(firstMove);
		
		return firstMove;
	}
}
