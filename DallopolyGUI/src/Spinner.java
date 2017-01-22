import java.util.Random;


public class Spinner {
	
		//Default constructor
		Spinner(){
			
		}
	public static int spin(){
		

		
		//2 objects for the board and spinning
		Random rand = new Random();
		int [] WheelValues = new int[8];
		
		//Declare variables
		WheelValues[0] = -1;
		WheelValues[1] = -2;
		WheelValues[2] = -3;
		WheelValues[3] = 1;
		WheelValues[4] = 2;
		WheelValues[5] = 3;
		WheelValues[6] = 4;
		WheelValues[7] = 5;
		
		//How the value is spun
		int SpunValue = WheelValues[rand.nextInt(8)];
		return SpunValue;
	}
	
}
