public class problem3 {
    public boolean containsDuplicate(int[] nums) {
        int comparable = 0 ;
        for (int i = 0; i < nums.length; i++) {
            comparable = nums[i];
            for (int j = i+1 ; j < nums.length; j++) {
                if(nums[j] == comparable){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        
    }
}
