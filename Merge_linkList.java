class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val=val;
        this.next=null;
    }
}

public class Merge_linkList {
    private static ListNode mergeSort(ListNode num1,ListNode num2){

        ListNode dummy = new ListNode(1);
        ListNode merge = dummy;

        while(num1 != null && num2 != null){
            if(num1.val <= num2.val){
                merge.next=num1;
                num1=num1.next; 
            }
            else{
                merge.next=num2;
                num2=num2.next;
            }
            merge=merge.next;
        }
        if(num1==null){
            merge.next=num2;
        }
        else{
            merge.next=num1;
        }
        return dummy.next;
    }    
    private static void printList(ListNode head){
        ListNode temp = head;
        while(temp!=null){
            System.out.print(temp.val + " -> ");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public static void main(String []args){
        // First sorted list: 1 -> 3 -> 5
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);

        // Second sorted list: 2 -> 4 -> 6
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(6);

        System.out.print("List 1: ");
        printList(l1);

        System.out.print("List 2: ");
        printList(l2);

        ListNode merged = mergeSort(l1, l2);

        System.out.print("Merged List: ");
        printList(merged);

    }

}
