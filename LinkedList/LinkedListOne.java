public class LinkedListOne {
    private Node head = null ; 
    private Node tail = null ;
    private int size = 0;

    class Node{
        int data ; 
        Node next ; 
        public Node(int data){
            this.data = data ; 
            this.next = null;
        }
    }

    public void addListStart(int value){
        Node newNode  = new Node(value);
        newNode.next = head ; 
        head = newNode ;
        if (tail == null) {
            tail = newNode;
        }
        size += 1;
    }

    public void addListEnd(int value){
        Node newNode = new Node(value);
        if (head == null && tail == null) {
            head = newNode ;
            tail = newNode;
        }
        else{
            tail.next = newNode;
            tail = newNode;
        }
        size += 1 ;
    }

    public void InsertInList(int value , int index ){
        if (index < 0 || index > size) {
            System.out.println("Invalid index .. ");
            return ;
        }
        if ( index == 0) {
            addListStart(value);
            size++;
            return ;
        }
        if (index == size - 1) {
            addListEnd(value);
            size++;
            return ;
        }
        Node newNode = new Node(value);

        Node temp = head ;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next ;
        temp.next = newNode;
        size++;
    }
    public Node getNode(int index){
        Node node = head ;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }
    public void DeleteNode(int value){
        if (head.data == value ) {
            head = head.next ;
            size--;
            if(head == null) tail = null;
            return ;
        }
        if (tail.data == value) {
            Node prevNode = getNode(size - 2);
            tail = prevNode ;
            tail.next = null ;
            size--;
            return ;
        }
        Node temp  = head ;
        Node prev = null ;
        while (temp != null) {
            if (temp.data == value) {
                if (prev != null) {
                    prev.next = temp.next ;
                    size--;
                    return ;
                }
            }
            prev = temp ;
            temp = temp.next;
        }
        
    }
    public void printList(){
        Node temp = head ;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next ;
        }
        System.out.println("Null");
    }
   public static void main(String[] args) {
     LinkedListOne list = new LinkedListOne();
     list.addListStart(10);
     list.addListStart(20);
     list.addListStart(30);
     list.addListStart(40);
     list.addListStart(50);
     list.addListStart(60);
     list.printList();
     list.DeleteNode(30);
     list.DeleteNode(60);
     list.DeleteNode(10);
     list.printList();
   }
}
