package boardElements;

public class Board {
	int numOfX;
	int numOfO;
	boolean finished;
	String finalMessage;
	Move allMoves[];

	public Board(){
		numOfX = 0;
		numOfO = 0;
		finished = false;
		finalMessage = "Game Over!";
		allMoves = new Move[81];
	}
	
	public boolean isFinished(){
		return finished;
	}

	public String displayMessage(){
		if(isFinished()){
			return finalMessage;
		}
		else return "";
	}
}
