package main.java.game.superTicTacToe;

import java.util.ArrayList;
import java.util.List;

public class AI {
	/*
	 * Implementation of AI using MiniMax algorithm
	 * http://en.wikipedia.org/wiki/Minimax
	 */
	
	private boolean[] turns;
	private List<Move> moves;
	private TicTacToe tictactoe;
	
	public AI(TicTacToe tictactoe) {
		this.tictactoe = tictactoe;
		moves = new ArrayList<Move>();
	}
	
	/**
	 * Returns the best move according to the minimax algorithm.
	 * Recursive algorithm with a base condition of returning the score if tictactoe is over
	 * turn 1 = Computer, turn 2 = Human
	 */
	public static int minimax(TicTacToe tictactoe, int turn) {
		
		// If tic tac toe is over then return with respective scores
		if (tictactoe.isLinedUp(new Character(Character.AI))) return +1;
		if (tictactoe.isLinedUp(new Character(Character.HUMAN))) return -1;
		List<Box> availableboxes = tictactoe.getEmptyBoxes();
		if (availableboxes.isEmpty()) return 0;
		
		List<Integer> scores = new ArrayList<>();
		for (Box b : tictactoe.boxes) {
			if (turn == 1) { // Computer's turn
				b.set(new Character(Character.AI));
				int currentscore = minimax(tictactoe, 2);
				scores.add(currentscore);
			}
			
			else if (turn == 2) { // Human's turn
				b.set(new Character(Character.HUMAN));
				int currentscore = minimax(tictactoe, 1);
				scores.add(currentscore);
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
	 * Return boxes which are empty
	 * @param boxes
	 * @return List<Box>
	 */
	public List<Box> getAvailableBoxes(Box[] boxes) {
		List<Box> emptyBoxes = new ArrayList<Box>();
		for (Box b : boxes) {
			if (b.isEmpty()) {
				// If box is empty then place char here and simulate all possible scenarios
				System.out.println("EMPTY");
				emptyBoxes.add(b);
			}
		}
		return emptyBoxes;
	}
	
	// Can probably incorporate class Move here..
	
	public Box returnBestMove() {
		int MAX = -1000000;
		int best = -1;
		return null;
	}
	
	public static void main(String args[]) {
		TicTacToe tic = new TicTacToe();
		tic.boxes[0].set(new Character(Character.HUMAN));
		tic.boxes[1].set(new Character(Character.HUMAN));
		tic.boxes[2].set(new Character(Character.AI));
		tic.boxes[3].set(new Character(Character.AI));
		tic.boxes[4].set(new Character(Character.AI));
		tic.boxes[5].set(new Character(Character.HUMAN));
		tic.boxes[5].set(new Character(Character.AI));
		tic.boxes[7].set(new Character(Character.HUMAN));
		tic.boxes[8].set(new Character(Character.AI));
		System.out.println(tic.isOver());
//		minimax(tic, 0);
	}
}
