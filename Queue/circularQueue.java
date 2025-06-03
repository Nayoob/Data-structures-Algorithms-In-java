package Queue;

public class circularQueue {
    private int[] circularArr ;
    private static final int DEFAULT_SIZE = 10;

    private int startPtr ;
    private int endPtr ;
    private int size ;
    
    public circularQueue(){
        this(DEFAULT_SIZE);
    }

    public circularQueue(int size){
        this.circularArr = new int[size];
        this.startPtr = 0;
        this.endPtr = 0;
        this.size = 0;
    }

    public boolean isFull(){
        return size == circularArr.length ;
    }

    public boolean isEmpty(){
        return startPtr == 0;
    }

    public void offer(int data) throws Exception{

        if (isFull()) {
            throw new Exception("Queue is full");
        }
        circularArr[endPtr++] = data;
        endPtr = endPtr % circularArr.length; 
        size ++;

    }
    
    public int poll() throws Exception{
        if (isEmpty()) {
            throw new Exception("Queue is Empty");
        }
        int toRemove = circularArr[startPtr++];
        startPtr = startPtr % circularArr.length;
        size--;
        return toRemove;
    }

    public int peek() throws Exception{
        if (isEmpty()) {
            throw new Exception("Queue is Empty");
        }
        return circularArr[startPtr];
    }

    public static void main(String[] args) throws Exception {
        circularQueue qu = new circularQueue();
        qu.offer(10);
        qu.offer(20);
    }
}
