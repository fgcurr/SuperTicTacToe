package main.java.game.superTicTacToe;

import javax.swing.JPanel;

public class Board {
	public int numOfX;
	public int numOfO;
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
