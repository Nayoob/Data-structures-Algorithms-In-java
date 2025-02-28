public class Strings {

   public static boolean checkPalindrom(String string){
      String stringtolower = string.toLowerCase();
      StringBuilder reversebuilder = new StringBuilder();
      for (int i = stringtolower.length() - 1 ; i >= 0; i--) {
         reversebuilder.append(stringtolower.charAt(i));
      }
      if (reversebuilder.toString().equals(stringtolower)) {
         return true;
      }
      return false ;
   }
   public static void main(String[] args) {

   String string1 = "abcdcba";
   System.out.println(Strings.checkPalindrom(string1));
    String string = new String();
    string = "";
      for (int i = 0; i < 26; i++) {
         char ch = (char)('a' + i) ;
         string = string + ch;
      }
      System.out.println(string); 
      
      // is there any differece between these two methods

      String serries = "";
      for (int i = 0; i < 26 ; i++) {
         char ch = (char)('a' + i);
         serries = serries + ch;
      }
      System.out.println(serries);

      // for this problem java has Stringbuilders to save more memory 
      StringBuilder builder = new StringBuilder();

      for (int i = 0; i < 26; i++) {
         char ch = (char)('a' + i);
         builder.append(ch);
      }
      System.out.println(builder);
   }

}
