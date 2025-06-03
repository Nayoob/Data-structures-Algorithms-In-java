class avl{
    private class Node{
        private int value;
        private Node left ;
        private Node right;
        private int height;
        public Node(int value){
            this.value = value ;
            left = right = null ;

        }

    }
    private Node rootNode ;

    public int height(Node node){
       if (node == null) {
        return -1;
       }
       return node.height;
    }
    public boolean checkBalance(){
        return checkifBalance(rootNode);
    }

    public boolean checkifBalance(Node RootNode){
      if (RootNode == null) {
        return true;
      }
      return Math.abs(height(RootNode.left) - height(RootNode.right)) <= 1 && checkifBalance(RootNode.left) && checkifBalance(RootNode.right);
    }

    public void insert(int value){
      rootNode = insertRec(value , rootNode);
    }
    public Node insertRec(int data , Node root){
         if (root == null) {
            return new Node(data);
         }
         if (root.value > data) {
            root.left = insertRec(data, root.left);
         }
         else if(root.value < data){
            root.right = insertRec(data, root.right);
         }

         root.height = Math.max(height(root.left) , height(root.right)) + 1;

         return Rotate(root) ;
    }

    private  Node Rotate(Node node){
       //check if the tree is left heavy //
       if (height(node.left) - height(node.right) > 1) {
        // tree is left heavy 
        if (height(node.left.left) - height(node.left.right) > 0 ) {
            return rightRotate(node);
        }
        if (height(node.left.left) - height(node.left.right) < 0) {
            node.left = leftRotate(node.left);
            Node finalNode = rightRotate(node);
            return finalNode; 
        }
       }

       if (height(node.left) - height(node.right) < -1) {
        // tree is right heavy 
        if (height(node.right.left) - height(node.right.right) < 0 ) {
            return leftRotate(node);
        }
        if (height(node.right.left) - height(node.right.right) > 0) {
            node.right = rightRotate(node.left);
            Node finalNode = leftRotate(node);
            return finalNode; 
        }
       }
        return node;
    }
    private Node rightRotate(Node p) {
    Node c = p.left;
    Node t = c.right;

    c.right = p;
    p.left = t;
    
    p.height = Math.max(height(p.left), height(p.right) + 1);
    c.height = Math.max(height(c.left), height(c.right) + 1);

    return c;
  }

  private Node leftRotate(Node c) {
    Node p = c.right;
    Node t = p.left;

    p.left = c;
    c.right = t;
    
    p.height = Math.max(height(p.left), height(p.right) + 1);
    c.height = Math.max(height(c.left), height(c.right) + 1);
    
    return p;
  }
  
    public void displayTree(){
        display(rootNode);
    }
    public void papulate(int[] arr){
      for (int i = 0; i < arr.length; i++) {
         insert(i);
      }
    }
    public void display(Node node){
        if (node == null) {
            return ;
        }
        System.out.println(node.value);
        display(node.left);
        display(node.right);
    }


}