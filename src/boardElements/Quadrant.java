package boardElements;

public class Quadrant extends Entity{
	
	int number;
	TicTacToe tictactoe;
	boolean complete;
	boolean outlined;
	boolean active;
	
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
