
public class Recursion {
    // lets learn what the heck is recurison why it gets so fucking confusing sometimes 
    // so what you need to do here is print sufyan 5 times we cant just call print() 5 times no cheating you nerd 
    // think about another solution what if use nested function calls that would work too lets give it a try 

    

 /*    public static void print(){
        System.out.println("Sufyan");
        print1();
    }
    public static void print1(){
        System.out.println("Sufyan");
        print2();
    }
    public static void print2(){
        System.out.println("Sufyan");
        print3();
    }
    public static void print3(){
        System.out.println("Sufyan");
    }   
         */

    // what if some one ask you to print number from 1 to 4 

/*  public static void printNum(int n){
        System.out.println(n);
        printNum1(n+1);
    }
    public static void printNum1(int n){
        System.out.println(n);
        printNum2(n+1);
    }
    public static void printNum2(int n){
        System.out.println(n);
        printNum3(n+1);
    }
    public static void printNum3(int n){
        System.out.println(n);
    }   
         */ 

         // if your asked to print the number 1m times what the heck will you be doing then calling 
         // function 1m times that would be so dumb of you so instead of doing this we will let the function
         // call it self ! seems like a smart apprach lets try 

         public static void print(int n){
           System.out.println(n);
           if (n < 20) {
            print(n+1);
           }
         }

        /* fibonacci using iterative apprach  */
         public static int fibonnaci(int n ){
            int a = 0 ; 
            int b = 1 ; 
            int result = 0 ;
            for (int i = 2; i < n; i++) {
                result = a + b ;
                a = b ; 
                b = result ;
            }
            return result ;
         }

         // fibonncci number using recursion 
         public static int Findfibonnaci(int n){ // find 4th fobonnaci number lets say 
            if(n < 2){
                return n ;
            }
            return Findfibonnaci(n-1) + Findfibonnaci(n-2);
         }

         // binary search using recursion // 
         // in recursion we have to take care of variables very carefully because it just sometimes messes up every thing 
         public static int BinarySearchWithRecursion(int[] arr , int target , int start , int end){
        
             if( start > end ){
                 return -1 ;
             }
             int mid = start + (end - start) / 2;
             if (target == arr[mid]) {
                return arr[mid];
             }
             else if(target < arr[mid]){
                return  BinarySearchWithRecursion(arr, target, start, mid -1);
             }
             return BinarySearchWithRecursion(arr, target, mid + 1, end);
         }

    public static void main(String[] args) {
         // print();
        // printNum(1);
        //  print(1);

        // System.out.println(Recursion.fibonnaci(6));
        int[] array = { 1 , 3 , 6 , 8 , 9  , 23, 33 , 56 };
        System.out.println(Recursion.BinarySearchWithRecursion(array, 23, 0, array.length -1));
        System.out.println(Recursion.BinarySearchWithRecursion(array, 3, 0, array.length -1));
        System.out.println(Recursion.BinarySearchWithRecursion(array, 41, 0, array.length -1));
        System.out.println(Recursion.BinarySearchWithRecursion(array, 0, 0, array.length -1));
        
    }
}
