import java.util.Arrays;

class selection{
    // left to right 
    public static int[] sort(int[] arr){
        for ( int i = 0; i < arr.length; i++) {
            int start = 0 ;
            int last = arr.length -1;
            int minindex = Min(arr , start , last);
            int temp = arr[minindex];
            arr[minindex] = arr[start];
            arr[start] = temp;
            start++;
         }
         return arr;
    }
    public static int Min(int arr[] , int start ,int last){
       int minIndex = start;
         for (int i = 0; i < arr.length; i++) {
            if (arr[start] > arr[i]) {
                minIndex = i;
            }
         }
        return minIndex;
    }

public class SelectionSort {

    public static void selection(int[] arr){
       for (int i = 0; i < arr.length; i++) {
        int last = arr.length - i - 1;
        int max = findmax(arr , 0, last);
        Swap( arr,  max , last);
       }
       
    }
    public static int findmax(int[] arr , int start , int last){
        int max = start;
        for (int i = start; i <= last; i++) {
            if (arr[max] < arr[i]) {
                max = i; 
            }
        }
        return max;
    }
    public static void Swap(int[] arr , int max , int last){
        int temp = arr[last] ;
        arr[last] = arr[max];
        arr[max] = temp;

    }

    public static void main(String[] args) {
        int[] array = {2 , -5, 3, 1, 4};
        System.out.println(Arrays.toString(selection.sort(array)));
    }
}
}
