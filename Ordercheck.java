class Ordercheck {
    // Write a function which will check whether an array is in ascending or descending order 
    public static boolean CheckOrder(int arr[]){

        if(arr.length == 0 || arr == null){
            return false;
        }  
        for (int i = 0; i < arr.length -1 ; i++) {
            if(arr[i] > arr[i+1]){
                return false ;
            }
        }
         return true ; 
        }
    // anther way to check 
        public static boolean checkAscendingOfArray(int arr[]){
          
            for(int i = 0 ; i < arr.length - 1 ; i++){
                if(arr[i] < arr[i+1] || arr[i] == arr[i+1]){  
                    continue;
                }
                else{
                    return false;
                }
            }
             return true;
        }

        // function to check whether array is asc or desc or unordered // 

      public static String Check(int arr[]){
         boolean isAsc = true;
         boolean isDsc = true;
         for (int i = 0; i < arr.length-1 ; i++) {
            if (arr[i] > arr[i+1]) {
                isAsc = false;
            }
            else if(arr[i] < arr[i+1]){
                isDsc = false;
            }  
         }
         if(isAsc == true){
            return "Asc";
         }
         else if(isDsc == true){
            return "Dsc";
         }
         else{
            return "unordered";
         }
      }


      // order agnostic binary search // 

      public static boolean search(int arr[] , int target){
        
        String checkOrder = Check(arr);
        if(checkOrder.equals("unordered")){
            System.out.println("Array is unordered");
            return false;
        }
        else if (checkOrder.equals("Asc")) {
           // logic for binary serach asc 

           int start = 0 ; 
           int end = arr.length -1 ;

           while(start <= end ){
             int mid = start + (end - start) / 2;
             if(arr[mid] == target){
                return true;
             }
             else if(target > arr[mid]){
                start = mid + 1 ;
             }
             else {
                end = mid - 1 ;
             }
           }
           return false;
         
        }
        else if(checkOrder.equals("Dsc")){
            int start = 0 ;
            int end = arr.length -1 ;
            while (start <= end) {
                int mid = start + (end - start) / 2 ;
                if(target == arr[mid]){
                    return true;
                }
                else if (target > arr[mid]) {
                    end = mid - 1; 
                    
                }
                else  {
                    start = mid + 1 ;
                }
            }
            return false;
        }
    
        return false ;
      }

    
      public static void main(String[] args) {
        int arr1[] = {1, 3, 5, 7, 9};
        System.out.println(search(arr1, 5));
    
        System.out.println(search(arr1, 10));
        System.out.println("______________________");

        int arr2[] = {9, 7, 5, 3, 1};

        System.out.println(search(arr2, 5));
    
        System.out.println(search(arr2, 4));

        System.out.println("______________________");
    
        int arr3[] = {1, 3, 2, 5, 4};
        System.out.println(search(arr3, 3));
        System.out.println("__________________");
        int arr4[] = {1};
        System.out.println(search(arr4, 1));
        
    
        System.out.println(search(arr4, 0));

        System.out.println();
    }
    

    
    
}
