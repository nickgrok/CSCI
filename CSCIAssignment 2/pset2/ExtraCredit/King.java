// Extra Credit

//  @author Nicholas Grokhowsky on March 1, 2018
//
// Class that creates the King Chess Piece and extends to Piece

class King extends Piece
{
	// Boolean method that determines where the King piece an attack
    
    boolean attackingThisLocation (int indexRow, int indexColumn)
    {
    	// Two variables determine the difference of the piece location from the index location 
    	// one for column and one for row	
      	
      	int columnDiff = pieceColumn - indexColumn;
      	int rowDiff = pieceRow - indexRow;

    	// Boolean logic to determine the kings potential moves
    	// Each potential move is the absolute value of either a (1,1) move, a (1,0) move, or a (0,1) move
    	// If not one of the moves listed above the boolean should return false

	    if ((Math.abs(columnDiff) == 1) && (Math.abs(rowDiff) == 1)) return true;
	    else if ((Math.abs(columnDiff) == 1) && (rowDiff == 0)) return true;
	    else if ((Math.abs(rowDiff) == 1) && (columnDiff == 0)) return true;
	    else return false;	

    }
}
