import java.util.Arrays;

public class problem268 {

    // find missing number  [3,0,1]
    public static int Search(int[] arr){

        for (int i = 0; i < arr.length; i++) {
            int correctIndex = arr[i];
            if ( arr[i] < arr.length && arr[i] != arr[correctIndex]) {
                int temp = arr[correctIndex];
                arr[correctIndex] = arr[i];
                arr[i] = temp;
            }
        }
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != j) {
                return j;
            }
        }
        return arr.length;
    }

    public static void main(String[] args) {
       int[] arr1 = {3 , 0 , 1}; 
       int[] arr = {3 , 0 , 1 , 2};
       System.out.println(problem268.Search(arr1));
    }
}
