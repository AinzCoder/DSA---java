class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val=val;
        this.next=null;
    }
}

public class linked_reverse{
    private static ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;

        // iterate over the current linked list
        while(curr!=null){
            // flip the values between the current and previous

            ListNode temp = curr.next;  // save forward
            curr.next= prev;     // reverse link
            prev=curr;  // move prev //Move the "previous pointer" one step forward
            curr=temp;  // move curr
        }
        return prev;
    }
    private static void printList(ListNode head){
        ListNode temp = head;
        while(temp!=null){
            System.out.print(temp.val + " -> " );
            temp=temp.next;
        }
        System.out.println(" null");
    }
    public static void main(String []args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        System.out.println("Original List");
        printList(head);

        head= reverseList(head);
        System.out.println("Reversed list");
        printList(head);
    }
}