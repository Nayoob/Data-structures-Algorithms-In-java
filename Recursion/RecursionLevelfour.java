import java.util.ArrayList;
import java.util.Arrays;

public class RecursionLevelfour {

    public static void recursion(String p , String up){
       if (up.isEmpty()) {
         System.out.println(p);
         return ;
       }
       char ch = up.charAt(0);
       if (ch == 'a' || ch == 'A') {
           recursion(p, up.substring(1));
       }else{
           recursion( p + ch, up.substring(1));
       }
    }
    public static String recursionOne(String up){  // "abccdeaf"
        if (up.isEmpty()) {

           return "";
        }
        char ch = up.charAt(0);
        if (ch == 'a' || ch == 'A') {
            return  recursionOne(up.substring(1));
        }
        else{
            return ch +  recursionOne(up.substring(1));
        }
    }
    /* lets say your are asked to remove the string / or skip the string from the 
     * given string 
     * appraach is almost same as above 
     */
    public static String SkipString(String string){
        if (string.isEmpty()) {
            return "";
        }
        if (string.startsWith("apple") || string.startsWith("APPLE")){
           return SkipString(string.substring(5));
        }else{
            return string.charAt(0) + SkipString(string.substring(1));
        }    
    }

    /* subsequense stuff is very very important  */
    public static void subseq(String processed , String recieved){
       if (recieved.isEmpty()) {
         System.out.println(processed);
         return ;
       }
       char ch = recieved.charAt(0);
       // pick recursion call 
       subseq( processed + ch, recieved.substring(1));
       subseq(processed, recieved.substring(1));
    }
    /*  lets try to code the exact same above thing by returing arrray list of subset instead of just 
     * printing the subsets 
     */
    public static ArrayList<String> subseqone(String processed , String recieved , ArrayList<String> list ){
        if (recieved.isEmpty()) {
          list.add(processed);
          return list ;
        }
        char ch = recieved.charAt(0);
        // pick recursion call 
        subseqone( processed + ch, recieved.substring(1), list);
        subseqone(processed, recieved.substring(1) , list);
        return list;
     }

     /* this time lets not pass the array list in the arguments  */
     public static ArrayList<String> subseqtwo(String processed , String recevied){
        if (recevied.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }
        char ch = recevied.charAt(0);
        ArrayList<String> left = subseqtwo( processed + ch , recevied.substring(1));
        ArrayList<String> right = subseqtwo(processed, recevied.substring(1));
        left.addAll(right);

        return left;
     }

     /* this one was lilll complicated but try to dry run & debug it you will be good 
      * lets say your given an array and your are asked to to find the subsets of this array 
      * interesting nahhhhh ! just do it 
      * iterative appraoch 
      */
      public static ArrayList<ArrayList<Integer>> Subset(int[] arr){
         /* [ 1 , 2, 3] */
         ArrayList<ArrayList<Integer>> outer = new ArrayList<>();
         outer.add(new ArrayList<>());

         for (int num : arr) {  /* pick 1  */

            int n = outer.size();
            for (int i = 0; i < n; i++) {
                ArrayList<Integer> internal = new ArrayList<>(outer.get(i)); /* make a copy of existing outerlist [] */
                internal.add(num);
                outer.add(internal);
            }
         }
         return outer;

      }

    public static ArrayList<ArrayList<Integer>> SubsetforDuplicate(int[] arr) {
        Arrays.sort(arr); 
        ArrayList<ArrayList<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());

        int start = 0, end = 0;
        
        for (int i = 0; i < arr.length; i++) {
            start = 0;
            
            if (i > 0 && arr[i] == arr[i - 1]) {
                start = end + 1;
            } 
            end = outer.size() - 1;
            int n = outer.size();
            
            for (int j = start; j < n; j++) {
                ArrayList<Integer> internal = new ArrayList<>(outer.get(j));
                internal.add(arr[i]);
                outer.add(internal);
            }
        }
        return outer;
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        RecursionLevelfour.recursion("", "abccdeaf");
        System.out.println(RecursionLevelfour.SkipString("absdappledgshs"));
        RecursionLevelfour.subseq("", "abc");
        System.out.println(RecursionLevelfour.subseqone("", "abc", list)); 
        int[] arr = {1 , 2 , 3};
        int[] arrone = {1 , 2, 2};
        System.out.println(RecursionLevelfour.Subset(arr));
        System.out.println(RecursionLevelfour.SubsetforDuplicate(arrone));
    }
}
