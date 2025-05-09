

class BST {
    private class Node {
        private int value;
        private Node left, right;

        public Node(int val) {
            this.value = val;
            left = right = null;
        }
    }

    private Node root;
   /* since the node class in nested class we can 
    * acces there private members 
    */
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

        return current;
    }
}

