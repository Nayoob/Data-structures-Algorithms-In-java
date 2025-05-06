import java.util.Scanner;

public class BinaryTree{

    private class Node {
        int data ;
        Node left ;
        Node right ;
        public Node(int data){
            this.data = data ;
            this.left = null;
            this.right = null;
        }
    }
    private static Node rootNode  ;

    public void insertion(Node node , Scanner scanner){
        System.out.println("Do you want to Insert in left of " + node.data);
        boolean left = scanner.nextBoolean();
        if (left) {
            System.out.println("Enter the value:");
            int value = scanner.nextInt();
            node.left = new Node(value);
            insertion(node.left , scanner);
        }
        System.out.println("Do you want to Insert in right of : " + node.data);
        boolean right = scanner.nextBoolean();
        if (right) {
            System.out.println("Enter the value:");
            int value = scanner.nextInt();
            node.right = new Node(value);
            insertion(node.right, scanner);
        }

    }
    public void addRootNode(Scanner scanner){
            System.out.println("Enter value of root Node :");
            int value = scanner.nextInt();
            rootNode = new Node(value);
            insertion(rootNode , scanner);

    }
    public void displayBinaryTree(Node node){
        if(node == null){
            return ;
        }
        System.out.println(node.data + " ");
        displayBinaryTree(node.left);
        displayBinaryTree(node.right);

    }
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Scanner scanner = new Scanner(System.in);
        tree.addRootNode(scanner);
        tree.displayBinaryTree(BinaryTree.rootNode);

    }
    
}
