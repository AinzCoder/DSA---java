
class ListNode{
    int val;
    ListNode next;

    ListNode(int val){
        this.val=val;
        this.next=null;
    }
}
public class sort_list_linkedlist{
    private static ListNode sortList(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        
        //split the list into 2 halfs 
        ListNode mid=getMid(head);
        ListNode left=sortList(head);//sort the first half
        ListNode right=sortList(mid);// sort the second half

        //merge the sorted half
        return merge(left,right);

    }
    //Function to find the middle of the list
    //using fast ans slow pointer to find the mid
    private static ListNode getMid(ListNode head){
        //here the head and prev acts as both fast and slow pointer
        //fast pointer hops two steps
        //slow pointer hops one step
        //both pointers starts at the same index
        //when fast is null or fast.next is null 
        //slow.next will be the mid
        ListNode prev=null;
        while(head!=null && head.next!=null){
            prev=(prev==null?head:prev.next);
            head=head.next.next;
        }
        ListNode mid = prev.next;
        prev.next=null; // split the list into 2 half
        return mid;
    }
    private static ListNode merge(ListNode list1,ListNode list2){
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while(list1!=null && list2!=null){
            if(list1.val < list2.val){
                tail.next=list1;
                list1=list1.next;
            }
            else{
                tail.next=list2;
                list2=list2.next;
            }
            tail=tail.next;
        }
        //Append the  remaining  node of list1 or list2
        tail.next=(list1!=null)?list1:list2;
        return dummy.next;
    }
    private static void printList(ListNode head){
        ListNode temp = head;
        while(temp !=null){
            System.out.print(temp.val + " -> ");
            temp=temp.next;
        }
        System.out.println("null");
    }

    public static void main(String []args){
        ListNode head = new ListNode(4);
        head.next=new ListNode(2);
        head.next.next=new ListNode(1);
        head.next.next.next=new ListNode(3);

        System.out.println("original list");
        printList(head);

        head=sortList(head);

        System.out.println("Sorted Link");
        printList(head);
    }
}