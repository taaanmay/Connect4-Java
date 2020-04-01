import java.util.Scanner;

public class C4HumanPlayer extends ConnectPlayer{
	private char symbol = 'R';
	
	public char getSymbol() {
		
		return symbol;
	}
	public int getMove() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the column number where you want to drop your piece. (or type quit)");
		if(input.hasNext("quit") || input.hasNext("Quit")) {return -1;}
		int returnColumnNumber = input.nextInt();
		if(returnColumnNumber<0 || returnColumnNumber>7) {
			System.out.println("Invalid entry. Input again.");
			returnColumnNumber = input.nextInt();
		}
		//input.close();
		
		return returnColumnNumber;
	}

}
