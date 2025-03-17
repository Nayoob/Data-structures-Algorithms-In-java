public class RecrusionlevelOne {

    /* lets say we are given 5 and we have to print n to 1  */
    public static void recursion(int num){
       if (num == 0) {
         return ;
       }
       System.out.println(num);
        recursion( num - 1);
    }
    /* working perfectly fine but if we are asked to print the number in asc order with input 5 ? 
     * ? 
     */
    public static void recursionone(int num){
        if (num == 0) {
          return ;
        }
         recursionone( num - 1);
         System.out.println(num);
     }
     /* sum of n to 1 
      * lets say we are given 5 and asked to give me the sum of 5+ 4 + 3 + 2 + 1 = 15
      * lets try to code this 
      */
    public static int sum(int num){
      if (num == 1) {
        return num;
      }
      return num + sum(num -1);
    }

    /* lets try to code sum of digits function with recursion 
     * ex : 1342
    */
    public static int sumofDigits(int num){
       int reminder = num % 10;
       num = num / 10;
       if (num == 0) {
          return reminder;
       }
       return reminder + sumofDigits(num);
    }

    /* one imp thing that i need to mention here 
     * look at this function and tell me what could be the possible output 
     */
    public static int print(int num){
        if (num == 1) {
            return num  ;
        }
        System.out.println(num);
         return print(--num);
    }

    /* lets try to code a function which should give me the reverse of a number
     * ex : num 1234
     */
    
    public static void reverseInt(int num){
      if (num == 0) {
        return ;
      }
      System.out.print(num % 10);
      reverseInt(num/10);
    }

    /* count the number of zeros in the number 
     * lets say 102304
     */

    public static void checkZeros(int num  , int count){
       if (num == 0) {
        System.out.println(count);
        return ;
       }
       int reminder = num % 10;
       count = (reminder == 0) ? count + 1 : count;
       num /= 10;
       checkZeros(num, count);

    }

    /* leet Code 1342 : count the number of steps untill number become zero plus if 
     * a number is even divide by 2 if odd subtract is by 1
     * lets try to code this here first  : 16 
     */
    public static int numberOfSteps(int num , int count){
      if ( num == 0 ) {
       return count;
      }
       num = (num % 2 == 0) ? num / 2 : num - 1;
       count = count + 1;
       return numberOfSteps(num , count);
    }
    public static void main(String[] args) {
     /*   RecrusionlevelOne.recursion(5);
         RecrusionlevelOne.recursionone(5);
         System.out.println(RecrusionlevelOne.sum(5));
         System.out.println(RecrusionlevelOne.sumofDigits(1342));
         System.out.println( RecrusionlevelOne.print(5)) ;
         RecrusionlevelOne.reverseInt(1234);  
         RecrusionlevelOne.checkZeros(102304, 0); */
         System.out.println(RecrusionlevelOne.numberOfSteps(14 , 0));
    }
}
