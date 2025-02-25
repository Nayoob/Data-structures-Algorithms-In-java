import java.util.Arrays;

public class CyclicSort {
    
    // cyclic sort is used when a range is given between 1 to n 
    // we use cyclic sort when we have to perform calculation in O(n) time complexity and O(1) space complexity 
    // lets say we have an array of [3, 6, 1, 2, 4, 5] ;
    
    public static int[] SortOne(int[] arr){
       if (arr.length == 0) {
        System.out.println("Empty array");
         return arr;
       }
       int i = 0 ;
       while ( i < arr.length) {
          int correctIndex = arr[i] -1 ;
          if (arr[i] < arr.length && arr[i] != arr[correctIndex] ) {
            int temp = arr[correctIndex];
            arr[correctIndex] = arr[i];
            arr[i] = temp;
          }
          else{
            i++;
          }
       }
       return arr;
    }
   
    // zero exist here but we will only change code for zero
    // [3, 6, 0, 2, 4, 5]

    public static int[] Sorttwo(int[] arr){
        if (arr.length == 0) {
            System.out.println("Empty array");
             return arr;
           }
           for (int i = 0; i < arr.length; ) {
             int correctIndex = arr[i];
             if (arr[i] != arr[correctIndex]) {
                int temp = arr[correctIndex];
                arr[correctIndex] = arr[i];
                arr[i] = temp;
             }
             else{
                i++;
             }
           }
           return arr;
    }
    // suppose we have an elememt in the array whose is index doesnt lie in array but this wont work i will just put 
    // that number which dont have any index in array on some random index 

    public static int[] sortThree(int[] arr){
           int i = 0 ;
           while (i < arr.length) {
            int correctIndex = arr[i] ;
            if (arr[i] > arr.length || arr[i] == 0) {
                i++;
            }
            else if (arr[i] != arr[correctIndex]) {
                int temp = arr[correctIndex];
                arr[correctIndex] = arr[i];
                arr[i] = temp;
            }
            else{
                i++;
            }
           }

           return arr;
    }

    public static void main(String[] args) {
       int[] array = {3, 6, 1, 2, 4, 5};
       int[] arraytwo = {1, 3, 0, 2, 4, 5};
       int[] arraythree = {3, 0, 1, 2, 4, 5};
       System.out.println(Arrays.toString(CyclicSort.SortOne(array))); 
       System.out.println(Arrays.toString(CyclicSort.Sorttwo(arraytwo)));
       System.out.println(Arrays.toString(CyclicSort.sortThree(arraythree)));
    }
}
