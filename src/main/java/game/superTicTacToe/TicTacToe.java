package main.java.game.superTicTacToe;

public class TicTacToe extends Entity{

	public Box boxes[];
	
	public TicTacToe() {
		boxes = new Box[9];
		for (int i=0; i<9; i++) {
			boxes[i] = new Box();
		}
	}
	
	public boolean isLinedUp(){
		//TODO Add logic here.
		return true;
	}
}
