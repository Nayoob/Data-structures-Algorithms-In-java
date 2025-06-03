package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class Queue01 {
    public static void main(String[] args) {
        Queue<Integer> newQue = new LinkedList<>();
        newQue.offer(10);
        newQue.offer(20);
        newQue.offer(30);
        newQue.offer(40);
        newQue.offer(50);

        System.out.println(newQue.peek());
        System.out.println(newQue.element());

        
        System.out.println(newQue.poll());
        System.out.println(newQue.poll());
        System.out.println(newQue.poll());

        System.out.println(newQue.peek());
        System.out.println(newQue);

    }
}
