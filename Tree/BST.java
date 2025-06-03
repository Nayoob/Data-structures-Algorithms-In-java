<<<<<<< HEAD


class BST {
    private class Node {
        private int value;
        private Node left, right;

=======
class BST {
    private class Node {
        private int value;
        private Node left;
        private Node right;
        private int height;
        
>>>>>>> a4a4c75 (Stack&Queue)
        public Node(int val) {
            this.value = val;
            left = right = null;
        }
    }

    private Node root;
   /* since the node class in nested class we can 
    * acces there private members 
    */
<<<<<<< HEAD
=======
    public int height(Node node){
        if(node == null){
            return -1;
        }
        return node.height ; 
    }

>>>>>>> a4a4c75 (Stack&Queue)
    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = insertRec(current.left, value);
        } else if (value > current.value) {
            current.right = insertRec(current.right, value);
        }
<<<<<<< HEAD

        return current;
    }
=======
        current.height = Math.max(height(current.left) , height(current.right)) + 1 ;

        return current;
    }

    /* methdo to check if the tree is balanced  */

    public boolean check(){
        return checkIfBalance(root);
    }

    private boolean checkIfBalance(Node node){
       if(node == null){
          return true ; 
       }
       return Math.abs(height(node.left) - height(node.right)) <= 1 && checkIfBalance(node.left) && checkIfBalance(node.right);
    }


    public void insertThroughArray(int[] nums){
      for (int i = 0; i < nums.length; i++) {
         insert(nums[i]);
      }
    }
    public void display(){
        displayTree(root);
    }
    public void displayTree(Node root){
        if (root == null) {
            return ;
        }
        System.out.println("Node data:" + root.value);
        displayTree(root.left);
        displayTree(root.right);
    }
    public static void main(String[] args) {
        BST tree = new BST();
        int[] array = {10 , 8 ,  12  , 5 , 14  , 9 , 11};
        tree.insertThroughArray(array);
        tree.display();
        tree.check();
    }
>>>>>>> a4a4c75 (Stack&Queue)
}

