import java.util.Arrays;
import java.util.Scanner;

public class Darray {
    public static void main(String[] args) {

         int[][] first = {
            {1, 2 , 3},
            {4 , 5 ,6},
            {7 , 8 }
        };

        for (int i = 0; i < first.length; i++) {
           System.out.println();
            for (int j = 0; j < first[i].length; j++) {
                 System.out.print(first[i][j] +  " ");
            }
        }
        System.out.println();
        System.out.println(Arrays.deepToString(first));
        System.out.println("___________________________");

        // lets take input on run time in 2D arrays .. 
        Scanner in = new Scanner(System.in);
        int[][] twoDarray = new int[3][3];

        
        for (int i = 0; i < twoDarray.length; i++) {
            System.out.println("Enter entries for " + i + " row .");
            for (int j = 0; j < twoDarray[i].length; j++) {
                twoDarray[i][j] =  in.nextInt();
            }
        }
        for (int i = 0; i < twoDarray.length; i++) {
            System.out.println();
            for (int j = 0; j < twoDarray[i].length; j++) {
                System.out.print(twoDarray[i][j] + " ");
            }
        }
        System.out.println();

        in.close();

    }
}
