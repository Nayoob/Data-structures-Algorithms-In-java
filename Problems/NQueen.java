

public class NQueen {
    /* leet code 51 lets try to solve this one  */
    public static void PrintMatrix(char[][] martix ){
        for (char[] row : martix) {
            for (char col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static boolean isIndexFree(char[][] matrix , int row , int column , int n){
      /* so with this loop i am checking if there is any Q exist in the column */ 
      for (int i = 0; i < row; i++) {
        if (matrix[i][column] == 'Q') {
            return false;
        }
      }
      /* checking right diagonal if there is any Q in the right diagonal  */
      for (int i = row , j = column ; i >= 0 && j < n ; i-- , j++) {
         if (matrix[i][j] == 'Q') {
            return false;
         }
      }
      /* checking left diagonal  */
      for (int i = row , j = column ; i >= 0 && j >= 0 ; i-- , j--) {
        if (matrix[i][j] == 'Q') {
            return false;
        }
      }
      return true ;
    }
    public static boolean solveNQueen(char[][] matrix , int row  , int n){
        if (row == n) {
            PrintMatrix(matrix);
            return true ;
        }
        boolean findsolution = false ;

        for (int col = 0; col < n; col++) {

            if (isIndexFree(matrix , row , col , n)) {
                matrix[row][col] = 'Q';
                findsolution =  solveNQueen(matrix, row + 1, n) || findsolution ;
                matrix[row][col] = '.';
            }
        }
        return findsolution;

    }
    public static void main(String[] args) {

        char[][] matrix = new char[4][4];

        for (int i = 0 ; i < 4; i++) {
            for (int j = 0; j < 4 ; j++) {
                matrix[i][j] = '.';
            }
        }
        if (!solveNQueen(matrix, 0, 4)) {
            System.out.println("No solution exists.");
        }

      //  System.out.println(Arrays.deepToString(matrix));
    }
}
