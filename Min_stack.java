public class Min_stack {

    private Node head; //head is the top of the stack

    //initialize your data structure

    // Constructor
    private Min_stack(){
        head=null; //"The stack is empty initially"
    }

// head                                    
//  ↓                                      
//  (2) → (7) → (3) → (5) → null                                       


    private void push(int val){
        if(head==null){
            head = new Node(val, val, null);
        }
        else{
            head = new Node(val,Math.min(val, head.min), head);
        }
    }

    private void pop(){
        head=head.next;
    }
    private int top(){
        return head.val;
    }
    private int getMin(){
        return head.min;
    }

    private class Node{
        int val;
        int min;
        Node next;
        Node(int val,int min,Node next){
            this.val=val;
            this.min=min;
            this.next=next;
        }
    }
    public static void main(String[] args) {

        Min_stack stack = new Min_stack();

        stack.push(5);
        stack.push(3);
        stack.push(7);
        stack.push(2);

        System.out.println("Top: " + stack.top());      // 2
        System.out.println("Min: " + stack.getMin());   // 2

        stack.pop();

        System.out.println("Top: " + stack.top());      // 7
        System.out.println("Min: " + stack.getMin());   // 3
    }
}
