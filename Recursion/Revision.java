import java.lang.reflect.Array;
import java.util.ArrayList;

public class Revision {
    /* rate in the maze problem complete debug and dry run
     * DDDRRR DDRDRR DDRRDR DDRRRD DRDDRR DRDRDR DRDRRD DRRDDR DRRDRD DRRRDD RDDDRR RDDRDR RDDRRD 
     * RDRDDR RDRDRD RDRRDD RRDDDR RRDDRD RRDRDD RRRDDD  so these are all the ways a rate can reach point B in matrix 
     */

    public static void RateInMaze(String processed , int row , int col  , int  n){
       if (row == n - 1 && col == n - 1) {
         System.out.print(processed + " ");
         return ;
       }
       if (row < n) {
        RateInMaze(processed + 'D' , row + 1 , col , n);
       }
       if (col < n) {
        RateInMaze(processed + 'R' , row  , col + 1 , n);
       }
       return ;
    }

    /* lets try to print the answer in List */
    public static ArrayList<String> PrintInList(ArrayList<String>  list , String processed , int row , int col , int n  ){
         if (row == n - 1 && col == n - 1 ) {
            list.add(processed);
            return list;
         }
         if (row < n ) {
            PrintInList(list, processed + 'D', row + 1 , col, n);
         }
         if (col < n) {
            PrintInList(list, processed + 'R', row, col + 1 , n);
         }
         return list;
    }
    /* count the numbe of ways  */

    public static int countNumberOfWays( int row , int col , int n  ){
        if (row == n - 1 && col == n - 1 ) {
           return 1 ;
        }
        int left = 0 ;
        int right = 0;

        if (row < n ) 
           left =  countNumberOfWays( row + 1 , col, n );
        
        if (col < n) 
           right = countNumberOfWays( row, col + 1 , n );
        
       return left + right;
   }

   public static void mazewithHinderance(boolean[][] board ,String processed , int row , int col , int n){
     if (row == n - 1 && col == n - 1) {
        System.out.println(processed);
        return ;
     }
     if (row >= n || col >= n) {
        return ;
     }
     if (board[row][col] == false ) {
        return ;
     }
     if (row < n ) {
        mazewithHinderance(board, processed.concat("D"), row + 1 , col, n);
     }
     if (col < n) {
        mazewithHinderance(board, processed.concat("R"), row, col + 1, n);
     }
   }

   public static ArrayList<String> MazeHinderanceOne(ArrayList<String> list , boolean[][] matrix , String processed , int row , int col , int n){
      if (row >= n || col >= n) 
        return list ;

      if(!matrix[row][col])
        return list;

      if (row == n - 1 && col == n - 1) {
        list.add(processed);
        return list ;
      }
      MazeHinderanceOne(list , matrix, processed.concat("D"), row + 1 , col, n);
      MazeHinderanceOne(list , matrix, processed.concat("R"), row, col + 1, n);
      return list;
   }

   /* lets try to solve the rat inthe maze with obstacel with another apprach  */
   public static ArrayList<String> RateInMazeobstacle(boolean[][] matrix , String processed , int row , int col , int n ){

      if (row >= n || col >= n || matrix[row][col] == false ) {
        return new ArrayList<>();
      }
      if (row == n - 1 && col == n - 1) {
        ArrayList<String> list = new ArrayList<>();
        list.add(processed);
        return list ;
      }
      ArrayList<String> ansList = new ArrayList<>();

      ansList.addAll(RateInMazeobstacle(matrix, processed.concat("D"), row + 1, col, n));
      ansList.addAll(RateInMazeobstacle(matrix, processed.concat("R"), row, col + 1, n))  ;

      return ansList;

   }

   /* so basically i am Cheking how to count the number of ways in which mosue can move from point a to b */
    public static  int CountwaysOne(String processed , int row , int col , int n , int count ){

        if(row == n - 1 && col == n - 1 ){
            System.out.println(processed);
            count++;
            return count ;
        }
  
        if (row < n) {
           count =  CountwaysOne(processed.concat("D"), row + 1, col, n , count);
        }
        if (col < n) {
           count = CountwaysOne(processed.concat("R"), row, col + 1, n , count) ;
        }
        return count;
    }

    /* moving in all four directions and using back tracking to see all the possible way to reach B from A */
       public static void backTracking(boolean[][] maze , String processed , int row , int column){
        if (row == maze.length - 1 && column == maze[0].length - 1) {
            System.out.println(processed);
            return ;
        }
        if (maze[row][column] == false) 
            return ;

        maze[row][column] = false;

        if (row < maze.length - 1) {
            backTracking(maze, processed.concat("D"), row + 1, column);
        }

        if (column < maze[0].length - 1) {
            backTracking(maze, processed.concat("R"), row, column + 1);
        }
        if (row > 0) {
            backTracking(maze, processed.concat("U"), row - 1 , column);
        }  
        if (column > 0) {
            backTracking(maze, processed.concat("L"), row, column - 1);
        } 
        maze[row][column] = true;
       }
    public static void main(String[] args) {
        // Revision.RateInMaze("", 0, 0, 4);
        // System.out.println();

        // ArrayList<String> list = new ArrayList<>();
        // System.out.println(Revision.PrintInList( list , "", 0, 0, 3));
        // System.out.println(Revision.countNumberOfWays(0,0,3));
        // ArrayList<String> listone = new ArrayList<>();
        // boolean[][] board = {
        //     {true , true , true},
        //     {true , false , true},
        //     {true , true , true}
        // };
        // System.out.println(Revision.MazeHinderanceOne(listone , board, "", 0, 0, 3));
        // int count = 0 ;
        // System.out.println(Revision.CountwaysOne("", 0,0, 3, count));
        boolean[][] maze = {
            {true , true , true},
            {true , true , true},
            {true , true , true}
        };

        Revision.backTracking(maze, "", 0, 0);
    }
}
