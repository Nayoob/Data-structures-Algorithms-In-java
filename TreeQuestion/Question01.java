package TreeQuestion;

public class Question01 {

    class TreeNode{

        private int data ;
        private TreeNode left ;
        private TreeNode right ;
        private int height ;

        public TreeNode(int data){
            this.data = data;
            this.left = right = null;
        }

    }

    private TreeNode rootNode ;

    public  Question01(){
        this.rootNode = null ;
    }

    public void insertNode(int data){

       rootNode = insertWithRec(rootNode , data);

    }

    public TreeNode insertWithRec(TreeNode node , int data){

       if (node == null) 

          return new TreeNode(data);

          if (node.data > data) 
            node.left = insertWithRec(node.left, data);

          else if (node.data < data)
            node.right = insertWithRec(node.right, data);  

          node.height = Math.max(calcHeight(node.left) , calcHeight(node.right)) + 1;

        return node;

    }

    /* my task is to print this tree in level order traveral print tree level by level */

    public void LevelOrderTraversal(){
        levelOrderTraversal(rootNode);
    }

    public void levelOrderTraversal(TreeNode node){
      
        

    }

    public int calcHeight(TreeNode node){
       if (node == null) {
         return -1 ;
       }

       return node.height;
    }


    public  void populate(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            insertNode(arr[i]);
        }
    }

    public void printTree(){
       print(rootNode);
    }

    public void print(TreeNode node){

        if (node == null) {
            return ;
        }
        System.out.println("Node value:" + node.data + " Node height:" +  node.height );
        print(node.left);
        print(node.right);

    }

    public static void main(String[] args) {
        Question01 qs = new Question01();

        int[] arr = {10 , 8 , 12 , 5 , 6 , 4 , 11 , 14 , 13 , 15};

        qs.populate(arr);
        qs.printTree();
         
    }
}
