package main.java.game.gui;


import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import main.java.game.superTicTacToe.AI;
import main.java.game.superTicTacToe.Board;
import main.java.game.superTicTacToe.Box;
import main.java.game.superTicTacToe.Quadrant;
import main.java.game.superTicTacToe.TicTacToe;
import main.java.game.superTicTacToe.Character;

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
    			boxes[i][j].setFont(new Font("Helvetica", Font.PLAIN, 25));
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
    	
    	board.setQuadrants(panels);
    	
    	for (int i =0; i<9; i++) {
    		content.add(panels[i]);
    	}
    }
    
    /**
     * This method handles the graphical elements of AI placing a move, pretty simple.
     */
    public void AIMoves(int quadrant, int box) {
    	// Get the button to be set
    	JButton aiButton = boxes[quadrant][box];
    	
    	// Get button's text
		String text = aiButton.getText();
		// If button is already played then return
		if (text.equals("O") || text.equals("X"))
			return;
		
		// Set that specific board Box to be set!
		boardBoxes[quadrant][box].set(new Character(Character.AI));
		
		// Set the button
		aiButton.setText("O");
		aiButton.setForeground(Color.RED);
		
		// Get parent (quadrant which was clicked)
		JPanel parent = (JPanel)aiButton.getParent();
		
		// Check if this quadrant is over and disable it accordingly
		checkAndDisable(boardQuads[quadrant], boardTictactoes[quadrant]);
		
		System.out.println("Response: [" + quadrant + "," + box + "] ");
		
		// TODO: Release control to human here somewhere...
    }
    
    public void checkAndDisable(Quadrant quadrant, TicTacToe tictactoe) {
		if (tictactoe.isOver()) {
			if (tictactoe.isLinedUp(new Character(Character.AI))) {
				quadrant.setOutline(Color.RED);
			}
			
			else if (tictactoe.isLinedUp(new Character(Character.HUMAN))) {
				quadrant.setOutline(Color.BLUE);
			}
			
			else {
				// Should never be reached in a real super tic tac toe, because tictactoes dont draw!
				quadrant.setOutline(Color.GRAY);
			}
			
			quadrant.disable();
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
		
		// Get buttons text
		String text = pressed.getText();
		// If button is already played then return
		if (text.equals("O") || text.equals("X"))
			return;
		
		// Get parent (quadrant which was clicked)
		JPanel parent = (JPanel)pressed.getParent();
		quadrant = board.findQuadrant(parent);
		
		// Get box within the quadrant which was clicked
		for (int i =0; i<9; i++) {
			if (boxes[quadrant][i].equals(pressed)) {
				System.out.print(i + "] ");
				box = i;
				break;
			}
		}
		
		// Set that specific board Box class to be set!
		boardBoxes[quadrant][box].set(new Character(Character.HUMAN));
		
		// Just for purposes of making human "X"
		pressed.setText("X");
		pressed.setForeground(Color.BLUE);
		
		// Check if this quadrant is over and disable it accordingly
		checkAndDisable(boardQuads[quadrant], boardTictactoes[quadrant]);
		
		//TODO
//		boardTictactoes[quadrant]
		
		if (!boardTictactoes[quadrant].isOver()) {
			// Call the AI and ask him to make move:
			AI ai = new AI(boardTictactoes[quadrant]);
			ai.callMiniMax(0, 1);
			AIMoves(quadrant, ai.returnBestMove());
		}
		
	}
}
}