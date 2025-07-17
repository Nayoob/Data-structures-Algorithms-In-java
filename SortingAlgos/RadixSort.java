import java.util.Arrays;

public class RadixSort {

    /* this is the final Game  */
    public static void CountSort(int[] arr , int exp){

        int n = arr.length ; 
        int[] output = new int[n];
        int[] count = new int[10];
        
        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }
        System.out.println( "Count Array : " + Arrays.toString(count));

        for (int i = 1; i < count.length; i++) {
            count[i] = count[i] + count[i-1];
        }

        System.out.println("Updated Count :" + Arrays.toString(count));

        for (int i = n - 1; i >= 0; i--) {

            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;

        }
        System.out.println("Output Array : " + Arrays.toString(output));
         
        for (int i = 0; i < n; i++) {
           arr[i] = output[i];
    }
    
    }

    public static int check(int[] arr){
        int max = 0 ;
        for (int i = 0; i < arr.length; i++) {
            String str = Integer.toString(arr[i]);
            if (str.length() >= max) {
                max = str.length();
            }
        }

        return max ;
    }

    public static int[] Sort(int[] originalArr){

        int higherElementInArr = check(originalArr);
        int exp = 1 ; 
        
        for (int i = 0; i < higherElementInArr; i++) {
            CountSort(originalArr, exp);
            exp *= 10 ;
            System.out.println("______________________");
        }
        
        return originalArr;
    }
    public static void main(String[] args) {
        int[] arr = { 29 , 83 , 471 , 36 , 91 , 8};
        RadixSort.Sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
