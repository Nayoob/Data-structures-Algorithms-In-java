
import java.util.Scanner ;

public class Introduction {
    public static void main(String[] args) {
        // let start learning data structure in java and code this shit out
        //  System.out.println("hello" + args[0] + " how are you ? ");  // so we can pass values to string array from
        // command line during execution the code ..
//        int num1 = Integer.parseInt(args[0]);
//        int num2 = Integer.parseInt(args[1]);
//
//        int sum = num1 + num2 ;
//        System.out.println("the sum of" + args[0] + " and " +  args[1] + " is " +sum);
//
        Scanner s1 = new Scanner(System.in);
        System.out.println("Enter you first name");
        String firstname= s1.nextLine();
        System.out.println("Enter your last name");
        String lastname = s1.nextLine();

        System.out.println("Enter your age");
        int age = s1.nextInt();

        System.out.println("First name : " + firstname );
        System.out.println("Last name : " + lastname);
        System.out.println("age" + age);
        s1.close();
    }
}
