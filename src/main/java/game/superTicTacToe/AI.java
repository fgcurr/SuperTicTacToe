package main.java.game.superTicTacToe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class BoxAndScore {
	int score;
	int boxnum;
	
	public BoxAndScore(int score, int boxnum) {
		this.score = score;
		this.boxnum = boxnum;
	}
}

public class AI {
	/*
	 * Implementation of AI using MiniMax algorithm
	 * http://en.wikipedia.org/wiki/Minimax
	 */
	
	private boolean[] turns;
	private TicTacToe tictactoe;
	private List<BoxAndScore> rootsChildrenScores;
	
	public AI(TicTacToe tictactoe) {
		this.tictactoe = tictactoe;
		rootsChildrenScores = new ArrayList();
	}
	
	public void callMiniMax(/* TicTacToe tictactoe */int depth, int turn) {
		rootsChildrenScores = new ArrayList();
		minimax(tictactoe, depth, turn);
	}
	
	/**
	 * Returns the best move according to the minimax algorithm.
	 * Recursive algorithm with a base condition of returning the score if tictactoe is over
	 * turn 1 = Computer, turn 2 = Human
	 */
	public int minimax(TicTacToe tictactoe, int depth, int turn) {
		
		// If tic tac toe is over then return with respective scores
		if (tictactoe.isLinedUp(new Character(Character.AI))) return +1;
		if (tictactoe.isLinedUp(new Character(Character.HUMAN))) return -1;
		List<Box> availableboxes = tictactoe.getEmptyBoxes();
		if (availableboxes.isEmpty()) return 0;
		
		List<Integer> scores = new ArrayList();
		for (Box b : tictactoe.boxes) {
			if (b.isEmpty()) {
				if (turn == 1) { // Computer's turn
					b.set(new Character(Character.AI));
					int currentscore = minimax(tictactoe, depth + 1, 2);
					scores.add(currentscore);
					
					if (depth == 0)
						rootsChildrenScores.add(new BoxAndScore(currentscore, b.getNum()));
						
				}
				
				else if (turn == 2) { // Human's turn
					b.set(new Character(Character.HUMAN));
					int currentscore = minimax(tictactoe, depth + 1, 1);
					scores.add(currentscore);
				}
				b.unSet(); // Reset this box
			}
		}
		// Return max score if its comp or min score if its human
		return turn == 1 ? returnMax(scores) : returnMin(scores);
	}
	
	
    public static int returnMax(List<Integer> list) {
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < list.size(); ++i) {
            if (list.get(i) > max) {
                max = list.get(i);
                index = i;
            }
        }
        return list.get(index);
    }
    
    public static int returnMin(List<Integer> list) {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < list.size(); ++i) {
            if (list.get(i) < min) {
                min = list.get(i);
                index = i;
            }
        }
        return list.get(index);
    }
    
    /**
     * Method returns true if all scores are 0, meaning an empty box
     * @return same
     */
    public boolean emptyQuadrant() {
    	boolean same = true;
    	for (int i = 0; i<rootsChildrenScores.size()-1; i++) {
    		if (rootsChildrenScores.get(i).score != rootsChildrenScores.get(i+1).score || rootsChildrenScores.get(i).score != 0)
    			same = false;
    	}
    	return same;
    }
    
	public int returnBestMove() {
		
		int MAX = -100000;
        int best = -1;
		
		for (int i = 0; i < rootsChildrenScores.size(); ++i) { 
            if (MAX < rootsChildrenScores.get(i).score) {
                MAX = rootsChildrenScores.get(i).score;
                best = i;
            }
        }
		
		for (BoxAndScore pas : rootsChildrenScores) {
            System.out.println("Point: " + pas.boxnum + " Score: " + pas.score);
        }
		
		if (emptyQuadrant()) {
			// Select random since its an empty quadrant with each box comprising of 0 score
			Random rnd = new Random();
			best = rnd.nextInt(rootsChildrenScores.size());
		}
        return rootsChildrenScores.get(best).boxnum;
	}
}
