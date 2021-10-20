import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class GuessingGame extends JFrame{
	private JTextField txtGuess; // declaring outside class, makes variable accessible 
	private JLabel lblOutput; // anywhere inside class, like a global variable
	private int theNumber;
	public void checkGuess(){ // creating a public method
		String guessText = txtGuess.getText();
		String message = "";
		int guess = Integer.parseInt(guessText);
		if (guess < theNumber) {
			message = guess + " is too low. Try again.";
		}
		else if (guess > theNumber) {
			message = guess + " is too high. Try again.";
		}
		else {
			message = guess + " is correct. You win! Let's play again!";
			newGame();
		}
		lblOutput.setText(message);
		txtGuess.requestFocus();
		txtGuess.selectAll();
	}
	public void newGame() {
		theNumber = (int)(Math.random() * 100 + 1);
	}
	
	public GuessingGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Jesse Kniss's Hi-Lo Guessing Game");
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Jesse Kniss's HiLo Guessing Game");
		lblNewLabel.setFont(new Font("Plantagenet Cherokee", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(109, 6, 247, 16);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(207, 150, 61, -4);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Guess a number between 1 and 100:");
		lblNewLabel_1.setFont(new Font("Plantagenet Cherokee", Font.BOLD, 13));
		lblNewLabel_1.setBounds(118, 68, 228, 26);
		getContentPane().add(lblNewLabel_1);
		
		txtGuess = new JTextField();
		txtGuess.setHorizontalAlignment(SwingConstants.RIGHT);
		txtGuess.setBounds(167, 112, 130, 26);
		getContentPane().add(txtGuess);
		txtGuess.setColumns(10);
		
		txtGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		
		JButton btnGuess = new JButton("Guess!");
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		btnGuess.setFont(new Font("Plantagenet Cherokee", Font.BOLD, 13));
		btnGuess.setBounds(174, 151, 117, 29);
		getContentPane().add(btnGuess);
		
		lblOutput = new JLabel("Enter a number and click Guess!");
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(121, 219, 222, 16);
		getContentPane().add(lblOutput);
	}

	public static void main(String[] args) {
		GuessingGame theGame = new GuessingGame();
		theGame.newGame();
		theGame.setSize(new Dimension(450, 450));
		theGame.setVisible(true);

	}
}
