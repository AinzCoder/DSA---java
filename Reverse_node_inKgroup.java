public class Reverse_node_inKgroup {

    private static ListNode reverseGroup(ListNode head,int k){
        ListNode ptr = head;
        ListNode ktail = null; //it points to last node after reversing 
        ListNode newHead = null;

        while(ptr != null){
            int count=0;
            ptr=head;

            while(count < k && ptr!=null){
                ptr=ptr.next;
                count++;
            }
            if(count==k){
                ListNode revHead = reverseNode(head,k); // since the head is reversed the second node will be the new head

                if(newHead == null){
                    newHead = revHead;
                }
                if(ktail != null){
                    ktail.next = revHead;
                }
                ktail = head;
                head = ptr;
            }
        }
        if(ktail != null){
            ktail.next=head;
        }
        return newHead==null?head:newHead;
    }

    private static ListNode reverseNode(ListNode head,int k){
        ListNode newHead = null;
        ListNode ptr=head;

        while(k>0){
            ListNode nextNode = ptr.next;
            ptr.next=newHead;
            newHead = ptr;
            ptr = nextNode;
            k--;
        }
        return newHead;
    }
    private static void printList(ListNode head){
        while(head!=null){
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
    public static void main(String []args){
        int k=2;
        ListNode head = new ListNode(1);
        head.next=new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        head = reverseGroup(head, k);
        printList(head);
    }
    
}
