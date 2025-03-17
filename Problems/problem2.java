public class problem2 {

   // Input: words = ["abc","car","ada","racecar","cool"]
   // find first palindrom string in the array // 

   public static String firstPalindrome(String[] words) {
 
    String reverseWord = "";
    String word = null ; 

    for (int i = 0; i < words.length; i++) {
        reverseWord = "" ; 
        word = words[i];

        for (int j = word.length() - 1 ; j >=0 ; j--) {
            reverseWord += word.charAt(j);
         }
         if (reverseWord.equals(word)){
           System.out.println("The word at index " + i + " is palindrom .");
            return word;
         }     
        }
        return "";
   }
    public static void main(String[] args) {

        String[] words = {"abc", "car", "ada", "racecar", "cool"};
        System.out.println(problem2.firstPalindrome(words)); 
 
    }
}
