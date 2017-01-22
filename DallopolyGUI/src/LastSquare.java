
class LastSquare extends Square {

	public LastSquare(String la) {
		super(la);
	}
	
	//Add $300 for landing on this square
	public void landOn(Player p) {
		p.changeMoney(300);
	}

}
