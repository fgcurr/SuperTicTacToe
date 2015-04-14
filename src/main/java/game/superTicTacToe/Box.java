package main.java.game.superTicTacToe;

public class Box extends Entity{

	// Character enclosed in this box
	private Character character;
	// is this box empty?
	boolean empty;
	
	// box empty at the start, but character can't be null so its '0'
	public Box() {
		empty = true;
		character = new Character("N/A");
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
}
