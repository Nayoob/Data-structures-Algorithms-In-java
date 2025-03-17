import java.util.ArrayList;
import java.util.Scanner;


public class nestedarraylist {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        ArrayList<ArrayList<Integer>> nestedlist = new ArrayList<>();
        System.out.println("Enter how many nested array List you want to make ?");
        int numberOfArraylist = in.nextInt();
        for (int i = 0; i < numberOfArraylist ; i++) {
            nestedlist.add(new ArrayList<>());
        }
        

        // now Enter the Entries in each array list 

        for (int i = 0; i < numberOfArraylist; i++) {
            System.out.println("Enter the entries of " + i + "th sub Arraylist");
            for (int j = 0; j < 4; j++) {
                nestedlist.get(i).add(in.nextInt());
            }
        }

        System.out.println(nestedlist);
        in.close();
    }
}
