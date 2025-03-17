public class problem287 {
    // find the duplicate number in array 

    public static int Findduplicate(int[] arr){
        int i = 0 ; 
        while (i < arr.length) {
            int correctIndex = arr[i] -1 ; 
            if (arr[i] != arr[correctIndex]) {
                int temp = arr[correctIndex];
                arr[correctIndex] = arr[i];
                arr[i] = temp;
            }
            else{
                i++;
            }
        }
        return arr[arr.length-1];
    }
    public static void main(String[] args) {
        int[] testcase1 = {1, 3, 4, 2, 2};
        int[] testcase2 = {3 , 1 ,3, 4, 2};
        System.out.println(problem287.Findduplicate(testcase1));
        System.out.println(problem287.Findduplicate(testcase2));
    }
}
