import java.util.ArrayList;


public class Dallopoly {
	//3 variables for creating objects.
	Spinner theSpinner;
	Board theBoard;
	private ArrayList<Player> players;
	
	//3 different objects created with constructor
	public Dallopoly () {
		theSpinner = new Spinner();
		theBoard = new Board();
		players = new ArrayList<Player>();
	}
	
	//adding a player
	public String addPlayer(String s) {
		players.add(new Player(s, theBoard.getStartSquare()));
		return s;
	}
	
	public static void bubbleSort(int [] num, String [] name, Player [] square) {
	     int d;
	     boolean flag = true;   //the flag is true in order to pass
	     //3 temp variables to swap 3 portions.
	     int moneytemp;
	     String nametemp;
	     Player squaretemp;
	     while (flag) {
	            flag = false;    //flag is false for swap
	            for(d= 0; d < num.length -1;  d++) {
	                   if (num[d] < num[d+1]) {   // this is < for descending sort
	                	       //Swap 3 kinds of elements
	                	   	   moneytemp = num[d];
	                           num[d] = num[d+1];
	                           num[d+1] = moneytemp;
	                           nametemp = name[d];
	                           name[d] = name[d + 1];
	                           name[d+1] = nametemp;
	                           squaretemp = square[d];
	                           square[d] = square[d + 1];
	                           square[d+1] = squaretemp;
	                           flag = true;              //Shows a swap that has occured 
	                  } 
	            } 
	      } 
	} 
	
	//Method to play the game
	public String playGame() {
			String print = "\n";
			
			for (int a = 0; a < players.size(); a++) {
				print = print.concat(players.get(a).getName() + " has $" + players.get(a).getMoney() + players.get(a).getCurrentSquare() + "\n");
			}
			
			print = print.concat("\n");
			
			//print = print.concat("\n" + players.get(0).getName() + " has $" + players.get(0).getMoney() + players.get(0).getCurrentSquare() + "\n");
			//print = print.concat(players.get(1).getName() + " has $" + players.get(1).getMoney() + players.get(1).getCurrentSquare() + "\n \n");
			
			//set a flag that will change when the game ends
			boolean gameOver = false;
			//Create an outer loop that exits when a player wins
			while(gameOver == false) {
				//Loop through the ArrayList of players and
				for (int i = 0; i < players.size(); i++) {
				//send each player the "takeTurn" message.
				print = print.concat(players.get(i).takeTurn(theSpinner, theBoard) + "\n");
				//After the player has moved, compare the player’s new square
				//to the Board’s lastSquare. If the player is on the Board’s
					if (players.get(i).getCurrentSquare() == theBoard.getLastSquare()) {
						print = print.concat("GAME OVER!!! " + players.get(i).getName()
											+ " Landed on " + players.get(i) + "\n");
						
					int [] maxMoney = new int[players.size()];
					String [] maxName = new String[players.size()];
					Player [] maxSquare = new Player[players.size()];
						for (int x = 0; x < players.size(); x++) {
							maxMoney[x] = players.get(x).getMoney();
							maxName[x] = players.get(x).getName();
							maxSquare[x] = players.get(x);
						}
					bubbleSort(maxMoney,maxName,maxSquare);
					
					if (maxMoney[0] == maxMoney[1]) {
						print = print.concat("THE GAME IS A TIE FOR $" + maxMoney[0]);
					}
					else {
							print = print.concat("THE WINNER IS " + maxName[0] + " has $" + maxMoney[0]
								 + " is on " + maxSquare[0] + "\n");
					}
					
					//Bottom code commented out would be used for 2 players
					
					/*
					if (players.get(0).getMoney() > players.get(1).getMoney())
						print = print.concat("THE WINNER IS " + players.get(0).getName() + " has $" + players.get(0).getMoney()
								 + " is on " + players.get(0));
					else if (players.get(0).getMoney() < players.get(1).getMoney())
						print = print.concat("THE WINNER IS " + players.get(1).getName() + " has $" + players.get(1).getMoney()
								 + " is on " + players.get(1));
					else if (players.get(0).getMoney() == players.get(1).getMoney())
						print = print.concat("THE GAME ENDED IN A TIE");*/
					
					
						gameOver = true;
						break;
					//last square, end the game and declare the winner based on who has more money.
					//while loop.
					} // end if
				} // end for
				print = print.concat("\n");
			}	//end while
			return print;
			//end playGame
	}
	
	
}
