import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class RecursionLevelFive {

    /* permutations it just fucked me up during dry run  */
    public static void permutations(String proString , String unproString){
        if (unproString.isEmpty()) {
            System.out.print(proString + " ");
            return;
        }
        char ch = unproString.charAt(0);
        for (int i = 0; i < proString.length() + 1 ; i++) {

          String left = proString.substring(0,i);
          String right = proString.substring(i , proString.length() );
          permutations(left + ch + right , unproString.substring(1));
        }
    }

    public static ArrayList<String> permutationsPrintedInLIst(String proString , String unproString , ArrayList<String> list){
        if (unproString.isEmpty()) {
            list.add(proString);
            return list;
        }
        char ch = unproString.charAt(0);
        for (int i = 0; i < proString.length() + 1 ; i++) {

          String left = proString.substring(0,i);
          String right = proString.substring(i , proString.length() );
          permutationsPrintedInLIst(left + ch + right , unproString.substring(1) , list);
        }
        return list;
    }
    /* lets try to solve this without passing array list in the parameter we will create each list wiht every call 
     * we we just mergerd all the list at each call i hope it make sense if not i dont give a single fuck ! 
     */
    public static ArrayList<String> permutationsNoparaMeterList(String proString , String unproString ){
        if (unproString.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(proString);
            return list;
        }
        ArrayList<String> ansList = new ArrayList<>();

        char ch = unproString.charAt(0);
        for (int i = 0; i < proString.length() + 1 ; i++) {

          String left = proString.substring(0,i);
          String right = proString.substring(i , proString.length());
          ansList.addAll(permutationsNoparaMeterList(left + ch + right , unproString.substring(1)));         
        }
        return ansList;
    }
    /* Question count the number of permutation of this string  */
    public static int CountPermutations(String proString , String unproString){
        if (unproString.isEmpty()) {
            return 1;
        }
        char ch = unproString.charAt(0);
        int count = 0 ;
        for (int i = 0; i < proString.length() + 1; i++) {
            String left = proString.substring(0, i);
            String right = proString.substring( i , proString.length());
            count = count +  CountPermutations(left + ch + right , unproString.substring(1));
        }
        return count;
    }

    /* leet code 17  */
    public static void problem(String proString , String unproString ){
        if (unproString.isEmpty()) {
            System.out.print(proString + " ");
            return ;
        }
        int digit = unproString.charAt(0) - '0';

        for (int i = (digit - 1) * 3 ; i < 3 * digit ; i++) {
            char ch = (char) ('a' + i);
            problem(proString + ch, unproString.substring(1));
        }
    }

    /* but the leetcode want me to print the result in the List form */

    public static List<String> letterCombinations(String processed , String unprocessed ) {

        if (unprocessed.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            return list ;
        }

        ArrayList<String> ansList = new ArrayList<>();

        int digit = unprocessed.charAt(0) - '0';

        for (int i = (digit - 1) * 3; i < 3 * digit ; i++) {
            char ch =  (char) ('a' + i);
            ansList.addAll(letterCombinations(processed + ch , unprocessed.substring(1))) ;
        }

        return ansList ;
    }
    public static void main(String[] args) {
        RecursionLevelFive.permutations("", "abc");
        System.out.println();
     /*   String name = "Sufyan";
        System.out.println(name.substring( 0 , 3));
        System.out.println(name.substring(0, name.length()));
        System.out.println(name.substring(3, name.length() - 1)); */ 
        ArrayList<String> list = new ArrayList<>();
        System.out.println(RecursionLevelFive.permutationsPrintedInLIst("", "abc" , list));
         
        System.out.println(RecursionLevelFive.permutationsNoparaMeterList("", "abc"));
        System.out.println(RecursionLevelFive.CountPermutations("", "abc"));
        RecursionLevelFive.problem("", "12");
        System.out.println();
        System.out.println(RecursionLevelFive.letterCombinations("" , "12"));
     }
}
