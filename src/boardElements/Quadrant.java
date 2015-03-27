package boardElements;

public class Quadrant {
	
	int number;
	TicTacToe tictactoe;
	boolean complete;
	boolean outlined;
	boolean active;
	
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
