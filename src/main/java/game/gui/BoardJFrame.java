package main.java.game.gui;


import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import main.java.game.superTicTacToe.Board;
import main.java.game.superTicTacToe.Box;
import main.java.game.superTicTacToe.Quadrant;
import main.java.game.superTicTacToe.TicTacToe;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class BoardJFrame extends javax.swing.JFrame {
	private static final String TITLE = "Super Tic Tac Toe";
	private static final int WIDTH = 750;
	private static final int HEIGHT = 750;
    private Container content;
    private JLabel title;
    private JButton[][] boxes;
    private JPanel[] panels;
    private BoxHandler[][] boxHandlers;
    
    // Class declaration
    Board board;
    Quadrant[] boardQuads;
    TicTacToe[] boardTictactoes;
    Box[][] boardBoxes;
     
    public BoardJFrame() {
    	setTitle(TITLE);
    	setSize(WIDTH, HEIGHT);
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	
    	// Board class initialization
    	board = new Board();
    	boardQuads = board.quads;
    	boardTictactoes = new TicTacToe[9];
    	boardBoxes = new Box[9][9];
    	
    	content = getContentPane();
    	content.setBackground(Color.blue.darker());
    	content.setLayout(new GridLayout(3,3));
    	boxes = new JButton[9][9];
    	panels = new JPanel[9];
    	title = new JLabel("Welcome to Super Tic Tac Toe");
    	title.setLayout(new GridLayout(1,1));
    	boxHandlers = new BoxHandler[9][9];
    	Border border = BorderFactory.createLineBorder(Color.BLUE, 1);
    	
    	for (int i =0; i<9; i++) {
    		for (int j=0; j<9; j++) {
    			char ch = (char)('0'+j+1);
    			boxes[i][j] = new JButton(""+ch);
    			boxHandlers[i][j] = new BoxHandler();
    			boxes[i][j].addActionListener(boxHandlers[i][j]);
    		}
    	}
    	
    	for (int i =0; i<9; i++) {
    		panels[i] = new JPanel();
    		
    		// Board declaration assignments
    		boardTictactoes[i] = boardQuads[i].tictactoe;
    		boardBoxes[i] = boardTictactoes[i].boxes;
    		
    		panels[i].setBorder(border);
    		panels[i].setLayout(new GridLayout(3,3));
    		for (int j =0; j<9; j++) {
    			panels[i].add(boxes[i][j]);
    		}
    	}
    	
    	for (int i =0; i<9; i++) {
    		content.add(panels[i]);
    	}
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BoardJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BoardJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BoardJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BoardJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    	
    	BoardJFrame frame = new BoardJFrame();
    	frame.setVisible(true);
    	frame.setResizable(false);
    }

class BoxHandler implements ActionListener
{
	
	int quadrant;
	int box;

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// If board is finished then return
		if (board.finished)
			return;
		
		// Get button pressed
		JButton pressed = (JButton)(e.getSource());
		// Get its text
		String text = pressed.getText();
		// If button is already played then return
		if (text.equals("O") || text.equals("X"))
			return;
		
		 
		
		pressed.setText("X");
		
		// Get parent
		JPanel parent = (JPanel)pressed.getParent();
		int qnum = 0;
		for ( int i =0; i<9; i++) {
			if (panels[i].equals(parent)) {
				System.out.print("["+i+",");
				qnum = i;
				break;
			}
		}
		
		for (int i =0; i<9; i++) {
			if (boxes[qnum][i].equals(pressed)) {
				System.out.print(i + "] ");
				break;
			}
		}
	}
	
}
}