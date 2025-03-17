import java.util.Scanner;

public class reverseNumber {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a number to get the reverse ...");
        int number = in.nextInt();
        int reverse = 0 ; 
        // given number : 1234 //
         // so the logic is to take the modulo with 10 of  number to get the last digit 
        while (number >= 1) {

            int digit = number % 10 ; 
             reverse = reverse * 10 + digit ; 
             number = number / 10 ; // to remove the last digit from the number 

        }
        System.out.println(reverse);
        in.close();
    }
}
