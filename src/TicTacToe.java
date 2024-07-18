import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TicTacToe implements ActionListener{

	final Timer timer = new Timer();
	ImageIcon image = new ImageIcon("tac_tic_toe_icon_183167.png");
	Random random = new Random();
	JFrame frame = new JFrame("Tic-Tac-Toe");
	JPanel title_panel = new JPanel();
	JPanel button_panel = new JPanel();
	JLabel textField = new JLabel();
	JButton[] buttons = new JButton[9];
	boolean player1_turn;
	
	TicTacToe(){
		
		frame.setIconImage(image.getImage());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		frame.getContentPane().setBackground(new Color(50,50,50));
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		textField.setBackground(new Color(25,25,25));
		textField.setForeground(new Color(25,255,0));
		textField.setFont(new Font("Ink Free",Font.BOLD,75));
		textField.setHorizontalAlignment(JLabel.CENTER);
		textField.setText("Tic-Tac-Toe");
		//textField.setLocation(textField.getX(),textField.getY()+50);  // center textField in Y axe 
		textField.setOpaque(true);
		
		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0, 0, 800, 100);
		
		button_panel.setLayout(new GridLayout(3,3));
		button_panel.setBackground(new Color(150,150,150));
		
		for(int i=0;i<9;i++) {
			buttons[i] = new JButton();
			button_panel.add(buttons[i]);
			buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}
		
		title_panel.add(textField);
		frame.add(title_panel,BorderLayout.NORTH);
		frame.add(button_panel);
		
		firstTurn();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i=0;i<9;i++) {
			if(e.getSource()==buttons[i]) {
				if(player1_turn) {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(new Color(255,0,0));
						buttons[i].setText("X");
						player1_turn = false;
						textField.setText("O Turn");
						check();
					}
				}
				else {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(new Color(0,0,255));
						buttons[i].setText("O");
						player1_turn = true;
						textField.setText("X Turn");
						check();
					}
				}
			}
		}
		
	}
	
	public void firstTurn() {
		try {
			Thread.sleep(1200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(random.nextInt(2)==0) {
			player1_turn = true;
			textField.setText("X Turn");
		}
		else {
			player1_turn = false;
			textField.setText("O Turn");
		}
	}
	
	public void check() {
		// check X win conditions
		if(
				(buttons[0].getText()=="X") && 
				(buttons[1].getText()=="X") &&
				(buttons[2].getText()=="X")
				) {
			xWins(0,1,2);
		}
		else if(
				(buttons[3].getText()=="X") && 
				(buttons[4].getText()=="X") &&
				(buttons[5].getText()=="X")
				) {
			xWins(3,4,5);
		}
		else if(
				(buttons[6].getText()=="X") && 
				(buttons[7].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
			xWins(6,7,8);
		}
		else if(
				(buttons[0].getText()=="X") && 
				(buttons[3].getText()=="X") &&
				(buttons[6].getText()=="X")
				) {
			xWins(0,3,6);
		}
		else if(
				(buttons[1].getText()=="X") && 
				(buttons[4].getText()=="X") &&
				(buttons[7].getText()=="X")
				) {
			xWins(1,4,7);
		}
		else if(
				(buttons[2].getText()=="X") && 
				(buttons[5].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
			xWins(2,5,8);
		}
		else if(
				(buttons[0].getText()=="X") && 
				(buttons[4].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
			xWins(0,4,8);
		}
		else if(
				(buttons[2].getText()=="X") && 
				(buttons[4].getText()=="X") &&
				(buttons[6].getText()=="X")
				) {
			xWins(2,4,6);
		}
		
		// check O wins conditions
		else if(
				(buttons[0].getText()=="O") && 
				(buttons[1].getText()=="O") &&
				(buttons[2].getText()=="O")
				) {
			oWins(0,1,2);
		}
		else if(
				(buttons[3].getText()=="O") && 
				(buttons[4].getText()=="O") &&
				(buttons[5].getText()=="O")
				) {
			oWins(3,4,5);
		}
		else if(
				(buttons[6].getText()=="O") && 
				(buttons[7].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
			oWins(6,7,8);
		}
		else if(
				(buttons[0].getText()=="O") && 
				(buttons[3].getText()=="O") &&
				(buttons[6].getText()=="O")
				) {
			oWins(0,3,6);
		}
		else if(
				(buttons[1].getText()=="O") && 
				(buttons[4].getText()=="O") &&
				(buttons[7].getText()=="O")
				) {
			oWins(1,4,7);
		}
		else if(
				(buttons[2].getText()=="O") && 
				(buttons[5].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
			oWins(2,5,8);
		}
		else if(
				(buttons[0].getText()=="O") && 
				(buttons[4].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
			oWins(0,4,8);
		}
		else if(
				(buttons[2].getText()=="O") && 
				(buttons[4].getText()=="O") &&
				(buttons[6].getText()=="O")
				) {
			oWins(2,4,6);
		}
	}
	
	public void xWins(int a,int b,int c) {
		buttons[a].setBackground(Color.green);
		buttons[b].setBackground(Color.green);
		buttons[c].setBackground(Color.green);
		
		for(int i=0;i<9;i++) {
			buttons[i].setEnabled(false);
		}
		textField.setText("X Wins!"); 
		
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				for(int i=0;i<9;i++) {
					buttons[i].setEnabled(true);
					buttons[i].setBackground(new JButton().getBackground());
					buttons[i].setText("");
				}
				textField.setText("Tic-Tac-Toe");
				firstTurn();
			}
			
		}, 5000);
	}
	
	public void oWins(int a,int b,int c) {
		buttons[a].setBackground(Color.green);
		buttons[b].setBackground(Color.green);
		buttons[c].setBackground(Color.green);
		
		for(int i=0;i<9;i++) {
			buttons[i].setEnabled(false);
		}
		textField.setText("O Wins!");
		
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				for(int i=0;i<9;i++) {
					buttons[i].setEnabled(true);
					buttons[i].setBackground(new JButton().getBackground());
					buttons[i].setText("");
				}
				textField.setText("Tic-Tac-Toe");
				firstTurn();
			}
			
		}, 5000);
	}
}
