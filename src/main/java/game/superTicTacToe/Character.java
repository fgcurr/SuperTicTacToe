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
		if (humanOrAI.equals(HUMAN)) {
			type = "X";
			Board.numOfX++;
		}
		else if (humanOrAI.equals(AI)) {
			Board.numOfO++;
			type = "O";
		}
		else
			type = "N/A"; // This is so that when instantiating Character class its not null...
	}
	
	// 1 = computer, 2 = human. This constructor used when not making an actual move
	public Character(int move) {
		if (move == 1)
			type = "O";
		else if (move == 2)
			type = "X";
		else type = "N/A";
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
