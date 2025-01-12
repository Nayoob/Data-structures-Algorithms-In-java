import java.util.Arrays;

public class problem {
    // remove duplicates from the array 
            public static int[] removeDuplicates(int arr[]){

            if(arr.length == 0 || arr == null){
                System.out.println("You Entered Empty array !");
                return arr;
            }
            int n = arr.length ; 
            int duplicate = 0 ; 
            for (int i = 0; i < n; i++) {
                duplicate = arr[i];
                if (duplicate != 0) {
                        for (int j = i+1 ; j < n; j++) {
                                if (arr[j] == duplicate) {
                                    arr[j] = 0;
                                }
                            }
                }
            }   // so far i have assigned zero to all those duplicate index 

            int pointer = 0 ; 
            for (int i = 0; i < n; i++) {
                if (arr[i] != 0) {
                     arr[pointer] = arr[i];
                     pointer++;
                }
            }
            return Arrays.copyOf(arr, pointer);
        } 
        public static void main(String[] args) {
            int arr[] = {3 , 2 , 3, 5 , 6, 5 ,7 ,8, 7, 3 }; 
            System.out.println(Arrays.toString(removeDuplicates(arr))); 
        }
}
