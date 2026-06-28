class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val=val;
        this.next=null;
    }
}

public class add_two_number {
    private static ListNode addTwo(ListNode list1, ListNode list2){
        ListNode dummy = new ListNode(1);
        ListNode ans = dummy;
        int carry = 0;

        while(list1 != null || list2 != null || carry != 0){
            int x = list1!=null ? list1.val : 0;
            int y = list2!=null ? list2.val :0;

            int sum = (carry + x + y);
            // digit from list1 → x
            // digit from list2 → y
            // previous carry → carry
            
            carry = sum / 10;
            // If sum ≥ 10 → carry = 1
            // 👉 Else → carry = 0
            
            ans.next = new ListNode(sum % 10); //We store only the last digit

            ans = ans.next;

            if(list1 != null){
                list1=list1.next;
            }
            if(list2 != null){
                list2 = list2.next;
            }
        }
        return dummy.next;
    }    
    private static void printList(ListNode head){
        while(head != null){
            System.out.print(head.val + " -> ");
            head=head.next;
        }
        System.out.println("null");
    }
    public static void main(String []args){
        
         // List 1: 2 -> 4 -> 3  (represents 342)
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        // List 2: 5 -> 6 -> 4  (represents 465)
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        System.out.print("List 1: ");
        printList(l1);

        System.out.print("List 2: ");
        printList(l2);

        ListNode result = addTwo(l1, l2);

        System.out.print("Sum: ");
        printList(result);
    }
}
