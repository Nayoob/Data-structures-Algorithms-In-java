package Queue;

import java.util.concurrent.ExecutionException;

public class CustomQueueSinglePtr {

    private int[] arr ; 
    private static final int DEFAULT_SIZE = 10  ;
    private int endPtr ;
   
    public CustomQueueSinglePtr(int size){
        this.arr = new int[size];
        this.endPtr = 0;
    }

    public CustomQueueSinglePtr(){
        this(DEFAULT_SIZE);
    }
    public boolean isFull(){
        return endPtr == arr.length;
    }

    public boolean isEmpty(){
        return endPtr == 0;
    }

    public void offer(int data) throws Exception{
        if (isFull()) {
            throw new Exception("Queue is full ");
        }
        arr[endPtr] = data;
        endPtr++;
    }

    public int poll() throws Exception{
        if (isEmpty()) {
            throw new Exception("Queue is Empty");
        }
        int toRemove = arr[0];

        for (int i = 1; i < endPtr; i++) {
            arr[i-1] = arr[i];
        }
        endPtr--;
        return toRemove;
    }

    public int peek() throws Exception{
        if (isEmpty()) {
            throw new Exception("Queue is empty");
        }
        return arr[0];
    }

    public void displayQueue(){
        for (int i = 0; i < endPtr; i++) {
            System.out.print(arr[i] + "->");
        }
        System.out.println("0");
    }

    public static void main(String[] args) {
        
    }

}
