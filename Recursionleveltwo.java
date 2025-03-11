
import java.util.ArrayList;

public class Recursionleveltwo {
    /* lets play with arrays
     * Question 1 : check whether array is in asc order or not     */
    public static boolean CheckAsc(int[] arr , int index){
       if (index == arr.length - 1) {
          return true ;
       }
       return arr[index] < arr[index+1] && CheckAsc(arr, index + 1);
    }

    /* the above function is working perfectly fine but i think it can be modified 
     * if we just dry run the above code it is recursing all the way to the last index 
     * whether is array is asc or not which is not good practice 
     * we can modify this function by exiting recursing when the first condition is false 
     */
    public static boolean modifiedCheckAsc(int[] arr , int index){
        if (index == arr.length - 1) 
           return true ;
        
        if (arr[index] < arr[index+1]) 
            return arr[index] < arr[index+1] && modifiedCheckAsc(arr, index + 1);
        else
            return false;     
     }
    /* lets modify it further */
    public static boolean modifiedCheckAscone(int[] arr, int index) {
        if (index == arr.length - 1) 
            return true;
        
        if (arr[index] >= arr[index+1])  
            return false; 
        
        return modifiedCheckAscone(arr, index + 1);
    }

    /* Implement Linear search using Recursion  */

    public static boolean checkTarget(int[] arr , int index , int target){
      if (index == arr.length) {
        return false ;
      }
      if (arr[index] == target) 
        return true;

      return checkTarget(arr, index + 1, target);
    }

    /* Implement linear search using recursion but this time the problem statment is lill
     * different [ 1 , 2, 3, 4, 4, 5,] return the indexes of same elemetn 
     * in this problem we we will be returning array list 
     */

    public static  ArrayList<Integer> check(int[] arr , int target , int index , ArrayList<Integer> list){
        if (index == arr.length) 
            return list ;
        
        if (arr[index] == target) 
            list.add(index);
        
        return check(arr, target, index + 1 , list);
    }

    /* problem statment lets say we have to do the exact same thing as we did in check() function 
     * but we dont have to pass the list in argument of the fucntion 
     * seems like intersting problem lets try to code this 
     * so if we dont have to pass the argument we need to make separte arraylist with each 
     * function call during recursion very inefficient then how would i keept the track of the frequencey of target
     * lets try  [ 1 , 2, 3, 4, 4, 5,]  we are basically merging all the list from each function call 
     */
    public static ArrayList<Integer> checkOne(int[] arr , int target , int index){
        ArrayList<Integer> list = new ArrayList<>();
        if (index == arr.length) 
            return list;
        
        if (target == arr[index]) 
            list.add(index);

        ArrayList<Integer> listfromAbovecall = checkOne(arr, target, index + 1);
        list.addAll(listfromAbovecall);
        return list;
    }

    /* check target in rotated sorted array 
     * in rotated sorted array simple binary search wont work beacuse arrays is not in full 
     * sorted order 
     * so our appracoh will lill bit different 
     * step 1 just pick the mid 
     * step 2 check if the left half is sorted 
     * step 3 if sorted check if our target lies there 
     * step 4 if yes reducd the search space by end = mid -1 ;
     * step 5 repeat ( ) [ 5 6 7 8 1 2 3 4 ] 
     * step 6 what if we get this kinda case [ 5 6 7  1 2 3 4 ] 
     * where our first if doesnt work 
     */

     public static int rotatedSorted(int[] arr , int target){
         int start = 0 ;
         int end = arr.length - 1 ;
         while (start <= end ) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[start] <= arr[mid]) {
                if (arr[start] <= target && target < arr[mid] ) {
                    end = mid - 1 ;
                }else{
                    start = mid + 1;
                }
            }
            else{
                if (arr[mid] < target && target <= arr[end]) {
                    start = mid + 1;
                }
                else{
                    end = mid - 1;
                }
            }
         }
         return -1;
     }
    /* find the number of rotations in the rotated sorted array 
     * how to do 
     * step 1 : find the pivot (pivot is basically the smallest element in the array)
     * step 2 : the index of that pivot is the number of rotations 
     * [ 5 , 6 , 7 , 8 ,  1,  2,  3, 4 ]
     */
    public static int numberOfRotations(int[] arr){
        int start = 0 ;
        int end = arr.length - 1 ;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            /* now there is two possibilities 
             * either the arr[mid] will be < mid - 1 then mid will be pivot or 
             * the mid will be arr[mid] > arr[mid + 1] then mid + 1 will be the pivot
             */
            if (arr[mid] < arr[mid -1]) {
                return mid;
            }
            if (arr[mid] > arr[mid + 1]) {
                return mid + 1;
            }
            if (arr[mid] >= arr[start]) {
                
                start = mid + 1;
            } else {
                
                end = mid - 1;
            }
        }
        return 0;
    }

    /* lets try to code the rotated sorted one using recursion  */
    public static int rotatedSortedOne(int[] arr , int target , int start , int end){
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (arr[mid] == target) {
            return mid;
        }

        if (arr[start] <= arr[mid]) {
            if (arr[start] <= target && target < arr[mid] ) {
               return rotatedSortedOne(arr, target, start, mid - 1);
            }else{
               return rotatedSortedOne(arr, target, mid + 1, end);
            }
        }
        else{
            
            if(arr[mid] < target && target <= arr[end]){
               return rotatedSortedOne(arr, target, mid + 1, end);
            }
            else{
               return rotatedSortedOne(arr, target, start, mid - 1);
            }
        }
        
    }

    public static void main(String[] args) {
        int[] array = { 1 , 2, 3, 4, 4, 5}; 
        int[] arrayone = { 5 , 6 , 7 , 8 ,  1,  2,  3, 4 } ;
         ArrayList<Integer> list = new ArrayList<>();
         System.out.println(Recursionleveltwo.check(array, 4, 0, list));
        System.out.println(Recursionleveltwo.checkOne(array, 4, 0));
        System.out.println(Recursionleveltwo.rotatedSorted(arrayone, 2));
        System.out.println(Recursionleveltwo.rotatedSortedOne(arrayone, 6, 0, arrayone.length -1));
    }
}
