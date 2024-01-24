package warPack;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class WarWindow {

	private JFrame frame;
	private Deck gameDeck;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WarWindow window = new WarWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WarWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		// Create the game deck
		gameDeck = new Deck();
		gameDeck.createDeck();
		gameDeck.shuffle();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 412, 297);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JLabel oppCardLabel = new JLabel("");
		oppCardLabel.setBackground(Color.WHITE);
		oppCardLabel.setBounds(188, 25, 131, 168);
		frame.getContentPane().add(oppCardLabel);
		JLabel playerCardLabel = new JLabel("");
		playerCardLabel.setBackground(new Color(255, 255, 255));
		playerCardLabel.setBounds(33, 25, 131, 168);
		frame.getContentPane().add(playerCardLabel);
		
		JButton drawButton = new JButton("Draw Card");
		drawButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Card player_card = gameDeck.drawCard();
				Card opp_card = gameDeck.drawCard();
				playerCardLabel.setIcon(player_card.getImg());
				oppCardLabel.setIcon(opp_card.getImg());
				if(player_card.value > opp_card.value) {
					// player wins!
				}else if(player_card.value < opp_card.value){
					// player lost!
				}else {
					// tie!
				}
			}
		});
		drawButton.setBounds(43, 204, 89, 23);
		frame.getContentPane().add(drawButton);
		
	}
}
