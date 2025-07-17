package StackAndQueueQuestions;

import java.util.ArrayList;
import java.util.Stack;

public class GameofTwoStack {

    private final int Max_Sum = 10;

    Stack<Integer> stackOne ;
    Stack<Integer> stackTwo ;

    ArrayList<Integer> list = new ArrayList<>();

    public GameofTwoStack(){
        stackOne = new Stack<>();
        stackTwo = new Stack<>();
    }

    public void pushInOne(int data){
        stackOne.push(data);
    }

    public void pushInTwo(int data){
        stackTwo.push(data);
    }

    public int popFromOne(){
        return stackOne.pop();
    }
    
    public int popFromTwo(){
        return stackTwo.pop();
    }
    
    public int Result(){
        ArrayList<Integer> returnedList = Game(list);
        return returnedList.size();
    }
    public ArrayList<Integer> Game(ArrayList<Integer> list){     
        int sum  = 0;
        int popedUpElement ;

        for (int i = 0; i < 4; i++) {
         if (stackOne.peek() < stackTwo.peek()) 
            popedUpElement = stackOne.pop();
        else
            popedUpElement = stackTwo.pop();

         if (sum <= Max_Sum ) 
              sum += popedUpElement;
            else 
               break;    

            list.add(popedUpElement);   
        }  

        return list;
    }
    public static void main(String[] args) {
        
        GameofTwoStack ts = new GameofTwoStack();
        
        ts.pushInOne(5);
        ts.pushInOne(4);
        ts.pushInOne(3);
        ts.pushInOne(2);
        ts.pushInOne(1);

        ts.pushInTwo(9);
        ts.pushInTwo(8);
        ts.pushInTwo(7);
        ts.pushInTwo(6);
        
        /* the final output ?  */
        
        System.out.println(ts.Result());
      
    }
}
