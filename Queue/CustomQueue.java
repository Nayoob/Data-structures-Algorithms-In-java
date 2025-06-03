package Queue;

import java.io.EOFException;

import javax.xml.crypto.dsig.spec.ExcC14NParameterSpec;

public class CustomQueue {

    /* lets try to build custom Queue using with two pointers with array first */
    private int[] array ; 
    private static final int DEFAULT_SIZE = 10;

    private int startPtr ;
    private int endPtr;
    
    public CustomQueue(){
        this(DEFAULT_SIZE);
    }

    public CustomQueue(int size){
        this.array = new int[size];
        this.startPtr = 0;
        this.endPtr = 0;
    }

    public void offer(int value) throws Exception{

       if (isFull()) {
          throw new Exception("Queue is full");
       }
       array[endPtr] = value;
       endPtr++;

    }
    
    public boolean isFull(){
        return endPtr == array.length;
    }


    public boolean isEmpty(){
        return startPtr == endPtr;
    }

    public int poll() throws Exception{

       if (isEmpty()) {
           throw new Exception("Queue is Empty nothing to return");
       }

       int itemToRemove = array[startPtr];

       for (int i = 0; i < endPtr; i++) {
          array[i] = array[i+1];
       }
       endPtr--;

       return itemToRemove;
    }

    public int peek(){
       if (isEmpty()) {
        return -1;
       }
       return array[startPtr];
    }


    public int endPtrValue(){
        return array[endPtr - 1 ];
    }

    public void printQueue(){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " -> ");
        }
        System.out.println("0");
    }
    public static void main(String[] args) throws Exception {
        CustomQueue queue = new CustomQueue();

        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        queue.offer(40);
        queue.offer(50);
        queue.offer(60);
        queue.offer(30);
        queue.offer(40);
        queue.offer(50);
        queue.offer(50);
       
        
        queue.printQueue();
        System.out.println("Start:" + queue.peek());
        System.out.println( "End:" + queue.endPtrValue());

        System.out.println("_________________");

        // System.out.println(queue.poll());
        // System.out.println(queue.poll());
        // System.out.println(queue.poll());

        queue.printQueue();
        System.out.println("Start:" + queue.peek());
        System.out.println( "End:" + queue.endPtrValue());


        System.out.println("___________________");
        
        System.out.println(queue.isEmpty());
        System.out.println(queue.isFull());

        // System.out.println(queue.poll());
        // System.out.println(queue.poll());
        // System.out.println(queue.poll());


        System.out.println(queue.isEmpty());
        System.out.println(queue.isFull());

    }
}
