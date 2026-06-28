class ListNode {
    int val;
    ListNode next;
    ListNode(int val){
        this.val=val;
        this.next=null;
    }
}

public class Record_list{
    private static void orderedList(ListNode head){
        if(head == null){
            return;
        }

        //find middle element to reverse the list
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow=slow.next;
            fast=fast.next.next;
        }

        // reverse list
        ListNode prev = null;
        ListNode curr = slow.next;
        slow.next=null; // Now the list is split into TWO independent parts:
        ListNode temp;
        //or 
        // ListNode prev =null ,curr=slow, temp;
        while(curr!=null){
            temp = curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }

        //merge list
        ListNode first = head;
        ListNode sec = prev;
        while(sec !=null){
            ListNode temp1 = first.next;
            first.next=sec;
            first=temp1;

            ListNode temp2 = sec.next;
            sec.next=first;
            sec=temp2;
        }

    }
    private static void printList(ListNode head){
        while(head != null){
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
    public static void main(String []args){

        // Create list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.print("Original: ");
        printList(head);

        orderedList(head);

        System.out.print("Reordered: ");
        printList(head);
    }
}