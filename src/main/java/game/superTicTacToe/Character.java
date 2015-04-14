package main.java.game.superTicTacToe;

/*
 * This class holds the current character being placed
 * Either "X" or "O"
 */

public class Character extends Entity {

	public String type;
	public static final String HUMAN = "human";
	public static final String AI = "AI";
	
	public Character(String humanOrAI) {
		if (humanOrAI.equals(HUMAN))
			type = "X";
		else if (humanOrAI.equals(AI))
			type = "O";
		else
			type = "N/A"; // This is so that when instantiating Character class its not null...
	}
	
	/**
	 * Returns true if "type" is same
	 * @return
	 */
	public boolean equals(Character character) {
		if (type.equals(character.type)) return true;
		else return false;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
