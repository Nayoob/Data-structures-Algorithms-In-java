// import java.util.Locale;
import java.util.Scanner;

public class switchh {
    public static void main(String[] args) {
        // so what is switch statment // 

        try (// it is the alternate of if else ,  if else,  if else and the shit is going on
        Scanner s1 = new Scanner(System.in)) {
            System.out.println("Enter your id");
            int id = s1.nextInt();
            s1.nextLine();

            System.out.println("Enter dep name ..");
            String dept = s1.nextLine();

            switch (id) {
                case 11 -> System.out.println("Salary 20000");
                case 12 -> System.out.println("Salary 30000");
                case 13 -> {
                    System.out.println("Enplyee 13");
                    switch (dept.toLowerCase()) {
                        case "it" -> System.out.println("Salary 9900000");
                        case "marketing" -> System.out.println("Salary 50000");
                        default -> System.out.println("Enter valid dept name");
                    }
                }
                default -> System.out.println("Enter valid id ...");
            }
        }

//        switch (fruitName.toLowerCase()) {
//            case "mango ":
//                System.out.println("King of fruits.. ");
//                break;
//            case "anar":
//                System.out.println("Anar is red savory fruit ....");
//                break;
//            case "kaboob  ":
//                System.out.println("Da afridiano pa fruit ki kaboob khwash yei .. ");
//                break;
//            default:
//                System.out.println("Enter a fruit name dude .... ");
//                break;
//        }
        // so this is the enhanced version of switch statement ...looking much pretty now!
//        switch (fruitName.toLowerCase()) {
//            case "mango " -> System.out.println("King of fruits.. ");
//            case "anar" -> System.out.println("Anar is red savory fruit ....");
//            case "kaboob  " -> System.out.println("Da afridiano pa fruit ki kaboob khwash yei .. ");
//            default -> System.out.println("Enter a fruit name dude .... ");
//        }

        // let do nested switch statement

    }

    
    
}
