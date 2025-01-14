
import java.util.Arrays;

public class Binarysearch {

    // Binary search ==> 
    // step 1 array should be sorted ==> acs or Dsc 
    // step 2  find the pivot 
    // step 3 iterate 
    public static int FindValue(int arr[] , int target){
       
        Arrays.sort(arr);
        int n = arr.length;
        int num =  n/2;
        int pivot = arr[num];
        
        if(target > pivot){
            for (int i = num + 1 ; i < arr.length; i++) {
                if (arr[i] == target) {
                    System.out.println("Target found .");
                    return arr[i];
                }
            }
        }
        else if ( target < pivot) {
            for (int i = num - 1 ; i >= 0; i--) {
                if (target == arr[i]) {
                    System.out.println("Tarrget found . ");
                    return arr[i];
                }
            }
        }
        System.out.println("No target found !");
        return -1;

    }
    public static void main(String[] args) {

        int[] array = {2 , 5, 7, 4, 9 ,8, 134 , 555, 123 , 8};
        int value =   Binarysearch.FindValue(array, 5);
        System.out.println(value);
        
    }
}
