public class problem4 {
    // find number with even number of digits in array 
    // Input: nums = [12,345,2,6,7896]
    // Output: 2

    public static boolean evenDigit(int number){
            String num = String.valueOf(number);
            int le = num.length();
            if(le % 2 == 0){
                return true;
            }
            return false;
        }
        
        public static int findEven(int arr[]){    
            int count = 0 ;
            for (int i = 0; i < arr.length; i++) {
      
                if(evenDigit(arr[i])){
                count++;
            }
        }
        return count ; 
    }


    // problem 4 
   // [[1,5],[7,3],[3,5]]
    public  static int maximumWealth(int[][] accounts) {
        int wealthiest = 0 ;
       
        for (int i = 0; i < accounts.length; i++) {
            int sum = 0 ;
            for (int j = 0; j < accounts[i].length; j++) {
                sum += accounts[i][j];
            }
            if (sum > wealthiest) {
                wealthiest = sum;
            }
        }

        return wealthiest;
    }
    public static void main(String[] args) {
        int[][] twoDarray = {
            {1,5},{7,3},{3,5}
        };
        System.out.println(problem4.maximumWealth(twoDarray)); 

    }
}
