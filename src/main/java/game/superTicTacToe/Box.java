package main.java.game.superTicTacToe;

public class Box extends Entity{

	// Character enclosed in this box
	private Character character;
	// This box's number within a tictactoe 0-8
	private int num;
	// is this box empty?
	boolean empty;
	
	// box empty at the start, but character can't be null so its '0'
	public Box() {
		empty = true;
		character = new Character("N/A");
	}
	
	// Public constructor for setting the box number from tic tac toe
	public Box(int num) {
		empty = true;
		character = new Character("N/A");
		this.num = num;
	}
	
	public int getNum() {
		return num;
	}

	public Character getCharacter() {
		return character;
	}
	
	
	public boolean isEmpty(){
		return empty;
	}
	
	/**
	 * This method sets a character in this box
	 */
	public void set(Character character) {
		empty = false;
		this.character = character;
	}
	
	/**
	 * This method unsets a char in this box, mainly for AI
	 */
	public void unSet() {
		empty = true;
		this.character = new Character("N/A");
	}
}
