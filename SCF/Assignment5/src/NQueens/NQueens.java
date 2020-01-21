package NQueens;
/**
 * 
 * @author Kunal
 * @desc This class implements the NQueens problem
 */
public class NQueens {
/**
 * @desc This function is to check whether a position in Borad is suitable for queen or not
 * @param board , int type array
 * @param row ,int type
 * @param column ,int type
 * @param totalRow ,int type
 * @return boolean variable ,i.e; if Position is safe to place a queen then return true else false
 */
    public boolean isSafe(int board[][], int row, int column, int totalRow) {

        // check in the column places above current position that whether there is a Queen or not
        for (int Row = 0; Row < row; Row++) {
            if (board[Row][column] == 1)
                return false;
        }
        
        // check for left diagonal Whether any queen is there or not
        int Row = row;
        int Column = column;
        while (Row >= 0 && Column >= 0) {
            if (board[Row][Column] == 1)
                return false;
            Row--;
            Column--;
        }
        
        // check whether there is any queen on right diagonal or not
        Row = row;
        Column = column;
        while (Row >= 0 && Column < totalRow) {
            if (board[Row][Column] == 1)
                return false;
            Row--;
            Column++;
        }
        
        // now we have checked that the position is safe for placing the queen 
        return true;
        
    }

    /**
     * @desc it checks whether N Queens can be placed on the board or not
     * @param board ,int type array
     * @param currentRow ,int type
     * @param totalRows , int type
     * @return boolean value i.e, if N queens can be placed on the board then true else false
     */
    public boolean solveNQueens(int board[][], int currentRow, int totalRows) {
        if(board.length == 0)
            return false;
        if (currentRow == totalRows) { // we have successfully placed the N
                                       // queens
            // print the NQueen Matrix
            for (int index1 = 0; index1 < totalRows; index1++) {
                for (int index2 = 0; index2 < totalRows; index2++) {
                    if (board[index1][index2] == 1)
                        System.out.printf(" Q ");
                    else
                        System.out.printf(" 0 ");
                }
                System.out.printf("\n");
            }
            return true;
        }
        // recursive approach
        for (int column = 0; column < totalRows; column++) {
            // check if (currentRow,column) position is safe to place the Queen in the currentRow or not
            if (isSafe(board, currentRow, column, totalRows)) {
              //place the queen
                board[currentRow][column] = 1;
                boolean checkCanWePlaceNextQueen = solveNQueens(board,
                        currentRow + 1, totalRows);
                if (checkCanWePlaceNextQueen)
                    return true;
            }
          // the (currentRow,column) is not the correct position for queen
            board[currentRow][column] = 0; // backtrack
        }
     // we have checked for all columns in currentRow and cannot place the queen        
        return false;
    }

}
