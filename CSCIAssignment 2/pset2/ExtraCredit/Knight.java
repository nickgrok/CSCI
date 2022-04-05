//  Knight.java
//
//  Created by Henry Leitner on January 2, 2018
//

class Knight extends Piece
{
    boolean attackingThisLocation (int indexRow, int indexColumn)
    {
      int columnDiff = pieceColumn - indexColumn;
      int rowDiff = pieceRow - indexRow;

      if ((columnDiff * columnDiff + rowDiff * rowDiff == 5) ||
          ( (columnDiff == 0) && (rowDiff == 0))) return true;
      else return false;

    }
}
