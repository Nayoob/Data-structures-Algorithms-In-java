import java.util.Arrays;

class function {
     
        
    public static void variablelengthargument(int ...va){
        System.out.println(Arrays.toString(va));
    }

 /*    public static void changeName(String name ){
        name = "jabbar";
        System.out.println("Name changed to" + name); */

    public static void main(String[] args) {

        // so function take two types of arguments 
        // 1. pass by value 
        // 2. pass by reference 

        // but java only accept pass by value there is no concept of pass by reference in java 

     /*    String naam = "Sufyan"; 
        function.changeName(naam);
        System.out.println(naam);  */
   
        // lets do some thing called vaiable length arguments // 
       
        variablelengthargument(2,2,2,3,4,2,1,4,5,2,4,5,3,2,2);
            
       
     }
}
