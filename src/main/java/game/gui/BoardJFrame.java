package main.java.game.gui;


import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import main.java.game.superTicTacToe.AI;
import main.java.game.superTicTacToe.Board;
import main.java.game.superTicTacToe.Box;
import main.java.game.superTicTacToe.Character;
import main.java.game.superTicTacToe.Move;
import main.java.game.superTicTacToe.Quadrant;
import main.java.game.superTicTacToe.TicTacToe;

/**
 *
 * @author User
 */
public class BoardJFrame extends javax.swing.JFrame {
	private static final String TITLE = "Super Tic Tac Toe";
	private static final int WIDTH = 900;
	private static final int HEIGHT = 900;
    private Container content;
    private JLabel title;
    public  JButton[][] boxes;
    public  JButton exitButton;
    public  JButton resetButton;
    private JPanel[] panels;
    private JPanel titlepanel;
    private BoxHandler[][] boxHandlers;
    
    // Class declaration
    public Board board;
    public Quadrant[] boardQuads;
    public TicTacToe[] boardTictactoes;
    public Box[][] boardBoxes;
    
    public int activequad; // For disabling every other quad
    public static BoardJFrame frame;
     
    public BoardJFrame() {
    	setTitle(TITLE);
    	setSize(WIDTH, HEIGHT);
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	
    	// Board class initialization
    	board = new Board();
    	boardQuads = board.quads;
    	boardTictactoes = new TicTacToe[9];
    	boardBoxes = new Box[9][9];
    	
    	// GUI initialization
    	content = getContentPane();
    	content.setBackground(Color.blue.darker());
    	content.setLayout(new GridLayout(4,3));
    	boxes = new JButton[9][9];
    	panels = new JPanel[9];
    	title = new JLabel("Welcome to Super Tic Tac Toe", SwingConstants.CENTER);
    	title.setForeground(Color.white);
    	title.setFont(new Font("Helvetica", Font.BOLD, 16));
    	boxHandlers = new BoxHandler[9][9];
    	Border border = BorderFactory.createLineBorder(Color.BLUE, 1);
    	
    	for (int i =0; i<9; i++) {
    		for (int j=0; j<9; j++) {
    			char ch = (char)('0'+j+1);
    			boxes[i][j] = new JButton(""+ch);
    			boxes[i][j].setFont(new Font("Helvetica", Font.PLAIN, 15));
    			boxHandlers[i][j] = new BoxHandler();
    			boxes[i][j].addActionListener(boxHandlers[i][j]);
    		}
    	}
    	
    	// Bottom UI initialization
//    	titlepanel = new JPanel();
    	exitButton = new JButton("EXIT");
    	exitButton.setFont(new Font("Helvetica", Font.BOLD, 30));
    	exitButton.addActionListener(new BoxHandler());
    	resetButton = new JButton("Restart");
    	resetButton.setFont(new Font("Helvetica", Font.BOLD, 30));
    	resetButton.addActionListener(new BoxHandler());
//    	titlepanel.add(title);
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
    	
    	content.add(resetButton);
    	content.add(title);
    	content.add(exitButton);
    	
    	firstMove();
    }
    
    /**
     * Disable all quadrants except 'activequad'.
     * If its a free turn enable all quadrants except the ones which are over
     */
    public void disableQuadrants() {
    	if (boardQuads[activequad].tictactoe.isOver()) {
    		for (int i =0; i < boardQuads.length; i++) {
    			if (!boardQuads[i].tictactoe.isOver())
    				boardQuads[i].enable();
    		}
    	}
    	else {
	    	for (int i = 0; i < boardQuads.length ; i++) {
	    		if (i == activequad) {
	    			boardQuads[i].enable();
	    		}
	    		else {
	    			boardQuads[i].disable();
	    		}
	    	}
    	}
    }
    
    /**
     * This method disables all
     */
    public void disableAll() {
    	for (int i =0; i < boardQuads.length; i++) {
    		boardQuads[i].disable();
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
		aiButton.setFont(new Font("Helvetica", Font.PLAIN, 25));
		aiButton.setForeground(Color.RED);
		
		// Get parent (quadrant which was clicked)
		JPanel parent = (JPanel)aiButton.getParent();
		
		// Check if this quadrant is over and disable it accordingly
		checkAndDisable(boardQuads[quadrant], boardTictactoes[quadrant]);
		
		System.out.println("Response: [" + quadrant + "," + box + "] ");
		
    }
    
    public int firstMove(){
    	Move firstMove = new Move();
    	int move = firstMove.pickFirstMove();
    	
    	if(move == 0){
    		Random rndm = new Random();
    		int aimove = rndm.nextInt(9); 
    		AIMoves(rndm.nextInt(9), aimove);
    		activequad = aimove;
    		disableQuadrants();
    	}
    	return move;
    }
    
    public void checkAndDisable(Quadrant quadrant, TicTacToe tictactoe) {
		if (tictactoe.isOver()) {
			if (tictactoe.isLinedUp(new Character(1))) {
				quadrant.setOutline(Color.RED);
			}
			
			else if (tictactoe.isLinedUp(new Character(2))) {
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
     * This method checks if the board is finished and disables everything and updates text at bottom
     */
    public boolean checkBoard() {
    	if (board.isFinished()) {
			if (board.isWonBy(new Character(1)))
				title.setText("AI won the game!");
			else if (board.isWonBy(new Character(2)))
				title.setText("Human won the game!");
			
			// Disable all buttons
			disableAll();
			return true;
		}
    	return false;
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
    	
    	frame = new BoardJFrame();
    	frame.setVisible(true);
    	frame.setResizable(false);
    }

class BoxHandler implements ActionListener
{
	
	int quadrant;
	int box;

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Get button pressed
		JButton pressed = (JButton)(e.getSource());
		
		// Get buttons text
		String text = pressed.getText();
		
		// If the exit button was pressed
		if(text == "EXIT"){
			System.out.println("Game exited");
			System.exit(0);
		}
		
		// If the restart button was pressed
		if(text == "Restart"){
			frame.dispose();
			main(null);
			return;
		}
		
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
		pressed.setFont(new Font("Helvetica", Font.PLAIN, 25));
		pressed.setForeground(Color.BLUE);
		
		// Check if this quadrant is over and disable it accordingly
		checkAndDisable(boardQuads[quadrant], boardTictactoes[quadrant]);
		
		if(checkBoard()){
			return;
		}
		
		Random rndm = new Random();

		// Pick a random box if one is over
		while(boardTictactoes[box].isOver()){
			box = rndm.nextInt(9);
		}
		
		if (!boardTictactoes[box].isOver()) {
			// Call the AI and ask him to make move:
			AI ai = new AI(boardTictactoes[box]);
			ai.callMiniMax(0, 1);
			int aimove = ai.returnBestMove();
			AIMoves(box, aimove);
			
//			AI ai = new AI(boardTictactoes[box]);
//			ai.callMiniMaxBoard(board, box, 0, 1);
//			int aimove = ai.returnBestMove();
//			AIMoves(box, aimove);
			
			// Disable all other quadrants
			activequad = aimove;
			disableQuadrants();
		}
		
		// If board is finished then return
//		checkBoard();
	}
}
}