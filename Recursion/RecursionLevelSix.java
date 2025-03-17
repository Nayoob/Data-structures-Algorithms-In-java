import java.util.ArrayList;
import java.util.Arrays;

public class RecursionLevelSix {
    /* count the number of ways to reach from point a to point b in maze problem  */
    public static int Countways(int row , int col){
         if (row == 1 || col == 1) {
            return 1 ;
         }
         int left = Countways( row - 1, col);
         int right = Countways(row, col - 1);

         return left + right ;
    }
    /* Print the ways to reach from point a to point b  */
    public static void printRouts(String processed , int row , int col){
        if (row == 1 && col == 1) {
            System.out.print(processed + " ");
        }

        if (row > 1 ) {
            printRouts( processed + 'D', row - 1, col);
        }
        if (col > 1) {
            printRouts(processed + "R", row, col - 1);
        }
    }
    /* return Array list containing all the paths from point A to point B  */

    public static ArrayList<String> returnPathwithList(String processed , int row , int column){
        if (row == 1 && column == 1) {
            ArrayList<String> list = new ArrayList<>() ;
            list.add(processed);
            return list;
        }
        ArrayList<String> ansList = new ArrayList<>();

        if (row > 1 ) {
            ansList.addAll(returnPathwithList(processed + 'D' , row - 1 , column));
        }
        if (column > 1) {
            ansList.addAll(returnPathwithList(processed + 'R' , row , column - 1 ));
        }

        return ansList ;
    }
    /* rate in the maze problem but this time we have one obstacle which rat cant cross 
     * now we have to return all those paths that a rat can go without counting obstacle 
     */
    public static ArrayList<String> RatInMaze(String processed , boolean[][] maze , int row , int col){
       if ( row == maze.length - 1 && col == maze[0].length - 1   ) {
          ArrayList<String> list = new ArrayList<>();
          list.add(processed);
          return list;
       }

       ArrayList<String> ansList = new ArrayList<>();

       if (maze[row][col] == false) 
       return new ArrayList<>();
    
       if (row < maze.length - 1) {
        ansList.addAll(RatInMaze(processed + 'D' , maze , row + 1 , col)) ;
       }

       if (col < maze[0].length - 1) {
        ansList.addAll(RatInMaze(processed + 'R' , maze , row , col + 1)) ;
       }
       return ansList;
    }

    /* Moving in all four direction to reach the target lets see what will happen 
     * so now lets say if we are moving in all four direction we need to change the code too 
     */
    public static void AllFourDirection(String processed , boolean[][] maze , int row , int column){
        if ( row == maze.length - 1 && column == maze[0].length -1  ) {
            System.out.println(processed);
            return ;
        }
        if ( row  < maze.length - 1) {
            AllFourDirection(processed + 'D' , maze ,  row + 1 , column);
        }
        if ( column < maze[0].length - 1) {
            AllFourDirection(processed + 'R' , maze ,  row , column + 1);
        }
        if (row > 0) {
            AllFourDirection(processed + 'U', maze, row - 1, column);
        }
        if (column > 0) {
            AllFourDirection( processed + 'L', maze, row, column - 1);
        }
        /* the above code at this stage it is infinite recursion causing stack over flow because it is visiting 
         * single index of maze many times . 
         */
    }
    /* lets check if i only move in 3 directions what will happen then that is left rigth down and no up 
     * i think the this will prevent the infinite recursion lets see ! 
     */
    public static void ThreeDirection(String processed , boolean[][] maze , int row , int column){
        if ( row == maze.length - 1 && column == maze[0].length -1  ) {
            System.out.println(processed);
            return ;
        }
        if ( row  < maze.length - 1) {
            ThreeDirection(processed + 'D' , maze ,  row + 1 , column);
        }
        if ( column < maze[0].length - 1) {
            ThreeDirection(processed + 'R' , maze ,  row , column + 1);
        }
        if (column > 0) {
            ThreeDirection( processed + 'L', maze, row, column - 1);
        }
        /* 
        ( nope it is still throwing stack overflow )
         */
    }
    /* lets try to do this using backtracking  */

    
    public static void AllFourDirectionUsingBacktracking(String processed , boolean[][] maze , int row , int column){
        if ( row == maze.length - 1 && column == maze[0].length -1  ) {
            System.out.println(processed);
            return ;
        }
        if (maze[row][column] == false) {
            return ;
        }
        maze[row][column] = false ;
        if ( row  < maze.length - 1) {
            AllFourDirectionUsingBacktracking(processed + 'D' , maze ,  row + 1 , column);
        }
        if ( column < maze[0].length - 1) {
            AllFourDirectionUsingBacktracking(processed + 'R' , maze ,  row , column + 1);
        }
        if (row > 0) {
            AllFourDirectionUsingBacktracking(processed + 'U', maze, row - 1, column);
        }
        if (column > 0) {
            AllFourDirectionUsingBacktracking( processed + 'L', maze, row, column - 1);
        }

        maze[row][column] = true;

    }
    /* lets print the path  */

    public static void pathPrint(String processed , boolean[][] maze , int row , int column , int[][] path , int step){

        if ( row == maze.length - 1 && column == maze[0].length -1  ) {
            path[row][column] = step;
            for (int[] arr : path) {
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(processed);
            System.out.println();
            return ;
        }
        if (maze[row][column] == false) {
            return ;
        }
        maze[row][column] = false ;
        path[row][column] = step;
        if ( row  < maze.length - 1) {
            pathPrint(processed + 'D' , maze ,  row + 1 , column , path , step + 1);
        }
        if ( column < maze[0].length - 1) {
            pathPrint(processed + 'R' , maze ,  row , column + 1 , path , step + 1);
        }
        if (row > 0) {
            pathPrint(processed + 'U', maze, row - 1, column , path , step + 1);
        }
        if (column > 0) {
            pathPrint( processed + 'L', maze, row, column - 1, path , step + 1);
        }

        maze[row][column] = true;
        path[row][column] = 0;

    }
    public static void main(String[] args) {
        System.out.println(RecursionLevelSix.Countways(3, 3));
        RecursionLevelSix.printRouts("", 3, 3);
        System.out.println();
        System.out.println(RecursionLevelSix.returnPathwithList("", 3, 3));
        boolean[][] maze = {
            {true , true , true},
            {true , true , true},
            {true , true , true},
        };
        System.out.println(RecursionLevelSix.RatInMaze("", maze, 0, 0));
        System.out.println("_________________________");
        // RecursionLevelSix.AllFourDirection("", maze, 0, 0);
        // System.out.println();
        // System.out.println("_________________________");
        // RecursionLevelSix.ThreeDirection("", maze, 0, 0);
       // RecursionLevelSix.AllFourDirectionUsingBacktracking("", maze, 0, 0);
        int[][] path = new int[maze.length][maze[0].length];
        RecursionLevelSix.pathPrint("", maze, 0, 0, path, 1);
    }
}
