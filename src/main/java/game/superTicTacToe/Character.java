package main.java.game.superTicTacToe;

/*
 * This class holds the current character being placed
 * Either "X" or "O"
 */

public class Character extends Entity {

	public String type;
	
	public Character() {
		type = "X";
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	// Before each move the board will call this method to get the correct character
	public String placeChar() {
		if (type.equals("X")) {
			type = "O";
			return "X";
		} else {
			type = "X";
			return "O";
		}
	}

}
