import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

// Deque can act as a stack
// Use Deque instead of Stack

// ArrayDeque is very fast
// Deque is the modern, faster replacement for Stack in Java

// old + synchronized + slower -> stack

public class ImplementQueueUsingStack {
//Double ended queues to implement instack and outstack
    private Deque<Integer> inStack;
    private Deque<Integer> outStack;

    public ImplementQueueUsingStack(){
        inStack= new ArrayDeque<>();
        outStack= new ArrayDeque<>();
    }

    //Enqueue O(1)
    private void push(int num){
        inStack.push(num);
    }
    
    //Dequeue O(1)
    private int pop(){
        moveIfNeeded();
        return outStack.pop();
    }

    //peek front
    private int peek(){
        moveIfNeeded();
        return outStack.peek();
    }

    //check empty    
    private boolean isEmpty(){
        return inStack.isEmpty() && outStack.isEmpty();
    }

    //moves element when outstack is empty
    private void moveIfNeeded(){
        if(outStack.isEmpty()){
            while(!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
    }
    public static void main(String []args){
       ImplementQueueUsingStack queue = new ImplementQueueUsingStack();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of elements: ");
        int n = scan.nextInt();

        System.out.println("Enter the elements: ");

        for(int i=0;i<n;i++){
            int val = scan.nextInt();

            queue.push(val);
        }
        System.out.println("Deleted: "+queue.pop());
        System.out.println("Front: "+queue.peek());
        System.out.println("isEmpty: "+queue.isEmpty());
        scan.close();
    }
    
}
