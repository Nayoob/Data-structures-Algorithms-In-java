package MapInterface;

import java.util.HashMap;

public class Hashmap {

    private static final int PRIME = 101;

    public static long calcHash(String str){
       long hash = 0 ;

       for (int i = 0; i < str.length(); i++) {
          hash += str.charAt(i) * Math.pow(PRIME, i);
       }
        return hash ; 

    }
    public static void main(String[] args) {
       
        System.out.println(Hashmap.calcHash("sufyan"));
        // HashMap<Integer , String> map = new HashMap<>();
        // map.put(1,"jabbar" );
        // map.put(2, "gulagha");
        // map.put(3, "janana");

        // System.out.println(map);

        // System.out.println(map.containsKey(2));
        // System.out.println(map.hashCode());

        

        // for (int key : map.keySet()) {
        //     System.out.println(map.get(key));
        // }

        
    }
}
