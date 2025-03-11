import java.util.Arrays;

public class QuickSort {

    /* Most efficient sorting algo so far 
     * we have studied bouble Sort 
     * we have done Insertion sort
     * we have studies Selection sort
     * then Merge Sort 
     * Now its time to dig in QUick sort 
     * Approach :
     * step 1 : pick the pivot 
     * step 2 : how to pick pivot ? good Question ! but i dont know let me figure it out its been so long  
     * 
     */
    public static void quickSort(int[] arr , int start , int end){
       if (start < end) {
         int pivot = findPivot(arr , start , end);
         quickSort(arr, start, pivot - 1);
         quickSort(arr, pivot + 1 , end);
       }
    }
    public static int findPivot(int[] arr , int start , int end){
        int pivot = arr[end];
        int i = start - 1 ;  // this one is interesting pointer we will disscuss this later
        
        for (int j = start ; j < end; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr , i , j);
            }
        }
        swap(arr, i + 1, end);
        return i + 1;
    }
    public static void swap(int[] arr , int i , int j){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp ;
    }
    public static void main(String[] args) {
        int[] array = {5 , 6, 7, 8, 1, 2 ,3 , 4};
        QuickSort.quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
}
