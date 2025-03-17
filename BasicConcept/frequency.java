import java.util.ArrayList ;

public class frequency {
    
    public static void findFrequency(int number[]){
  
       ArrayList<Integer> li = new ArrayList<>();
        for (int i = 0; i < number.length ; i++){
          int checkReptition = number[i];
          if (li.contains(checkReptition)) {
            continue ; 
          }
          for (int j = 0; j < number.length; j++) {
              if (number[j] == checkReptition) {
                li.add(checkReptition) ; 
              }
          }
       }
       System.out.println(li);
    }
    public static void main(String[] args) {
        int arr[] = { 3 , 4 , 7, 4, 6, 7 , 8, 6, 7, };
        frequency.findFrequency(arr);
    }
}
