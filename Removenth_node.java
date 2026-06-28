class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val=val;
        this.next=null;
    }
}

public class Removenth_node {
    private static ListNode reverseNthDeletion(ListNode head,int n){
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        //
        ListNode front = dummy;
        ListNode back = dummy;

        // move front to n+1 steps ahead
        for(int i=0;i<=n;i++){
            front=front.next;
        }

        //move both pointer unit front reaches end
        while(front != null){
            front = front.next;
            back = back.next;
        }

        //delete node
        back.next=back.next.next;

        return dummy.next;
    }    
    private static void printList(ListNode head){

        while(head!=null){
            System.out.print(head.val + " -> ");
            head=head.next;
        }
        System.out.println("null");
    }
    public static void main(String []args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.print("Original: ");
        printList(head);

        int n = 2; // remove 2nd node from end (node 4)

        head = reverseNthDeletion(head, n);

        System.out.print("After deletion: ");
        printList(head);
    }
}
