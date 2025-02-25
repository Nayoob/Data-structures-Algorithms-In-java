import java.util.Arrays;

public class BinarysearchInTwoDarray {

    // staire case appraoach this one is used when the matrix is row wise and column wise sorted 
    // this appraoch is for sorted 2d matrix ;
    public static int[] BinarysearchIntwoDArray(int[][] matrix , int target){
       
        int row = 0 ;
        int column = matrix.length  ;

        while (row < matrix.length && column >= 0) {
            if (matrix[row][column] == target) {
                System.out.println("target found");
                return new int[]{row , column};
            }
            if (matrix[row][column] > target) {
                column--;
            }
            else{
                row++;
            }
        }
        return new int[]{-1 ,-1};
    }

    public static int[] Binarysearch(int[][] matrix , int row , int cstart , int cend , int target){
       while(cstart <= cend){
          int mid = cstart + (cend - cstart) / 2;
          if (matrix[row][mid] == target) {
            System.out.println("target found");
            return new int[]{row , mid};
          }
          if (target > matrix[row][mid]) {
             cstart = mid + 1;
          }
          else{
              cend = mid - 1;
          }
       }
       return new int[]{-1 , -1};
    }

    // Implementation of binary search 
    // reduce the search space 
    public static int[] Search(int[][] matrix , int target){
       int rows = matrix.length ;
       int cols = matrix[0].length;
       if (cols == 0 || rows == 0) {
         System.out.println("matrix is empty");
         return new int[]{-1 , -1};
       }
       if (rows == 1) {
          return Binarysearch(matrix , 0 , 0 , cols-1 , target);
       }

       int rstart = 0 ;
       int rend = rows - 1 ;
       int cMid = cols / 2;
       
       while (rstart < (rend -1)) {
          int mid = rstart + (rend - rstart) / 2 ;
          if (matrix[mid][cMid] == target) {
            return new int[]{mid , cMid};
          }
          if (target > matrix[mid][cMid]) {
            rstart = mid;
          }
          else{
            rend = mid ;
          }
       }
       // at this point we are out of loop with two rows remaining
       // here we have to check whether our target exist in the mid column 
       if (matrix[rstart][cMid] == target) {
          return new int[]{rstart , cMid};
       }
       if (matrix[rstart + 1][cMid] == target) {
          return new int[]{rstart + 1 , cMid};
       }
       // if our target doesnt lie in middle column 

       // divide the rest of the elements in 4 halfs
       
       if ( target < matrix[rstart][cMid]) {
         return Binarysearch(matrix, rstart, 0 , cMid-1 , target);
       }
       if (target >= matrix[rstart][cMid + 1] && target <= matrix[rstart][cols -1]) {
         return Binarysearch(matrix, rstart, cMid + 1 , cols -1, target);
       }

       if (target < matrix[rstart + 1][cMid]) {
         return Binarysearch(matrix, rstart + 1 , 0, cMid -1, target);
       }
       else{
         return  Binarysearch(matrix, rstart + 1, cMid + 1 , cols -1 , target);
       }
         
    }
    public static void main(String[] args) {
        int[][] matrix = {
            {1 , 2 , 3 , 4 ,  5 } ,
            {6 , 7 , 8 , 9 ,  10} ,
            {11, 12, 13 , 14, 15} ,
            {16 ,17, 18 , 19 , 20}
        };

        System.out.println(Arrays.toString(BinarysearchIntwoDArray(matrix, 17)) );
        System.out.println(Arrays.toString(BinarysearchIntwoDArray(matrix, 6)) );
        System.out.println(Arrays.toString(BinarysearchIntwoDArray(matrix, 1)) );
        // int row = 0 ; 
        // int column = matrix.length -1 ;
        // System.out.println(matrix.length - 1);
        // System.out.println(matrix[row]);
        // System.out.println(matrix[column]);
        // System.out.println(matrix[row][column]);
    }
    
}
