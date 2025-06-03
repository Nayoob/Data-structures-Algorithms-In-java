class segmentTree{

    class Node{
        private int data;
        private Node left;
        private Node right;
        private int startInterval;
        private int endInterval;

        public Node(int startInterval , int endInterval){
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }

    }
    private Node rootNode;

    public segmentTree(int[] arr ){
        rootNode = constructTree(arr , 0 , arr.length - 1);
    }

    private Node constructTree(int[] arr , int startInterval , int endInterval ){
       
        Node node = new Node(startInterval, endInterval);

        if (startInterval == endInterval) {
            node.data = arr[startInterval];
            return node;
        }

        int mid = (startInterval + endInterval) / 2;

        node.left = constructTree(arr, startInterval , mid);
        node.right =  constructTree(arr, mid + 1 , endInterval);
        
        node.data = node.left.data + node.right.data;

        return node;
    }

    public void getsum(int startindex , int endindex){
        int sum =  getSum(rootNode , startindex , endindex);
        System.out.println("sum between index" + startindex + " and " + endindex + " is: " + sum);
    }


    private int getSum(Node node , int start , int end){
        /* if node interval is out of Query interval  */ 
        if (node.endInterval < start || node.startInterval > end) {
           return 0;
        }

        if (node.startInterval >= start && node.endInterval <= end) {
            return node.data;
        }
        
        int leftsum = getSum(node.left, start, end);
        int rightsum = getSum(node.right, start, end);


        return leftsum + rightsum;

    }
    
    /* update the node value with O(logN) time complexity  */
    public void updateValue(int index , int value ){
       this.rootNode.data = updateHelper(rootNode, index, value);
    }

    public int updateHelper(Node node , int index , int value){

        if (index >= node.startInterval && index <= node.endInterval) {
            if (index == node.startInterval && index == node.endInterval) {
                node.data = value;
                return node.data;
            }
            else{
                int left = updateHelper(node.left, index, value);
                int right = updateHelper(node.right, index, value);
                node.data = left + right ;
                return node.data;
            }
        }

        return node.data;

    }

    public void printSum(){
        print(rootNode);
    }

    private void print(Node node){
       if (node == null) {
        return ;
       }
       System.out.println(node.data);
       print(node.left);
       print(node.right);
    }


    public static void main(String[] args) {
        int[] arr = {3 , 8 , 7 , 6 , -2 , -8 , 4, 9};

        segmentTree tree = new segmentTree(arr);
        tree.printSum();

    }
}
