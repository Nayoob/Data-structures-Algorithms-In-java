public class RecursionlevelThree {
    /* just for understanding lets try to print right angle triangle first  */
    public static void rightAngle(int n){
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void upsidedown(int n){
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        RecursionlevelThree.rightAngle(10);
        RecursionlevelThree.upsidedown(10);
    }
}
