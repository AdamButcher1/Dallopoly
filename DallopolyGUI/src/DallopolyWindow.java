import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class DallopolyWindow extends JFrame implements ActionListener {
	
	private Dallopoly game;
	
	//3 buttons for using
	private JButton newGameButton;
	private JButton addPlayer;
	private JButton play;
	
	//Label for the player name
	private JLabel playerName;
	
	//Text for entering player and showing results
	private JTextField playerField;
	private JTextArea output;
	
	//The panels to be used in the program
	private JPanel northPanel;
	private JPanel southPanel;
	
	//how players are initialized
	private int players = 0;
	
	public DallopolyWindow() {
		//create stuff for the north panel
		northPanel = new JPanel();
		northPanel.setLayout(new GridLayout(1, 4));
		
		//added features
		newGameButton = new JButton("New Game");
		playerName = new JLabel("Player Name:");
		playerField = new JTextField(15);
		addPlayer = new JButton("Add Player");
		play = new JButton("Play");
		
		//Everything added to the north panel
		northPanel.add(newGameButton);
		northPanel.add(playerName);
		northPanel.add(playerField);		
		northPanel.add(addPlayer);
		add(northPanel, BorderLayout.NORTH);
		
		//Everything added to south panel
		southPanel = new JPanel();
	    output = new JTextArea(30, 40);
	    output.setEditable(false);
	    southPanel.add(new JScrollPane(output));
	    southPanel.add(play);
		add(southPanel, BorderLayout.SOUTH);
		
		//Make the buttons do things
		newGameButton.addActionListener(this);
		addPlayer.addActionListener(this);
		play.addActionListener(this);
		
		//Disable other buttons when new game is not clicked
		addPlayer.setEnabled(false);
		play.setEnabled(false);
		
	}

	
public void actionPerformed(ActionEvent e) {
	
		//Create the new Dallopoly object and enable the option to add the player when hit.
		if (e.getSource() == newGameButton) {
			game = new Dallopoly();
			output.setText(output.getText() + "NEW GAME!!\n");
			newGameButton.setEnabled(false);
			addPlayer.setEnabled(true);
		}
		
		//Add 2 players to this game.
		else if (e.getSource() == addPlayer) {
			String playerEntered = game.addPlayer(playerField.getText());
			output.setText(output.getText() + "Player Added: " + playerEntered + "\n");
			players++;
			if (players == 2) {
			play.setEnabled(true);
			//addPlayer.setEnabled(false);
			}
		}
		
		//Play the game with this button and reset players after finished
		else if (e.getSource() == play) {
			addPlayer.setEnabled(false);
			String s = game.playGame();
			output.setText(output.getText() + s + "\n");
			newGameButton.setEnabled(true);
			play.setEnabled(false);
			players = 0;
		}
	}
	
}