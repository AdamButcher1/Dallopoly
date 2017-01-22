
class PrizeSquare extends Square {

	public PrizeSquare(String la) {
		super(la);
	}
	
	//Add $100 for landing on this square
	public void landOn(Player p) {
		p.changeMoney(100);
	}

}
