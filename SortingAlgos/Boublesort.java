import java.util.Arrays;

public class Boublesort {

    public static void boublesort(int[] arr){
       
        for (int i = 0; i < arr.length; i++) {

            /* to better understand the need of this outer loop is 
             * when we do one compolete iteration of inner loop the highest 
             * most element of the array will be place at the end of the lSB of array 
             * so we iterate again the inner loop the second highest element of the array will 
             * be positioned at the index : arr.length - 2 ; mean the second last 
             */
            for (int j = 1; j < arr.length  ; j++) {
                if (arr[j] < arr[j-1]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp; 
                }
            }
        }
      //  System.out.println(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void main(String[] args) {
        int[] array = {2 , 5, 3, 1, 4};
        Boublesort.boublesort(array);
    }
}
