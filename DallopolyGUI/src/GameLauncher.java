import javax.swing.JFrame;

//Adam Butcher
//GameLauncher.java
//Dallopoly - A game for the iron and horse pieces. This time, with MONEY! And it's a GUI display.
//CS 2336.501
//Mr. Khan

public class GameLauncher {
	public static void main(String args[]) {
		//The following line tests the condition of the board
		//Board b = new Board();
		DallopolyWindow window = new DallopolyWindow();
		window.setSize(600,400);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setTitle("Dallopoly");
		window.pack();
		
		//Dallopoly game = new Dallopoly();
		//String s = game.playGame();
		//System.out.println(s);		
	}//end main
}//end class GameLauncher
