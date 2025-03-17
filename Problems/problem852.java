public class problem852 {

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
        return start;
       }
    public static void main(String[] args) {
        int[] array = {2 , 4, 6 ,8, 7, 5 ,3};
        System.out.println(problem852.PeakIndexInMountainArray(array));
    }
}
