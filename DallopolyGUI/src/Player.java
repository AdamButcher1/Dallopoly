public class Player {
	//2 variables for the square and name
	private Square currentSquare;
	private String name;
	
	//Additional variable for money
	private int money;
	
	//Constructor using 2 methods and to set starting money.
	public Player(String n, Square s) {
		setName(n);
		setCurrentSquare(s);
		setMoney(1000);
	}
	
	//2 methods for getting and setting name
	public String getName() {
		return name;
	}
	
	public void setName(String n) {
		name = n;
	}
	
	//These 3 methods are added to the program to modify money
	public int getMoney() {
		return money;
	}
	
	public void setMoney(int m) {
		money = m;
	}
	
	public void changeMoney(int m) {
		money += m;
	}
	
	//2 methods for getting and setting the current square
	public Square getCurrentSquare() {
		return currentSquare;
	}
	
	public void setCurrentSquare(Square s) {
		currentSquare = new Square(s.getLabel());
	}
	
	//How a person takes a turn
	public String takeTurn(Spinner sn, Board b) {
		//Extra variable since we aren't supposed to add/deduct if the player doesn't move and is on a special square
		Square previousSquare = currentSquare;
		int spinnedValue = sn.spin();
		currentSquare = b.moveSquare(currentSquare, spinnedValue);
		//Check the condition for the previous square
		if (!previousSquare.equals(currentSquare))
			currentSquare.landOn(this);
		return (getName() + " spun " + spinnedValue + " " + getName() + " has $" + getMoney() + getCurrentSquare());
	}
	
	public String toString() {
		return currentSquare.getLabel() + " Square";
	}
}
