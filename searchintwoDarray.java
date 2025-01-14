public class searchintwoDarray {

    public static void search(int array[][] , int target){

        if (array.equals(null)) {
            System.out.println("Empty array");
            return ;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length ; j++) {
                if (array[i][j] == target) {
                    System.out.println("the target exist in 2D array : " + array[i][j]);
                    return;
                }
            }
        }
        System.out.println(target + " doesnt exist in 2D array ");
        return;

    }

    // finding the minimum value in the 2D array
    public static int findMin(int arr[][]){
        
        int min = Integer.MAX_VALUE;  // i have assigned the min the largest value possible 

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(arr[i][j] < min){
                    min = arr[i][j];
                }
            }
        }
        System.out.println("Min found .. ");
        return min ;

    }
    public static int findMax(int arr[][]){
        
        if (arr.length == 0 ){
            System.out.println("Array is Empty .. ");      
            return -1 ;      
        }

        int max = arr[0][0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(arr[i][j] > max ){
                    max = arr[i][j];
                }
            }
        }
        System.out.println("Max found ..");
        return max ; 

    }
    public static void main(String[] args) {
        int[][] array = {
             {1, 2, 3},
             {4, 5, 6},
             {7, 8, 9}
        };

        searchintwoDarray.search(array, 9);
        searchintwoDarray.search(array, 12);

       System.out.println(searchintwoDarray.findMin(array)); 
       System.out.println(searchintwoDarray.findMax(array));


        // this is 2D array now we are asked to check whether the 5 is present in the 2d array
    }
}
