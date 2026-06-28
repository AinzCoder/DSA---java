// Java’s PriorityQueue is a min heap by default
// means -> Smallest element always comes out first
// The smallest element is always at the top (root)



import java.util.PriorityQueue;


class ListNode{
    int val;
    ListNode next;

    ListNode(int val){
        this.val = val;
        this.next = null;
    }
}
public class Merge_k_sorted_list{
    private static ListNode mergeSorted(ListNode[] lists){

        var minHeap = new PriorityQueue<Integer>();

        // add all values to heap
        for(ListNode list:lists){
            while(list!=null){
                minHeap.add(list.val);
                list=list.next;
            }
        }

        // build result list
        ListNode dummy = new ListNode(1);
        ListNode mergeList = dummy;

        while(!minHeap.isEmpty()){
            mergeList.next=new ListNode(minHeap.remove());
            mergeList=mergeList.next;            
        }
        return dummy.next;
    }
    // helper to print list
    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        // list1: 1 -> 4 -> 5
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        // list2: 1 -> 3 -> 4
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        // list3: 2 -> 6
        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] lists = {l1, l2, l3};

        ListNode result = mergeSorted(lists);
        printList(result);
    }
}