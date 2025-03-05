
public class Maths {
    
    // checking if NUmber is even  using bitwise operation 

    public static String isCheck(int number){
        if ((number & 1) == 1 ) {
            return "odd";
        }
        return "Even";
    }
 /* lets say your are given an array and asked to return a number which has no duplicate 
    since all other numbers have duplicates  
    [ 2, 3, 4, 2, 5, 1, 6 , 5 , 4, 3, 1, ]  time complexity O(n^2)   */

    public static int Search(int[] arr){
     
        for (int i = 0; i < arr.length; i++) {
            int counter = 0 ;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    counter++;
                }
            }
            if(counter == 1){
                return arr[i];
            }
        }
        return -1 ;
    }
 /*   This solution is working perfectly fine but how can we optimize this via bitwise operator 
      lets see ; what if we take XOR of each number will that work i guess so 
      as we know any number xor with that number gives zero a ^ a = 0 if our array has all the duplicates
      and one element doesnt have any duplicate so all the duplicates will be cancelled and we will retrurn 
      that singal element  time complexity O(n) */      
    
    public static int BitwiseSeatrch(int[] arr){
        int index = 0 ;
        for (int n : arr) {
            index = index ^ n ;
        }
        return index;
    }

    // find the ith bit of the number lets try to solve this one 
    // step 1 : lets say you got n and i n is the number which i will be converting to binary 
    // step 2 : finding the ith bit of that binary checking if its 1 or 0 
    // (1 << ibit) yes that shit confuses me too but that is simple mask that i just created for the 
    // this n ; mask is special number that you create to check any specific  bit or to work with any specific bit 
    

    public static int findbit(int n , int ibit){
  
        return ( n & (1 << ibit) ) == 0 ? 0 : 1 ;
          
    }

    /* Now there is kinda Question how to set specific bit let say we have binary of 10000 i need to 
     * set the bit 2 to 1 to make the number 20 which was previously 16 but how 
     * so any  bit OR with 1 become 1 so if we create mask accordingly then take OR i guess 
     * we have figuered it out 
     * 1 0 0 0 0 
     * 0 0 1 0 0
     * __________
     * 1 0 1 0 0 == > 20
     */

    public static int setBit(int n , int bit){
        return  n | (1 << bit) ; 
    }

    /* how to reset bit means if bit is 1 turn it of i mean make it 0 if its zero let it be zero 
     * lets say we have binary [ 1 0 1 0 0 ] now i need to reset bit 2 turn it off but how ? 
     * i dont know hahahah but lets figured it out 
     * take & with 0s yes i think this will work but no this will just disturb the sequence of other bits too !
     * what is make a mask 0 0 1 0 0 then take compliment of that mask ==> 1 1 0 1 1 then take & with that n
     * i guess this will work without disturbing other bits and make that specific one 0 
    */
    public static int resetBit(int n , int bit){
       return n & ~(1 << bit);
    }

    /* find the position of right most set bit 
     *  first thing convert the number to bits lets say number is 20 and binary is [ 1 0 1 0 0 ]
        so the position of right most bit is 3 with 1th based indexing 
     */
    public static int positionOfRightMostBit(int n ){
        int count = 1 ;
        while((n & 1 ) == 0){
          n = (n >> 1);
          count++;
        }
        return count ;
    }

    /*  find the magic Number ? 
     * what is magic number in simple terms i can say sum of distinct power of 5 but base can be any number like 2 3 7 
     * lets understand via example 
     * 6 = > 0 1 1 0 
     * 5^4 * 0 + 5^3 * 1 + 5^2 * 1 + 5^1 * 0 so summing up this i got some thing 125 + 25 = 150 
     * lets code this 
     * since i am doing 1th base indexsing for powers so initialize power with 5 instead of  1 ;
    */
    public static int FindMagicNumber(int num){
       int power = 5 ;
       int magic = 0 ;
        
       while (num > 0) {
          int lastbit = (num & 1) ;
          magic = magic + lastbit * power ;
          power = power * 5;
          num =  num >> 1;
       }
       return magic;
    }
 /* Lets start doing this challange lets say your are asked to convert a number with base 10 to 
  * number with base 2 simply convert a number to binary 

  */
    public static void convertToBinary(int n ){
        StringBuilder toBinary = new StringBuilder();
        while (n > 0 ) {
            int lastbit = (n & 1);
            toBinary.append(lastbit);
            n = n >> 1;
        }
        System.out.println(toBinary.reverse().toString());
    }

    /* find the number of digits in base b lets say you have a number in decimal your asked to find the 
     * number of digits in its binary or octal 
     */
    public static int NumberOfDigits(double n , double b){
        double Number = n ;
        double base = b ;
        int digits = (int)(Math.log(Number) / Math.log(base)) + 1 ;
        // this will return me the number of digits in that n in specific base 
        return digits;
    }


    /* sum of ith row in pascal triangle 
     * let get ith row first 
     */
    public static int Pascaltriangle(int i){
        int sum = (int) Math.pow(2 , i);
        return sum ;
    }


    /* lets say your given a number and asked to check if its the power of 2 */
    public static void check(int n){
        double ans = (Math.log(n) / Math.log(2) );
        if (ans == (int) ans) {
            System.out.println(n + " is the power of 2");
        }
        else{
            System.out.println(n + " is not the power of 2");
        }
    }


    /* find XOR of number from zero to A  */

    public static int findXOR(int a) {
        if (a % 4 == 0) return a;
        if (a % 4 == 1) return 1;
        if (a % 4 == 2) return a + 1;
        return 0; // If a % 4 == 3
    }

    /* so the Question is 832 Flipping an image */
   
        public int[][] reverseArray(int[][] image){
             for(int i = 0 ; i < image.length ; i++){
                reverseSingleArray(image[i]);
            }
            return image ;
        }
        public void reverseSingleArray(int[] array){
           int start = 0 ; int end = array.length - 1 ;
           while(start < end){
             int temp = array[start];
             array[start] = array[end];
             array[end] = temp ;
             start++;
             end--;
           }
        }
        public int[][] flipbits(int[][] image){
            for(int i = 0 ; i < image.length ; i++){
                for(int j = 0 ; j < image[i].length ; j++){
                   image[i][j] = image[i][j] ^ 1;
                }
            }
            return image;
        }
        public int[][] flipAndInvertImage(int[][] image) {
            int[][] horizantalflip = reverseArray(image);
            return flipbits(horizantalflip);
        }
    
    public static void main(String[] args) {
        int[] array = { 2, 3, 4, 2, 5, 1, 6 , 5 ,6, 4, 3, 1, };
        int[] arrayone = { 2, 3, 4, 2, 5, 1, 5 ,6, 4, 3, 1, };
        System.out.println(Maths.Search(array));
        System.out.println(Maths.Search(arrayone));
        System.out.println(Maths.BitwiseSeatrch(arrayone));
        System.out.println("_________________________");
        // 1000
    /*   System.out.println(Maths.findbit(8, 0));
        System.out.println(Maths.findbit(8 , 1 ));
        System.out.println(Maths.findbit(8, 2));
        System.out.println(Maths.findbit(8, 3));
        System.out.println(Maths.findbit(8, 4)); */ 

        // System.out.println(Maths.setBit(16, 02));
        // System.out.println(Maths.resetBit(20, 2));

      //  System.out.println(Maths.positionOfRightMostBit(20));
        Maths.convertToBinary(6);

    }
}
