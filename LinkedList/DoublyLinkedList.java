public class DoublyLinkedList {
    /* lets try to understand the working of doubly linked list its quite like a singly 
     * but here we have one more pointer the prev one lets try to code this one 
     * 
     */
    private Node head ;
    private Node tail ;
    private int size = 0 ;

    class Node{
        int data ;
        Node next ; 
        Node prev ;
        public Node(int data){
            this.data = data ;
            this.next = null ;
            this.prev = null ;
        }
    }

    public DoublyLinkedList(){
        head = null ;
        tail = null ;
    }
   /* so there are many ways to write this fucntion
    * this is one of them we can optimize this too 
    */
    public void addStart(int data){
        Node newNode = new Node(data);
        newNode.next = head ;
        newNode.prev = null ;

        if (head == null) {
            head = newNode;
            if (tail == null) {
                tail = newNode;
            }
            size +=1; 
            return ;
        }
        head.prev = newNode ;
        head = newNode;

        size += 1;
        return ;
    }
    /* cleaner code but doing the same stuff  */
    public void addStartOne(int data){
        Node newNode = new Node(data);
        newNode.next = head ;
        newNode.prev = null ;
        /* if its the first ever node in the list this is how i am going to handle this one  */
        if (head == null) {
            head = tail = newNode;
        }else{
            head.prev = newNode ;
            head = newNode ;
        }
        size += 1;
    }
    /* this is also one of the way to write this function */
    public void  addStartThree(int data){
        Node newNode = new Node(data);
        newNode.next = head ;
        newNode.prev = null ;

        if (head != null) {
            head.prev = newNode;
        }
        head = newNode;
        if (tail == null) {
            tail = newNode;
        }
        size +=1 ;
        return ;
    }
    /* lets say if we have to add node at the end of the list */
    public void addListEnd(int data){
        Node newNode = new Node(data);
        newNode.next = null; 
        newNode.prev = tail ;
        if (tail == null) {
            head = tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
        size++;

    }
    /* lets try to insert Node at a random position in doubly linked list */
    public void InsertInList(int data , int position){
       if (head == null) {
         System.out.println("List is empty ");
         return ;
       }
       if (position == 0) {
         addStartThree(data);
         return ;
       }
       if (position == size - 1) {
         addListEnd(data);
         return ;
       }
        Node newNode = new Node(data);
        Node temp = head ;
        for (int i = 0; i < position - 1 ; i++) {
            temp = temp.next ;
        }
        
        newNode.next = temp.next ;
        if (temp.next != null) {  
            temp.next.prev = newNode;
        }
        temp.next = newNode;
        newNode.prev = temp ;
        size++;
    }
    public void DeleteNode(int value){

        if (head.data == value ) {
            if (head.next == null) {
                head = null ;
                tail = null;
            }
            head = head.next ;
            head.prev = null;
            size -= 1;
            return ;
        }
        if (tail.data == value) {
            if (tail.prev != null) {
                tail = tail.prev;
                tail.next = null;
            } else {  
                head = null;
                tail = null;
            }
            size--;
            return;
        }
        Node temp = head ;
        while (temp != null) {
            if (temp.data == value) {
              temp.next.prev = temp.prev ;
              temp.prev.next = temp.next ;
             
            }
            temp = temp.next ;
        }
        size -= 1;
        return;
    }
    

    public void printList(){
        Node temp = head ;
        System.out.print("Null" + " - > ");
        while (temp != null) {
            System.out.print(temp.data + " - > ");
            temp = temp.next ;
        }
        System.out.println("Null");
    }

    /* lets try to print the linked list in reverse order  */
    public void printListreverse(){
        Node temp = tail ;
        while (temp != null) {
            System.out.print(temp.data + " - > ");
            temp = temp.prev ;
        }
        System.out.println("Null");
    }
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.addStart(50);
        list.addStart(40);
        list.addStart(30);
        list.addStart(20);
        list.addStart(10);
        list.addStart(100);
        list.printList();
        System.out.println(list.size);
        System.out.println("After Insertion to the end of the list");
        list.addListEnd(60);
        list.addListEnd(70);
        list.printList();
        System.out.println(list.size);


        System.out.println("After Insertion : ");
        list.InsertInList(500, 7);
        list.printList();
        System.out.println(list.size);
       // list.printListreverse();

        System.out.println("After deleting 20 :");

        list.DeleteNode(20);
        list.printList();
        System.out.println(list.size);
    }
}
