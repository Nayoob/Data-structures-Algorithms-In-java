package StackAndQueueQuestions;

import java.util.Stack;

public class Questions01 {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> helperStack = new Stack<>();

    public void offer(int data){
        if (data == 0 ) {
            return;
        }
        stack.push(data);
    }
    
    public int poll(){

        while (!stack.isEmpty()) {
            int data = stack.pop();
            helperStack.push(data);
        }

        int frontValue  =  helperStack.pop();

        while (!helperStack.isEmpty()) {
            int data = helperStack.pop();
            stack.push(data);
        }
        return frontValue;
    }

    public int peek(){

        while (!stack.isEmpty()) {
            int data = stack.pop();
            helperStack.push(data);
        }

        int peekValue  =  helperStack.peek();

        while (!helperStack.isEmpty()) {
            int data = helperStack.pop();
            stack.push(data);
        }
        return peekValue;
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        Questions01 ss = new Questions01();
        ss.offer(10);
        ss.offer(20);
        ss.offer(30);
        ss.offer(40);
        ss.offer(50);
        
        System.out.println(ss.poll());
        System.out.println(ss.poll());
        System.out.println(ss.poll());     
        
        System.out.println(ss.peek());

        
    }
}
