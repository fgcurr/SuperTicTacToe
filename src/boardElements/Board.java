package boardElements;

public class Board {
	public int numOfX;
	public int numOfO;
	public boolean finished;
	public String finalMessage;
	public Move allMoves[];
	public Quadrant quads[];

	public Board(){
		numOfX = 0;
		numOfO = 0;
		finished = false;
		finalMessage = "Game Over!";
		allMoves = new Move[81];
		quads = new Quadrant[9];
	}
	
	public boolean isFinished(){
		checkXO();
		return finished;
	}
	
	public void checkXO(){
		if(numOfX >= 40  || numOfO >= 40){
			finished = true;
		}
	}

	public String displayMessage(){
		if(isFinished()){
			return finalMessage;
		}
		else return "";
	}
}
