import java.util.ArrayList;
import java.util.List;

public class problem442 {
    // find all duplicates 
    public static List<Integer> findAllduplicates(int[] arr){
        int i = 0 ; 
        while (i < arr.length) {
            int correctIndex = arr[i] - 1;
            if (arr[i] != arr[correctIndex]) {
                int temp = arr[correctIndex];
                arr[correctIndex] = arr[i];
                arr[i] = temp;
            }
            else{
                i++;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int j = 0; j < arr.length; j++) {
            if(arr[j] != j+1){
               list.add(arr[j]);
            }
        }
        return list;
    }
    public static void main(String[] args) {
        int[] testcase1 = {4,3,2,7,8,2,3,1};
        System.out.println(problem442.findAllduplicates(testcase1));
    }
}
