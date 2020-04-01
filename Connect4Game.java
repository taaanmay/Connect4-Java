import java.util.Scanner;

public class Connect4Game {

	public static void main(String[] args) {
		boolean end=false;
		boolean gameEnd = false;

		while (gameEnd ==false) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Do you want to play Connect 4? ('yes' or'no')");
			String response = scanner.next();
			if(response.equalsIgnoreCase("No")) {
				end = true;
				gameEnd = true;
			}else {
				
				C4HumanPlayer human = new C4HumanPlayer();
				C4RandomAIPlayer comp = new C4RandomAIPlayer();
				Connect4Grid2DArray c = new Connect4Grid2DArray();
				c.emptyGrid();
				System.out.println("Your symbol: "+human.getSymbol()+"  Computer Symbol: "+comp.getSymbol());
				c.setSymbols(human, comp);
				System.out.println(c.toString());
				end = false;
				while(end==false) {
					
					if(c.isGridFull()) {end=true;}
					int move = human.getMove();
					if(move==-1) {end = true; gameEnd = true;}
					if(end==false) {
						c.dropPiece(human, move);
					}
					if(c.didLastPieceConnect4()) {
						end = true;
						System.out.println(c.toString());
					}
					if(end==false) {
						int compMove = comp.getMove();
						if(c.isColumnFull(compMove)) {
							compMove = comp.getMove();
						}

						c.dropPiece(comp, compMove);
						if(c.didLastPieceConnect4()) end = true;
						System.out.println(c.toString());	
					}
				}
			}
		}
		System.out.println("GOODBYE");
	}

}
/* SELF ASSESSMENT

Connect4Game class (35 marks)
My class creates references to the Connect 4 Grid and two Connect 4 Players. It asks the user whether he/she would like to play/quit inside a loop. If the user decides to play then: 1. Connect4Grid2DArray is created using the Connect4Grid interface, 2. the two players are initialised - must specify the type to be ConnectPlayer, and 3. the game starts. In the game, I ask the user where he/she would like to drop the piece. I perform checks by calling methods in the Connect4Grid interface. Finally a check is performed to determine a win. 
Comment:Yes , the programn does all the functions as described above.

Connect4Grid interface (10 marks)
I define all 7 methods within this interface.
Comment:Yes all 7 methods are defined.

Connect4Grid2DArray class (25 marks) 
My class implements the Connect4Grid interface. It creates a grid using a 2D array Implementation of the method to check whether the column to drop the piece is valid. It provides as implementation of the method to check whether the column to drop the piece is full. It provides as implementation of the method to drop the piece.  It provides as implementation of the method to check whether there is a win.
Comment: Yes, this class is iplemented using the Connect4Grid interface.It also has all the methods implemented for the checks.

ConnectPlayer abstract class (10 marks)
My class provides at lest one non-abstract method and at least one abstract method. 
Comment:Yes my class provides one abstract and one non abstract method.

C4HumanPlayer class (10 marks)
My class extends the ConnectPlayer claas and overrides the abstract method(s). It provides the Human player functionality.
Comment:Yes, it extends the class and overrides the abstract methods.

C4RandomAIPlayer class (10 marks)
My class extends the ConnectPlayer claas and overrides the abstract method(s). It provides AI player functionality. 
Comment:Yes, this class also extends the class and overrides methods and provides AI player functionality.

Total Marks out of 100:100

 */