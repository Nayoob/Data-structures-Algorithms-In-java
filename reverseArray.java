import java.util.Scanner;

public class reverseArray {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int[] arr = new int[5];
        
        System.out.println("Enter the entries of the array .. ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println("The reverse of the array is");
        for (int i = arr.length - 1 ; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }


        int[] arr2 = { 4 , 5, 6 , 7 , 8, 9, 10 };
        System.out.println("The reverse of the array is");
        for (int i = arr2.length - 1 ; i >= 0; i--) {
            System.out.print(arr2[i] + " ");
        }
        

        in.close();
    }
}
