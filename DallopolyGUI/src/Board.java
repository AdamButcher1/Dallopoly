import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class Board {
	//Constructs an arraylist of squares and adds contents
	private ArrayList<Square> squares;
	
	public Board() {
		
		squares = new ArrayList<Square>(17);
		try {
			//Scanner and inFile help read open the file and scan it.
			File file = new File("squareList.txt");
			Scanner inFile = new Scanner(file);
			
			//This breaks up the text file
			inFile.useDelimiter(",|\n");
			
			//This reads and stores contents
			while (inFile.hasNext()) {
			
			String type = inFile.next();
			String name = inFile.next();
			
			//Add each square based on the types
			switch(type) {
				case "PenaltySquare":
					squares.add(new PenaltySquare(name));
				break;
				case "PrizeSquare":
					squares.add(new PrizeSquare(name));
				break;
				case "LastSquare":
					squares.add(new LastSquare(name));
				break;
				case "Square":
					squares.add(new Square(name));
				break;
			}
			
			//This line would be used for testing
			//System.out.println("Created a " + type + " with the name " + name);
		}
			inFile.close();
	} 
		catch (FileNotFoundException e) {
			
			System.out.println("FILE ERROR!");
			//e.printStackTrace();
		}
		System.out.println();
}

	//2 methods get the starting and ending point
	public Square getStartSquare() {
		return squares.get(0);
	}
	
	public Square getLastSquare() {
		return squares.get(16);
	}
	
	//How squares are moved
	public Square moveSquare(Square s, int spun) {
		
		//this is our temp value, loop through the arraylist to find the square to find where the location is at.
		int temp = 0;
		while (squares.get(temp).getLabel() != s.getLabel()) {
				if (squares.get(temp).getLabel() == s.getLabel()){
					break;
				}
		temp++;
		}
		
		//this determines whether we move or not. Add the starting point
		int newspot = temp + spun;
		
		if (newspot > 16 || newspot < 0) //Basically, the spot has to be in the range to move
			return squares.get(temp);
		else
			return squares.get(newspot);
		}
}