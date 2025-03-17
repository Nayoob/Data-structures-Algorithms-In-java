import java.util.Arrays;

public class Revision {
    /* sorting algorithms 
     * lets take bouble sort first 
     * in bouble sort we generally compare two indexes first two checking which number is smaller 
     * so place the smallest one int left most index and so on 
     * when we are done with first itereation the sorting will automatically place the largest 
     * elemetn in right most index 
     */

     public static int[] boublesort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j] < arr[j-1]) {
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp ;
                }
            }
        }
        return arr;
     }

     /* perfectly working lets try to code a fucntion that sort array using insertion sort 
      * how does insertion sort work 
      * sort to specifci index then agains sort upto the specific index 
     */
    public static int[] insertionSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0 ; j--) {
                if (arr[j] < arr[j-1]) {
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp ;
                }
            }
        }
        return arr;
    }

    /* last but not least selection sort lets try to code that too 
     * approach : pick minimum index and place that index on left most 
     */
    public static int findMin(int[] arr , int start , int end){
        int min = start ;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < arr[start] ) {
                min = i ;
            }
        }
        return min;
    }
    public static int[] selectionSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int start = 0 ;
            int end = arr.length - 1;
            int minIndex = findMin(arr , start , end);
            int temp = arr[minIndex];
            arr[minIndex] = arr[start];
            arr[start] = temp ;
            start++;
        }
        return arr;
    }

    /* lets code a function which should tell me whether array is acs , desc or undordered  */
    public static void CheckArray(int[] arr){
        boolean isASC = true ;
        boolean isDESC = true ;
        // {1, 2, 3, 4, 5};  {9, 7, 5, 3, 1};  {3, 1, 4, 2, 5};
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                isDESC = false; 
            } else if (arr[i] < arr[i - 1]) {
                isASC = false; 
            }
        }
        if (isASC) {
            System.out.println("Array is in ascending order");
        } else if (isDESC) {
            System.out.println("Array is in descending order");
        } else {
            System.out.println("Array is unordered");
        }
        
    }


     public static void main(String[] args) {
        int[] array = { 3 , 2, 5, 7, 9, 10};
        int[] arrayone = {3, 5 ,2, 5 , 2 , 4 , 6 };
        int[] arraytwo = {2 , -5, 3, 1, 4};

      /* System.out.println(Arrays.toString(Revision.boublesort(array)));
        System.out.println(Arrays.toString(Revision.boublesort(arrayone)));   
        System.out.println(Arrays.toString(Revision.insertionSort(array)));    
        System.out.println(Arrays.toString(Revision.insertionSort(arrayone))); 
        System.out.println(Arrays.toString(Revision.selectionSort(array)));
        System.out.println(Arrays.toString(Revision.selectionSort(arrayone)));
        System.out.println(Arrays.toString(Revision.selectionSort(arraytwo))); */

        int[] arr1 = {1, 2, 3, 4, 5};  // Ascending
        int[] arr2 = {9, 7, 5, 3, 1};  // Descending
        int[] arr3 = {3, 1, 4, 2, 5};  // Unordered
        CheckArray(arr1);  // Expected: array is in asc
        CheckArray(arr2);  // Expected: array is in desc
        CheckArray(arr3);  // Expected: Array is unordered
     }
}
