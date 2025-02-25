import java.util.Arrays;

public class Boublesort {

    public static void boublesort(int[] arr){
       
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i ; j++) {
                if (arr[j] < arr[j-1]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp; 
                }
            }
        }
        System.out.println(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void main(String[] args) {
        int[] array = {2 , 5, 3, 1, 4};
        Boublesort.boublesort(array);
    }
}
