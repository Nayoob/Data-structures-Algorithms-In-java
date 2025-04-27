import java.util.Arrays;

public class MergeSort {
    public static int[] sort(int[] arr){

       if (arr.length == 1) {
         return arr;
       }
       int mid = arr.length / 2;

       int[] left = sort(Arrays.copyOfRange(arr, 0, mid));
       int[] right = sort(Arrays.copyOfRange(arr, mid, arr.length));

       return merge(left , right);
    }

    public static int[] merge(int[] left , int[] right){

       int[] mergedArray = new int[left.length + right.length];
       int i = 0;
       int j = 0 ;
       int k = 0;
       while (i < left.length && j < right.length) {
        if (left[i] < right[j]) {
            mergedArray[k] = left[i];
            i++;
          }else{
            mergedArray[k] = right[j];
            j++;
          }
          k++;
       }
       
       while ( i < left.length) {
          mergedArray[k] = left[i];
          i++;
          k++;
        }
       while ( j  < right.length) {
          mergedArray[k] = right[j];
          j++;
          k++;
       }
       return mergedArray;

    }

    // working fine but slower due to that sort() method
    public static int[] mergeOne(int[] left , int[] right){
        int[] newarray = new int[left.length + right.length];
        for (int i = 0; i < left.length; i++) {
            newarray[i] = left[i];
        }
        for (int j = 0 ; j < right.length ; j++) {
            newarray[j + left.length ] = right[j];
        }
        Arrays.sort(newarray);
        return newarray;

    }

    /* lets try to code a funciton which perform inplace sorting (merge sort) */
        
    public static void mergeSort(int[] arr, int start, int end) {
            if (start >= end) 
               return;  
            
            int mid = start + (end - start) / 2;
            
           
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            
            
            mergeInPlace(arr, start, mid, end);
        }
    
        public static void mergeInPlace(int[] arr, int start, int mid, int end) {
            int i = start, j = mid + 1;
    
            while (i <= mid && j <= end) {
                if (arr[i] <= arr[j]) {
                    i++;  
                } else {
                    int temp = arr[j];
                    int k = j;
    
                    while (k > i) {
                        arr[k] = arr[k - 1];
                        k--;
                    }
                    arr[i] = temp;
    
                    i++;
                    j++;
                    mid++;
                }
            }
        }
    
        public static void main(String[] args) {
            int[] arr = {5, 6, 7, 1, 2, 3, 4};
            mergeSort(arr, 0, arr.length - 1);
            System.out.println(Arrays.toString(arr));  
        }
    }
    

