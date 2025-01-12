public class linearsearch {

    public static boolean CheckNumber(int arr[] , int target){
       
        if(arr.length == 0 ){
            System.out.println("Array is empty ..");
            return false ;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
               return true;
            }
        }
        System.out.println("No target found in the given array .");
        return false ;

    }
    public static boolean checkChar(String name , char target){
        if (name.equals(null)) {
            System.out.println("Enter name ..");
            return false ;
        }
        for (int i = 0; i < name.length(); i++) {
            if(name.charAt(i) == target){
                return true ;
            }
        }
        System.out.println("This charachter doesnt exist in the string");

        return false ;
    }
    public static void main(String[] args) {

        // let an array of integer [ 12 , 2, 34 ,5 ,3, 6, 15, 75]
        // Question : Check wherether this specific array contain number 5 ? 
        // we need to make a function for this where we will pass parameter arr[] , and our target which we are seraching !
        int[] arr = { 12 , 2, 34 ,5 ,3, 6, 15, 75 }; 
        System.out.println(linearsearch.CheckNumber(arr, 70));
        
        String name = "Sufyan";
        System.out.println(linearsearch.checkChar(name, 'f'));

    }
}
