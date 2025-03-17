public class problem33 {

    // seach in rotated  sorted array ==> so its sorted array without any confusion apply binary search 
    //  how to appraoch the problem 
    // step 1:apply binary search algorithm 
    // step 2:now as we know its not the conventional sorted array it is rotated so we cant do the usual search which is search target in the 
    // left then or in the right as we did in simple binary search problems this one is lill different
    // example array [7 8 9 1 2 3 4 5 6]
    // in such array if we say the search 8 means our target is 8 we can just directly say find mid compare it with target if target is > mid 
    // eliminate the left half and search target in the right half this conventional search wont work here ;
    // because here in this array we can clearly see that 8 lies in left half this happens because the array is rotated at some specific pivot .....
    // step 3: find out the sorted half first in the array ? why because every rotated sorted array contain two halfs one is sorted and 
    // one is not sorted here the mid is 2 and the left half is unordered and right half is sorted in asc order 
    // our goal is find the sorted half check if our target lies there if yes return target if no eliminate the sorted half 
    // and again check the sorted and unsorted halfs in the remianing array 
    // step 4: in last return -1 if we dont find target in the array 
    

    public static int CheckinRotatedSortedArray(int arr[] , int target){
        if (arr.length == 0 || arr == null) {
            System.out.println("Empty array ");
            return -1 ;
        }
        int start = 0 ;
        int end = arr.length -1 ;

        while (start <= end) {
            int mid = start + (end - start) / 2 ;
            if (arr[mid] == target) {
                System.out.println("target found");
                return arr[mid];
            }
            // if the target is not arr[mid] then find the sorted half 
            if (arr[start] <= arr[mid]) {
                if (arr[start] <= target && target <= arr[mid]) {
                    end = mid - 1 ;
                }
                else{
                    start = mid + 1 ;
                }
            }
            else {
                if (arr[mid] <= target && target <= arr[end]) {
                    start = mid + 1;
                }
                else{
                    end = mid - 1;
                }
            }
        }
        return -1 ;
    }
    // lets do a function now which can  i think we dont need anther fucn for duplicated because the current one is handling duplicate values 
    // to i guess but 
    public static void main(String[] args) {
        int[] array = {7 ,  8 , 8 , 9  , 9  , 1  , 2 ,  3 ,  4 ,  5 ,  6 , 7 };
        System.out.println(problem33.CheckinRotatedSortedArray(array, 8));
    }
}
