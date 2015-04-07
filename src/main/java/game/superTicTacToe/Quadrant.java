package main.java.game.superTicTacToe;

public class Quadrant extends Entity{
	
	int number;
	TicTacToe tictactoe;
	public boolean complete;
	public boolean outlined;
	public boolean active;
	
	public Quadrant(){
		tictactoe = new TicTacToe();
	}
	
	public boolean isComplete(){
		return complete;
	}
	
	public boolean isOutlined(){
		return outlined;
	}
	
	public boolean isActive(){
		return active;
	}
}
