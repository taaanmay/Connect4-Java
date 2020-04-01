public class Connect4Grid2DArray  implements Connect4Grid  {
	private final int NO_OF_ROWS = 6;
	private final int NO_OF_COLUMNS = 7;
	private char[][] board = new char[NO_OF_ROWS][NO_OF_COLUMNS];
	private char humanSymbol = 'R';
	private char compSymbol = 'Y';

	public void emptyGrid() {
		for(int i =0; i<NO_OF_ROWS ; i++) {
			for(int j = 0; j<NO_OF_COLUMNS ; j++) {
				board[i][j]= '0';
			}
		}
	}

	public String toString() {

		String returnValue = "  1 2 3 4 5 6 7\n";
		for(int i =0; i<NO_OF_ROWS ; i++) {
			returnValue+=i+1;
			for(int j = 0; j<NO_OF_COLUMNS ; j++) {
				returnValue+=" "+board[i][j];

			}
			returnValue+="\n";
		}
		return returnValue;	
	}
	public boolean isValidColumn(int column) {
		if(column<=NO_OF_COLUMNS-1 && column>=0) {
			return true;
		}return false;
	}
	public boolean isColumnFull(int column) {
		if(board[0][column]!='0') {

			return true;
		}	

		return false;
	}
	public void dropPiece(ConnectPlayer player, int column) {
		if(column!=-1) {
			if(isValidColumn(column-1)==true) {
				if(isColumnFull(column-1)==false) {
					boolean placeEmpty = false;
					int row = NO_OF_ROWS;
					while(placeEmpty==false) {

						if(row>0)row--;
						if(board[row][column-1]=='0') {
							board[row][column-1]=player.getSymbol();
							placeEmpty = true;

							break;
							//
						}
					}
				}else System.out.println("This column is full.");
			}else if(isValidColumn(column-1)==false) System.out.println("Enter a valid column number (from 1-7).");
		}
	}
	public boolean didLastPieceConnect4() {
		//HORIZONTAL
		
			for(int i=0; i<NO_OF_ROWS;i++){
				for(int j=0; j<NO_OF_COLUMNS;j++) {
					//	int points = 0;
					if(j<=3&&board[i][j]!='0' && board[i][j]==board[i][j+1] && board[i][j]==board[i][j+2] 
							&& board[i][j]==board[i][j+3]) {
						if(board[i][j]==humanSymbol) {
							System.out.println("CONGRATULATIONS.YOU WON");
							return true;
						}else if(board[i][j]==compSymbol) {
							System.out.println("SORRY YOU LOST. COMPUTER WON.");
							return true;
						}	
					}
				}
			}
			//VERTICAL

			for(int i=0; i<NO_OF_ROWS;i++){
				for(int j=0; j<NO_OF_COLUMNS;j++) {
					if(i<3&&board[i][j]!='0' && board[i][j]==board[i+1][j] && board[i][j]==board[i+2][j] 
							&& board[i][j]==board[i+3][j]) {
						if(board[i][j]==humanSymbol) {
							System.out.println("CONGRATULATIONS.YOU WON");
							return true;
						}else if(board[i][j]==compSymbol) {
							System.out.println("SORRY YOU LOST. COMPUTER WON.");
							return true;
						}
					}
				}
			}
			//DIAGONAL

			for(int i=0; i<NO_OF_ROWS;i++){
				for(int j=0; j<NO_OF_COLUMNS;j++) {
					if(i<=2&&j<=3) {
						if(board[i][j]!='0' && board[i][j]==board[i+1][j+1] && board[i][j]==board[i+2][j+2] 
								&& board[i][j]==board[i+3][j+3]) {
							if(board[i][j]==humanSymbol) {
								System.out.println("CONGRATULATIONS.YOU WON");
								return true;
							}else if(board[i][j]==compSymbol) {
								System.out.println("SORRY YOU LOST. COMPUTER WON.");
								return true;
							}
						}
					} else if(i<=2&&j>=3) {
						if(board[i][j]!='0' && board[i][j]==board[i+1][j-1] && board[i][j]==board[i+2][j-2] 
								&& board[i][j]==board[i+3][j-3]) {
							if(board[i][j]==humanSymbol) {
								System.out.println("CONGRATULATIONS.YOU WON.");
								return true;
							}else if(board[i][j]==compSymbol) {
								System.out.println("SORRY YOU LOST. COMPUTER WON.");
								return true;
							}
						}
					}
				}
			}
		
		return false;
	}
	public boolean isGridFull() {

		for(int i=0; i<NO_OF_COLUMNS;i++) {
			
			if(board[0][i]=='0') {
				return false;
			}
		}
		return true;
	}
	public void setSymbols(ConnectPlayer player1, ConnectPlayer player2) {
		humanSymbol = player1.getSymbol();
		compSymbol = player2.getSymbol();
	}
}
