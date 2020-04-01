import java.util.Random;

public class C4RandomAIPlayer extends ConnectPlayer{

	private char symbol = 'Y';
	
	public char getSymbol() {
		
		return symbol;
		
	}
	public int getMove() {
		int returnNumber = 0;
		Random generator = new Random();
		returnNumber = generator.nextInt(6)+1;
		//returnNumber+=returnNumber;
		
		return returnNumber;
	}
}
