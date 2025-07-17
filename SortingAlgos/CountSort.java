import java.util.Arrays;

public class CountSort {

    private static int getMax(int[] arr){
      int max = arr[0];
      for (int i = 1; i < arr.length; i++) {
        if (max < arr[i]) {
            max = arr[i];
        }
      }
      return max;
    }

    public static int[] Sort(int[] origionalArray){
       /* first make a frequency array of size origionalArray + 1 */

  
       int[] frequencyArray = new int[getMax(origionalArray) + 1];

       for (int i = 0; i < origionalArray.length; i++) {
          int frequencyArrayIndex = origionalArray[i];
          frequencyArray[frequencyArrayIndex]++;
       }
       
       int j = 0 ;
       for (int i = 0; i < frequencyArray.length; i++) {
         if (frequencyArray[i] != 0) {

            int k = frequencyArray[i] ; 

            while (k > 0) {
                origionalArray[j] = i ;
                j++;
                k--;
            }
         } 
       }
       return origionalArray;
    }
    public static void main(String[] args) {
        int[] arr = { 3 , 4 , 1 , 3 , 2 , 5 , 2 , 8};

        System.out.println(Arrays.toString(CountSort.Sort(arr)));

    }
}
