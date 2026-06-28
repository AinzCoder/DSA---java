class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val=val;
        this.next=null;
    }
}

public class Linked_cycle {
    private static boolean hasCycle(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;

        while(slow !=null && fast != null){
            if(fast.next ==null ){
                return false;
            }

            if(fast == slow){
                return true;
            }

            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }    
    public static void main(String []args){
        // Create nodes
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        // 🔹 Case 1: No cycle
        System.out.println("Has cycle: " + hasCycle(head)); // false

        // 🔹 Case 2: Create cycle (4 -> 2)
        head.next.next.next.next = head.next;

        System.out.println("Has cycle: " + hasCycle(head)); // true

    }
}
