import java.util.Arrays;

public class Array {
     /*lets say we have an array of size 10 and i am asked to remove the specific index value  */
     public static int[] removeElement(int[] arr , int target){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
               for (int j = i + 1; j < arr.length ; j++) {
                   arr[j - 1] = arr[ j ];
               }
               break;
            }
        }
        arr[arr.length - 1] = 0;
        return arr;
     }
    public static void main(String[] args) {
       int[] array = { 1 , 2 ,3, 4, 5, 6, 7, 8, 9, 10};
       System.out.println(Arrays.toString(Array.removeElement(array, 6)));
    }
}
