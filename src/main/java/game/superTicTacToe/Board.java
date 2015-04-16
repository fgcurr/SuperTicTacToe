package main.java.game.superTicTacToe;

import javax.swing.JPanel;

public class Board {
	public static int numOfX;
	public static int numOfO;
	public boolean finished;
	public String finalMessage;
	public Move allMoves[];
	public Quadrant quads[];
//	public TicTacToe tictactoes[]; tic tac toes are initialized in each quadrant..
//	public Box[][] boxes; boxes are initialized in each tic tac toe
	public Character character;

	public Board(){
		numOfX = 0;
		numOfO = 0;
		finished = false;
		finalMessage = "Game Over!";
		allMoves = new Move[81];
		quads = new Quadrant[9];
		for (int i =0; i<9; i++) {
			quads[i] = new Quadrant();
		}
//		character = new Character();
	}
	
	public void setQuadrants(JPanel panels[]){
		for(int i = 0; i < quads.length; i++){
			quads[i].setQuadrant(panels[i]);
		}
	}
	
	public int findQuadrant(JPanel parent){
		int quadrant = 0;
		
		for (int i =0; i<9; i++) {
			if (quads[i].getQuadrant().equals(parent)) {
				System.out.print("["+i+",");
				quadrant = i;
				break;
			}
		}
		return quadrant;
	}
	
	public boolean isFinished(){
//		checkXO();
		isWonBy(new Character(2));
		isWonBy(new Character(1));
		return finished;
	}
	
	/**
	 * Returns true if the board has been won by a player
	 * @param character
	 * @return
	 */
	public boolean isWonBy(Character character) {


		if(quads[0].tictactoe.isLinedUp(character) && quads[1].tictactoe.isLinedUp(character) && quads[2].tictactoe.isLinedUp(character))
		{
			finished = true;
			return true;
		}
		else if(quads[3].tictactoe.isLinedUp(character) && quads[4].tictactoe.isLinedUp(character) && quads[5].tictactoe.isLinedUp(character))
		{
			finished = true;
			return true;
		}
		else if(quads[6].tictactoe.isLinedUp(character) && quads[7].tictactoe.isLinedUp(character) && quads[8].tictactoe.isLinedUp(character))
		{
			finished = true;
			return true;
		}
		else if(quads[0].tictactoe.isLinedUp(character) && quads[3].tictactoe.isLinedUp(character) && quads[6].tictactoe.isLinedUp(character))
		{
			finished = true;
			return true;
		}
		else if(quads[1].tictactoe.isLinedUp(character) && quads[4].tictactoe.isLinedUp(character) && quads[7].tictactoe.isLinedUp(character))
		{
			finished = true;
			return true;
		}
		else if(quads[2].tictactoe.isLinedUp(character) && quads[5].tictactoe.isLinedUp(character) && quads[8].tictactoe.isLinedUp(character))
		{
			finished = true;
			return true;
		}
		else if(quads[0].tictactoe.isLinedUp(character) && quads[4].tictactoe.isLinedUp(character) && quads[8].tictactoe.isLinedUp(character))
		{
			finished = true;
			return true;
		}
		else if(quads[2].tictactoe.isLinedUp(character) && quads[4].tictactoe.isLinedUp(character) && quads[6].tictactoe.isLinedUp(character))
		{
			finished = true;
			return true;
		}
		else
		{
			return false;
		}
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
