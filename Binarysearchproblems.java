public class Binarysearchproblems {

    // check ceiling in array 
    // what is ceiling ==> the smallest element in array greator or equal to target ;
    // so this is how to appraoch problem using linear search 
    public static int checkCeilingNumber(int arr[] , int target){
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] == target){
                return arr[i];
            }else if(arr[i] > target){
                return arr[i];
            }
        }
        return 0;
   }
   // lets try it with binary search ..

   public static int CheckCeilingWithBianry(int arr[] , int target){
       if (arr.length == 0 || arr == null) {
          return -1 ;
       }
       int start = 0 ; 
       int end = arr.length -1 ;

       while(start <= end){
        int mid = start + (end - start) / 2;
        if(target == arr[mid]){
            return arr[mid] ;
        }
        else if(target > arr[mid]){
            start = mid + 1 ;
        }
        else{
            end = mid -1 ;
        }
       }
       return arr[start];
   }

   // what is floor ? 
   // the greatest number which is equal or less then target . in array 

   public static int checkFloorWithBinary(int arr[] , int target ){

      if (arr.length == 0 || arr == null) {
         return -1 ;
     }
       int start = 0 ; 
       int end = arr.length -1 ;   
       while (start <= end) {
          int mid = start + (end - start) / 2 ;
          if(target == arr[mid]){
            return arr[mid];
          }
          else if(target > arr[mid]){
            start = mid + 1; 
          }
          else{
            end = mid - 1 ;
          }
       }
       return arr[end];  // this will return the floor of array 
   }

   
   // find an element in an infinit array ? 
   // lets assume the array that we recieved in the parameter of the function is infinit we cant 
   // use the length funciton on it ...]


   // how i try to appraoch the problem  time complexetu O(n)
   public static boolean FindelementInInfiniteArray(int arr[] , int target){
        int start = 0 ; 
        int end = start + 10;
        boolean isFound = false;

        while (!isFound) {
            int nestedStart = start ;
            int nestedEnd = end;
            while (nestedStart <= nestedEnd) {
                int mid = nestedStart + (nestedEnd - nestedStart) / 2 ;
                if (target == arr[mid]) {
                    System.out.println("The target element found " + arr[mid]);
                    isFound = true;
                    break;
                }
                else if(target > arr[mid]){
                    nestedStart = mid + 1;
                }
                else{
                    nestedEnd = mid - 1 ;
                }     
            }
            if (isFound) {
                break;
            }
            start = end + 1 ; 
            end = start + 10 ;
        }
        return isFound;
   }

   // optimized way to solve the same problem ==> time complexity O(logn) use this approach to solve problem 
   public static int FindelementInInfiniteArrayy(int arr[] , int target){
      int start = 0 ;
      int end = 1 ;
      while (target > arr[end]) {
         start = end + 1 ;
         end = end * 2 ; // doubling the range of our search box to decrease the time compelexity
      }
      while (start <= end ) {
        int mid = start + (end - start) / 2;
        if (target == arr[mid]) {
            System.out.println("Element found in Infinite sorted array ! ");
            return arr[mid];
        }
        else if(target > arr[mid]){
            start = mid + 1 ;
        }
        else{
            end = mid - 1 ;
        }
      }
      return -1 ;
   }

   // problem find peak index in mountain array //
   public static int PeakIndexInMountainArray(int arr[]){
    int start = 0 ;
    int end = arr.length -1 ;
    while (start < end) {
        int mid = start + (end - start ) / 2;
        if (arr[mid] > arr[mid + 1]) {
            end = mid  ;
        }
        else{
            start = mid + 1 ;
        }
    }
    return end;
   }

    public static void main(String[] args) {
        // int[] array = { 2 , 4, 5, 6 ,8, 9 , 11 , 89, 345};
        // System.out.println(Binarysearchproblems.checkCeilingNumber(array , 9));
        // System.out.println(Binarysearchproblems.checkCeilingNumber(array , 10));
        // System.out.println(Binarysearchproblems.CheckCeilingWithBianry(array, 12));
        // System.out.println(Binarysearchproblems.checkFloorWithBinary(array, 3));

        int[] array = {2 , 4 , 6 , 8 , 7 , 5 , 3};
        System.out.println(Binarysearchproblems.PeakIndexInMountainArray(array));
    }
}
