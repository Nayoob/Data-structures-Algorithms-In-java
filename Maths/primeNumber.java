import java.util.Scanner;

public class primeNumber {

    public static boolean checkPrime(int number){
        
        if(number <= 1){
            return false ;
        }
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false; // Number is divisible by i, so it's not prime
            }
        }  
         return true ;
        }
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
    
            System.out.println("Enter a Random Number to check if its prime or not .. ");
            int number = in.nextInt();
    
            boolean isPrime = checkPrime(number);
            System.out.println(isPrime);
            in.close();
    }
}
