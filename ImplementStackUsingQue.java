import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ImplementStackUsingQue {
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public ImplementStackUsingQue(){
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    //push element x onto the stack
    private void push(int x){
        // step1: Add to q2
        // offer()-> insert element into queue remove ite returns null instead of an exception 
        q2.offer(x);

        //step2: move everything from q1 to q2
        while(!q1.isEmpty()){
            q2.offer(q1.poll()); //poll() -> remove front element it returns null instead of an exception
        }

        //step3: swap q1 and q2
        Queue<Integer> temp = q1;
        q1=q2;
        q2=temp;
    }

    //removes the element from the top of the stack
    private int pop(){
        return q1.poll();
    }

    private int peek(){
        return q1.peek();
    }

    private boolean Empty(){
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        ImplementStackUsingQue stack = new ImplementStackUsingQue();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of elements: ");
        int n = scan.nextInt();

        System.out.println("Enter the elements: ");
        for(int i=0;i<n;i++){
            int val = scan.nextInt();
            stack.push(val);
        }

        System.out.println("Deleted: "+stack.pop());
        System.out.println("Peek: "+stack.peek());
        System.out.println("Empty: "+stack.Empty());
        scan.close();
    }
    
}
