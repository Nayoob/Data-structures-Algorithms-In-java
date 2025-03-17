public class problem34 {

    // so we are asked to find the first and last position of target in sorted array with O(logn) complexity

    public static int[] searchRange(int nums[] , int target){
        int[] ans = {};
        int start = search(nums, target, true);
        int end = search(nums, target, false);
        
        ans[0] = start;
        ans[1] = end ;

        return ans;
        
    }
    public static int search(int nums[] , int target , boolean findIndex){
        int ans = -1 ;
        int start = 0 ; 
        int end = nums.length -1 ;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(target == nums[mid]){
                ans = mid;
                if ( findIndex == true){
                    end = mid - 1;
                }
                else{
                    start = mid + 1 ;
                }
            }
            else if(target > nums[mid]){
               start = mid + 1 ;
            }
            else{
                end = mid - 1;
            }
        }
        return ans;
            
    }
    public static void main(String[] args) {
        
    }
}
