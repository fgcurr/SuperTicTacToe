package main.java.game.superTicTacToe;

import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Quadrant extends Entity{
	
	int number;
	public TicTacToe tictactoe;
	public JPanel quadrant;
	
	public void setTictactoe(TicTacToe tictactoe) {
		this.tictactoe = tictactoe;
	}
	
	public void setQuadrant(JPanel quadrant){
		this.quadrant = quadrant;
	}
	
	public JPanel getQuadrant(){
		return quadrant;
	}

	public boolean complete;
	public boolean outlined;
	public boolean active;
	
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
	
	public void disable(){
		for (Component b : quadrant.getComponents()) {
			JButton cb = (JButton) b;
			cb.setEnabled(false);
		}
	}
	
	public void enable(){
		for (Component b : quadrant.getComponents()) {
			JButton cb = (JButton) b;
			cb.setEnabled(true);
		}
	}
	
	public void setOutline(Color color){
		Border border = BorderFactory.createLineBorder(color, 2);
		quadrant.setBorder(border);
	}
}
