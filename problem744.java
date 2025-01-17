public class problem744 {
    //744. Find Smallest Letter Greater Than Target

    public static char findChar(char letter[], char target){
       if (letter.length == 0 || letter == null) {
          System.out.println("Empty array");
          return 0;
       }
       int start = 0 ;
       int end = letter.length -1 ;
       while (start <= end) {
        int mid = start + (end - start) / 2;

        if(target >= letter[mid]){
            start = mid + 1 ;
        }
        else{
            end = mid -1 ;
        }  
       }
       return letter[start % letter.length];  // i did this to jump to index 0 when we are out of bound and loop break 
       // we will the return the 0th index as asked in the Question 
    }
    public static void main(String[] args) {
        
    }
}
