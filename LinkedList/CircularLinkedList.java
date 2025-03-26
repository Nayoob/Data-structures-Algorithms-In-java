public class CircularLinkedList {

    /* lets try to implement circular linked list  */
    private Node head ;
    private Node tail ;
    private int size = 0;

    class Node{
        int data ;
        Node next ;
      
        public Node(int data){
            this.data = data ;  
            this.next = null ;
       
        }
    }
    public CircularLinkedList(){
        this.head = null ;
        this.tail = null ;
    }
    public void addNode(int data ){
        Node newnode = new Node(data);
        /* if the head is null means we are inserting the first ever node in cll  */
        if (head == null ) {
            head = newnode;
            tail = newnode;
            tail.next = head ;
        }else{
            tail.next = newnode ;
            tail = newnode;
            newnode.next = head ;
        }

        size++;
    }
    public void insertNode(int data , int position){
        if (head == null|| tail == null) {
            System.out.println("List is empty ");
            return ;
        }
        if (position == 1 ) {
            Node newNode = new Node(data);
            newNode.next = head ;
            head = newNode ;
            tail.next = newNode ;
            size += 1 ;
            return ;
        }
        if (position == size ) {
            Node newNode = new Node(data);
            tail.next = newNode ;
            newNode.next = head ;
            tail = newNode ;
            size +=1 ;
            return ;
        }
        Node newNode = new Node(data);
        Node current = head;
        for (int i = 1; i < position - 1; i++) {
           current = current.next ;
        }
        
        newNode.next = current.next ;
        current.next = newNode;
        size++ ;

    }

    public void DeleteNode(int value){
        if (head == null ) {
            System.out.println("List is empty ");
            return ;
        }
        if (head.data == value) {
            head = head.next ;
            if (head.next == null) {
                head = null ;
                tail = null ;
                return ;
            }
            tail.next = head ;
            size -=1 ;
            return ;
        }
        if (tail.data == value) {
            Node getPrev = getprevNode(size - 2);
            getPrev.next = tail.next ;
            tail = getPrev;
            size--;
            return ;
        }
        /* lets say the node that we are trying to delete from a list is not on the 
         * head nor tail its somewhere in the mid of the listt 
         */
        Node temp = head ;
        Node prev = null ;
        while (temp != tail ) {
            if (temp.data == value) {
                if (prev != null) {
                   prev.next = temp.next;
                   size  -= 1 ;
                   return ;
                }
            }
            prev = temp ;
            temp = temp.next ;
        }
    }
    public Node  getprevNode(int size){
        Node temp = head ;
        for (int i = 0; i < size ; i++) {
            temp = temp.next ;
        }
        return temp ;
    }
    public void Printlist(){
        Node temp = head ;
        do {
           System.out.print(temp.data + " - > ");
           temp = temp.next ;
        } while (temp != head);
        System.out.println("head");
     
    }

    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        list.addNode(10);
        list.addNode(20);
        list.addNode(30);
        list.addNode(40);
        list.addNode(50);
        list.Printlist();
        System.out.println(list.tail.next.data);
        System.out.println(list.size);

        System.out.println("After insertion :");
        list.insertNode(100, 3);
        System.out.println("Head -> " + list.tail.next.data);
        System.out.println("Size -> " + list.size);
        list.Printlist();

        System.out.println("After deletion :");
        list.DeleteNode(100);
        list.Printlist();
        System.out.println("Head -> " + list.tail.next.data);
        System.out.println(list.size);
        System.out.println(list.head.data);
    }
}
