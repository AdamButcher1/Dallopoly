
public class Square {
	private String label;
	
	//Constructor sets label using the method
	public Square(String la) {
		setLabel(la);
	}

	public void setLabel(String la) {
		label = la;
	}
	
	public String getLabel() {
		return label;
	}
	
	//Default value to change the money
	public void landOn(Player p) {
		p.changeMoney(0);
	}
	
	//returns Player’s name and current Square.
	public String toString() {
		return " is on " + getLabel() + " square";
	}
}
