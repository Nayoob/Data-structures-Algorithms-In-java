import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class stack01 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(34);
        stack.push(23);
        stack.push(55);
        stack.push(100);

        // System.out.println(stack.pop());
        
    

        Queue<Integer> que = new LinkedList<>();
        LinkedList<Integer> link = new LinkedList<>();

        que.add(10);
        que.add(20);
        que.add(30);
        que.add(40);
        que.add(50);
        
        System.out.println(que);
        System.out.println(que.poll());

        System.out.println(que);

        System.out.println(que.element());

        System.out.println(que);

        System.out.println(que.offer(30));

        System.out.println(que);

        /* offer -> wont give you exception if Queue is empty rather it will return false 
         * offer will ad item in the Queue 
         * poll -> will through null if the Queue is empty it basicaly returive and remove the head of the 
         * Queue 
         * peek -> will return null if the Queeu is empty it is to retrive the head but not remove it 
         * 
         */

        // System.out.println(que.offer(30));
        // System.out.println(que.offer(20));

        // System.out.println(que.remove());
        // System.out.println(que.remove());

        
        // Deque deq = new ArrayDeque<>();




    }
}
