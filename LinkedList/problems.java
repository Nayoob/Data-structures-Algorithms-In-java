public class problems {
    private Node head ;
    private Node tail;
    private int size = 0 ; 
    public problems(){
        this.head = null ;
        this.tail = null;
    }

    class Node{
        int data ; 
        Node next ; 
        public Node(int data ){
            this.data = data ;
            this.next = null ;
        }

    }
    public void addNodeEnd(int data){
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode ;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }
   /* lets say if we are asked to write a fucntion which recursively insert the node in the list */
    // Recursive function to insert at a given index
    public Node insertAtIndexRecursive(Node head, int data, int index) {
        // Base case: Insert when index is 0
        if (index == 0) {
            Node newNode = new Node(data);
            newNode.next = head;
            return newNode;
        }
        
        // Recursive case: Move forward in the list
        if (head == null) {
            System.out.println("Index out of bounds");
            return null;
        }
        head.next = insertAtIndexRecursive(head.next, data, index - 1);
        return head;
    }

    // Wrapper function to start recursion from head
    public void insertAtIndex(int data, int index) {
        head = insertAtIndexRecursive(head, data, index);
    }
    public Node InsertAtspecificIndex(Node head , int data , int index){
        if (index == 0) {
            Node newNode = new Node(data);
            newNode.next = head ;
            return newNode;
        }
        if (head == null) {
            System.out.println("Index out of bond");
            return null ;
        }
        head.next = InsertAtspecificIndex(head.next, data, index - 1);
        return head;
    }
    /* lets try to implemet the above code again lets see what will happen */
    public void insertUsinRcursion(int data , int index){
        head = InsertAtspecificIndex(head , data , index);
    }   

    /* lets say if we want to delete node using recursion  */
    public Node deleteUsingrecursion(Node head , int data){
        if (head == null) {
            System.out.println("Out of bond");
            return null;
        }

        if (data == head.data) {
            if (head.next != null) {
                return head.next ;
            }else{
                return null;
            }
        }
        head.next = deleteUsingrecursion(head.next , data);
        return head;
    }
    public void deleteUsingRecursion(int data){
        head = deleteUsingrecursion(head , data);
    }
    public void printList(){
        Node temp = head ;
        while (temp != null) {
            System.out.print(temp.data + " - > ");
            temp = temp.next ;
        }
        System.out.println("Null");
    }
    public static void main(String[] args) {
        problems list = new problems();
        list.addNodeEnd(10);
        list.addNodeEnd(20);
        list.addNodeEnd(30);
        list.addNodeEnd(40);
        list.addNodeEnd(50);
        list.printList();
        list.deleteUsingRecursion(40);
        list.printList();
        list.insertUsinRcursion( 40, 3);
        list.printList();
    }
}
