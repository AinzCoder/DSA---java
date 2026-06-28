class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val=val;
        this.next=null;
    }
}

public class Middle_linkList {
    private static ListNode middleElement(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    public static void main(String []args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next= new ListNode(3);

        ListNode middle = middleElement(head);
        System.out.println(middle.val);
    }
    
}
