public class customStack {

    private int[] arr ; 
    private static final int DEFAULT_SIZE = 10 ;
    private int pointer = -1 ;

    /* make a constructor */
    public customStack(int size){

        this.arr = new int[size];
    }

    public customStack(){
        this(DEFAULT_SIZE);
    }

    private int[] extendArraySize(int length , int[] prevArr){
      
       int[] newArr = new int[length * 2];
        
       for (int i = 0; i < length; i++) {
          newArr[i] = prevArr[i];
       }
       return newArr;
    }

    public boolean push(int data){
       if (isFull()) {
         arr = extendArraySize(arr.length , arr);
       }
       pointer++;
       arr[pointer] = data;
       return true;
    }

    public int pop(){
        if (isEmpty()) {
            System.out.println("Cant pop from empty stack");
            return -1;
        }
        int remove = arr[pointer];
        arr[pointer] = 0 ;
        pointer = (pointer > -1) ? --pointer : pointer;
        return remove;
    }

    public boolean isEmpty(){
        if (pointer == -1) 
            return true;

            return false;
    }

    public boolean isFull(){
        if (pointer == arr.length - 1) {
            return true;
        }
        return false;
    }

    public int peek(){
        return arr[pointer];
    }

    public void clear(){
       for (int i = 0; i < arr.length; i++) {
          arr[i] = 0;
       }
       pointer = -1 ;
    }

    public int size(){
        return pointer + 1;
    }
    public static void main(String[] args) {
        customStack stack = new customStack(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        stack.push(60);
        stack.push(70);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println(stack.isEmpty());
        System.out.println(stack.size());

        System.out.println(stack.peek());
    }
}
