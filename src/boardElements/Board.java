package boardElements;

public class Board {
	int numOfX;
	int numOfO;
	boolean finished;
	String finalMessage;
	Move allMoves[];

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
