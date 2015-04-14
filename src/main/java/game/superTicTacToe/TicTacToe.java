package main.java.game.superTicTacToe;

import java.util.ArrayList;
import java.util.List;

public class TicTacToe extends Entity{

	public Box boxes[];
	
	// Is this tic tac toe over/finished?
	private boolean over;
	
	/**
	 * Checks if the tictactoe is over by checking if it is lined up by either ai or human or draw (BTW, a tictactoe should never draw in super tic tac toe)
	 * @return
	 */
	public boolean isOver() {
		if (isLinedUp(new Character(Character.HUMAN)) || isLinedUp(new Character(Character.AI))
				|| getEmptyBoxes().isEmpty()) {
			over = true;
			return over;
		} else {
			over = false;
			return over;
		}
	}

	public void setOver(boolean over) {
		this.over = over;
	}

	public TicTacToe() {
		boxes = new Box[9];
		for (int i=0; i<9; i++) {
			boxes[i] = new Box(i);
		}
	}
	
	public List<Box> getEmptyBoxes() {
		
		List<Box> list = new ArrayList<Box>();
		for (Box b : boxes) {
			if (b.isEmpty())
				list.add(b);
		}
		return list;
	}
	
	public boolean isLinedUp(Character a){

		if(boxes[0].getCharacter().equals(boxes[1].getCharacter()) && boxes[1].getCharacter().equals(boxes[2].getCharacter()) && boxes[0].getCharacter().equals(a))
		{
			return true;
		}
		else if(boxes[3].getCharacter().equals(boxes[4].getCharacter()) && boxes[4].getCharacter().equals(boxes[5].getCharacter()) && boxes[3].getCharacter().equals(a))
		{
			return true;
		}
		else if(boxes[6].getCharacter().equals(boxes[7].getCharacter()) && boxes[7].getCharacter().equals(boxes[8].getCharacter()) && boxes[6].getCharacter().equals(a))
		{
			return true;
		}
		else if(boxes[0].getCharacter().equals(boxes[3].getCharacter()) && boxes[3].getCharacter().equals(boxes[6].getCharacter()) && boxes[6].getCharacter().equals(a))
		{
			return true;
		}
		else if(boxes[1].getCharacter().equals(boxes[4].getCharacter()) && boxes[4].getCharacter().equals(boxes[7].getCharacter()) && boxes[7].getCharacter().equals(a))
		{
			return true;
		}
		else if(boxes[2].getCharacter().equals(boxes[5].getCharacter()) && boxes[5].getCharacter().equals(boxes[8].getCharacter()) && boxes[8].getCharacter().equals(a))
		{
			return true;
		}
		else if(boxes[0].getCharacter().equals(boxes[4].getCharacter()) && boxes[4].getCharacter().equals(boxes[8].getCharacter()) && boxes[8].getCharacter().equals(a))
		{
			return true;
		}
		else if(boxes[2].getCharacter().equals(boxes[4].getCharacter()) && boxes[4].getCharacter().equals(boxes[6].getCharacter()) && boxes[6].getCharacter().equals(a))
		{
			return true;
		}
		else
		{
			return false;
		}
	
	}
}
