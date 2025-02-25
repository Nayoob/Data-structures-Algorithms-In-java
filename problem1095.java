

public class problem1095 {

    //  Search element in mounain array  // 

    public static int findpeakIndexOfMountainArray(int arr[]){
       if(arr.length == 0 || arr == null){
        return -1 ;
       }
       int start = 0;
       int end = arr.length -1 ;
       while (start < end) {
        int mid = start + (end - start) / 2;
        if(arr[mid] > arr[mid + 1]){
            end = mid ;
        }
        else {
            start = mid + 1;
        } 
       }
       return end ;

    }
    public static int Search(int arr[] , int target ){

       int peakIndex = findpeakIndexOfMountainArray(arr);

       int result = SearchAscendingPart(arr, target, 0, peakIndex);
       if (result != -1) {
         return result;
       }

       int resulttwo = SearchSDescendingPart(arr, target, peakIndex + 1, arr.length-1);
       
       return resulttwo;

    }
    public static int SearchAscendingPart(int arr[] , int target , int start , int end){

        while (start <= end ) {
          int mid = start + (end - start) / 2 ;
          if (arr[mid] == target) {
             System.out.println("target found");
             return arr[mid];
          }     
          else if(arr[mid] < target){
             start = mid + 1;
          }
          else{
             end = mid - 1 ;
          }   
        }
       
        return -1;
    }
    public static int SearchSDescendingPart(int arr[] , int target , int start , int end ){

        while (start <= end ) {
          int mid = start + (end - start) / 2 ;
          if (arr[mid] == target) {
             System.out.println("target found");
             return arr[mid];
          }     
          else if(arr[mid] < target){
             end = mid - 1;
          }
          else{
             start = mid + 1 ;
          }   
        }
        System.out.println("target not found .... ");
        return -1;
    }


    public static void main(String[] args) {
        int arr[] = {1, 3, 8, 12, 4, 2};
        int target = 14;

        System.out.println(problem1095.Search(arr, target));
        System.out.println("___________________");

        int arrone[] = {1, 3, 8, 12, 4, 2};
        int target1 = 12;

        System.out.println(problem1095.Search(arrone, target1));
        System.out.println("___________________");
        
        int arrtwo[] = {5};
        int targettwo = 5;
        
        System.out.println(problem1095.Search(arrtwo, targettwo));

    }
}
