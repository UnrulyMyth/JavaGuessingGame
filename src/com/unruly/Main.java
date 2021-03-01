package com.unruly;

import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Main extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JTextField userGuess;
	private JLabel numberInfoOutput = new JLabel("");
	private JButton restartButton = new JButton("Restart");
	private int guessedNumber = 0;
	private static int randomNumber = 0;


	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("HiLo Guessing Game");
		getContentPane().setLayout(null);
		
		JLabel nameLabel = new JLabel("HI-LO GUESSING GAME");
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setBounds(-108, 11, 414, 14); 
		getContentPane().add(nameLabel);
		
		JLabel infoLabel = new JLabel("Enter a number from 1 to 100:");
		infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		infoLabel.setBounds(-108, 33, 414, 14);
		getContentPane().add(infoLabel);
		
		userGuess = new JTextField();
		userGuess.setBounds(62, 83, 86, 20);
		getContentPane().add(userGuess);
		userGuess.setColumns(10);
		
		JButton submitGuess = new JButton("Submit");
		submitGuess.setBounds(59, 111, 89, 23);
		getContentPane().add(submitGuess);
		submitGuess.addActionListener(e -> {
			try {
				checkGuess();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		});
		
		numberInfoOutput.setHorizontalAlignment(SwingConstants.CENTER);
		numberInfoOutput.setBounds(36, 58, 134, 14);
		getContentPane().add(numberInfoOutput);
		
		restartButton.setVisible(false);
		restartButton.setBounds(59, 137, 89, 23);
		restartButton.addActionListener(e -> restartGame());
		getContentPane().add(restartButton);
	}

	public static void main(String[] args) {
		Random rand = new Random();
		randomNumber = rand.nextInt(100);
		System.out.println(randomNumber);
		Main main = new Main();
		main.setSize(210, 210);
		main.setVisible(true);
	}
	
	public void checkGuess() throws InterruptedException {
		String guessText = userGuess.getText();
		
		try {
			guessedNumber = Integer.parseInt(guessText);
		} catch (Exception e) {
			numberInfoOutput.setText("Enter a valid number!");
		}
		
		if (guessedNumber > randomNumber)
			numberInfoOutput.setText("Too high!");
		else if (guessedNumber < randomNumber)
			numberInfoOutput.setText("Too low!");
		else {
			numberInfoOutput.setText("You win!");
			restartButton.setVisible(true);
		}
	}
	
	// We just change the random number and delete any old data and start again!
	public void restartGame() {
		numberInfoOutput.setText("");
		restartButton.setVisible(false);
		userGuess.setText("");
		
		Random rand = new Random();
		randomNumber = rand.nextInt(100);
	}
}
