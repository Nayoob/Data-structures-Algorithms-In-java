public class twosum {
    
        public int[] twoSumm(int[] nums, int target) {
           
            int n = nums.length ;
            int[] arrayofIndexes =  new int[2];
            for(int i = 0 ; i < n ; i++){
              
                   for(int j = i+1 ; j < n ; j++ ){
                     if(nums[i] + nums[j] == target){
                        arrayofIndexes[0] = j;
                        arrayofIndexes[1] = i;
                        return arrayofIndexes;
                     }
                   }
                
            }
            return null ; 
            
            
        }
}

