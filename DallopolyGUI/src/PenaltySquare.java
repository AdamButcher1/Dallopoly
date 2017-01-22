
class PenaltySquare extends Square {

	public PenaltySquare(String la) {
		super(la);
	}
	
	//Subtract $200 for landing on this square
	public void landOn(Player p) {
		p.changeMoney(-200);
	}

}
