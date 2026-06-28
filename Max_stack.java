import java.util.*;

public class Max_stack{
    private final Stack<Integer> stack;
    private final Stack<Integer> maxStack;

    public Max_stack(){
        stack = new Stack<>();
        maxStack = new Stack<>();
    }
    // pushing the element in both the places as stack and maxStack
    public void push(int x){
        int max = maxStack.isEmpty()? x : Math.max(maxStack.peek(),x);
        stack.push(x);
        maxStack.push(max);
    }

    //pop elements from both the places
    public int pop(){
        maxStack.pop();
        return stack.pop();
    }
    public int top(){
        return stack.peek();
    }
    public int peekMax(){
        return maxStack.peek();
    }
    //value to kick out is present in the middle of the stack so we push every single element from normal stack to buffer unti we

    //find top element to reach to the max, then we simple pop that element out from stack at the same we are pop the same element 
    //from the maxStack as well, then inside the buffer we are going to push all of the buffer element to stack
    public int popMax(){
        int max=peekMax();
        Stack<Integer> buffer = new Stack<>();
        while(top() != max){
            buffer.push(pop());
        }
        pop(); //remove max elements
        while(!buffer.isEmpty()){
            push(buffer.pop());
        }
        return max;
    }

    public static void main(String []args){
        Max_stack stack = new Max_stack();
        stack.push(1);
        stack.push(6);
        stack.push(3);
        stack.push(7);

        System.out.println(stack.top());
        System.out.println(stack.peekMax());
        stack.popMax();
        stack.pop();
        System.out.println(stack.peekMax());

    }
}