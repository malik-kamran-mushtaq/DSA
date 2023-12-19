// Return true of false if there is a way in which we can place "n" Queens in an "nxn" chess board. Also print one way
package BackTracking;

public class N_Queens {
    public static boolean isSafe(char board[][], int row, int col) {
        // vertically up
        for(int i=row-1; i>=0; i--) {
            if(board[i][col] == 'Q') {
                return false;
            }
        }
        // diagonally left
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }
        //diagonally right
        for(int i=row-1, j=col+1; i>=0 && j<board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
    public static boolean nQueens (char board[][], int row) {
        //Base Case
        if(row == board.length) {
//            printBoard(board);
            count++;
            return true;
        }

        // Column loop
        for (int j = 0; j < board.length; j++) {

            if(isSafe(board, row, j)){
                board[row][j] = 'Q';
                if (nQueens(board, row + 1)) {
                    return true;
                }
                board[row][j] = 'X';
            }
        }
        return false;
    }

    public static void printBoard(char board[][]) {
        System.out.println("-----------QUEENS-------------");
        for (int i=0; i<board.length; i++) {
            for(int j=0; j< board.length; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    static int count = 0;
    public static void main(String[] args) {
        int n = 4;
        char board[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = 'X';
            }
        }
        if (nQueens(board, 0)) {
            System.out.println("Solution is possible");
            printBoard(board);
        }
        else {
            System.out.println("Solution is not possible.");
        }
        System.out.println("Total number of ways to place nQueens: "+count);
    }
}
