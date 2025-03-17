import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoreMaths {
    /* check if number is prime or not  */
    public static boolean checkIfPrime(int num){
        if (num < 2) {
            return false; 
        }
        boolean isPrime = true;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime ;
    }
    /* so next one your given  a number and asked to give me all the numbers below or equal to this 
     * which are prime 
     */
    public static int prime(int num){
        List<Integer> primes = new ArrayList<>();
        for (int i = 1; i < num; i++) {
            if (checkIfPrime(i)) {
               primes.add(i);
            }
        }
        return primes.size();
    }
    // this function will give me all the prime numbers below that given number 
    public static List<Integer> prime2(int num){
        List<Integer> primes = new ArrayList<>();
        for (int i = 1; i < num; i++) {
            if (checkIfPrime(i)) {
               primes.add(i);
            }
        }
        
        return primes;
    }  


    // Sieve of Eratosthenes!  method fast as hell 
    // we are going to display all the numbers that are prime upto 10 perfect lets try !

    public static int Eratosthenes(int num){

        boolean[] prime = new boolean[num];
        Arrays.fill(prime, true);  
        prime[0] = false ;
        prime[1] = false ; 
       
        for (int i = 2; i * i < num ; i++) {
          
             if (prime[i]) {
                for (int j = i*i ; j < num ; j = j + i) {
                    prime[j] = false; 
                }
             }
        }
        int counter = 0;
        for (int i = 0; i < prime.length; i++) {
            if (prime[i] == true) {
               counter++;
            }
        }
        return counter;

    }

    /* write a code to find the square root of a number  */

    /* Approach :
     * step 1 check the cross multiple of each number upto given number check is any of these match the target
     * step 2 if the cross multpitl matches the target return the index 
     * step 3 give values after points too incase if a number doesnt have any perfect square 
     * ==> to reduce my search space i am gonna apply binary search on that 
     * lets goooooo !!!! i just figured all the stuff out .
     */
    public static double findSqrt(int num , int pre){
        int start = 0 ; 
        int end = num ;
        double root = 0.0;
        while (start <= end) {
            int mid = start + (end - start) / 2 ;
            if (mid * mid == num) {
                return mid ;
            }
            if (mid * mid > num) {
                end = mid - 1 ;
            }
            else{
                start = mid + 1 ;
                root = mid ;  
            }
        }
        double inc = 0.1;

        for (int i = 0; i < pre; i++) {
            while (root * root <= num) {
                root = root + inc;
            }
            root = root - inc;
            inc /= 10;
        }

        return root ;
    }
 
     

    /* factors of a Number
     * if a number is given and your are asked to find the factors fo these number 
     * what is the approach 
     * lets find out ! 
     */
    public static void Findfactor(int num){

       for (int i = 1; i<= num; i++) {
          if (num % i == 0) {
            System.out.print(i + " ");
            
          }
       }
       System.out.println();

    } 

    /* the above solution is working perfectly fine but it not effiecient for large input
     * the time complexity is O(n)
     * we can solve this problem is O(sqrt(n)) time complexity 
     * Every factor has a partner that, when multiplied, gives n.
     * If we find a smaller factor i, the larger factor n / i is automatically found!
     */

     public static void Findfactor2(int num){

        for (int i = 1; i<= Math.sqrt(num); i++) {
           if (num % i == 0) {
            if (num/i == i) {
                System.out.print(i + " ");
            }
             System.out.print( i + " " + num/i + " ");
           }
        }
     } 

     /* but here it is not in order   */
     public static void Findfactor3(int num){
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i<= Math.sqrt(num); i++) {
           if (num % i == 0) {
            if (num/i == i) {
                System.out.print(i + " ");
            }
             System.out.print(i + " " );
             list.add(num/i);
           }
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }
     } 
    
    public static void main(String[] args) {
 /*      System.out.println(MoreMaths.checkIfPrime(1));
        System.out.println(MoreMaths.checkIfPrime(2));
        System.out.println(MoreMaths.checkIfPrime(3));
        System.out.println(MoreMaths.checkIfPrime(4));
        System.out.println(MoreMaths.checkIfPrime(6));
        System.out.println(MoreMaths.checkIfPrime(13));
        System.out.println(MoreMaths.checkIfPrime(12));   
        System.out.println(MoreMaths.prime2(50));
        System.out.println("_____________________");
        System.out.println(MoreMaths.prime(50));
        System.out.println(MoreMaths.prime(10));      
        System.out.println(MoreMaths.findSqrt(10, 3));
        System.out.println(MoreMaths.findSqrt(40, 3));
        System.out.println(MoreMaths.findSqrt(36 , 3));   */ 
        MoreMaths.Findfactor(20);
        MoreMaths.Findfactor2(20);
        MoreMaths.Findfactor3(20);
        
    }
}
