
import java.util.HashMap;

class Node {
    int val;
    Node next;
    Node random;
    
    public Node(int val){
        this.val = val;
        this.next=null;
        this.random=null;
    }
}

public class Random_pointer_Copy {
     // Map: original node -> copied node

    // hashset keep the old and newly generated copy 
    HashMap<Node, Node> visitedNode = new HashMap<>(); //old → new
    private Node copyRandom(Node head){

        if(head==null){
            return null;
        }

         // If already copied, return it
        if(this.visitedNode.containsKey(head)){
            return this.visitedNode.get(head);
        }

        // Create new node
        Node node = new Node(head.val);
        
         // Store in map
        this.visitedNode.put(head,node);

        // Recursively copy next and random
        //“To build the copy of this node, recursively build copies of its next and random nodes”
        //node goes to next address then goes to random address repeatedly
        node.next = this.copyRandom(head.next);
        node.random = this.copyRandom(head.random);

        // recursion ensures:
        // full deep copy
        // correct random connections

        return node;
    }
    // Helper to print list
    private static void printList(Node head){
        Node temp = head;
        while(temp != null){
            int randomVal = (temp.random != null) ? temp.random.val : -1;
            System.out.println("Node: " + temp.val + 
                               ", Next: " + (temp.next != null ? temp.next.val : "null") +
                               ", Random: " + randomVal);
            temp = temp.next;
        }
    }
    public static void main(String[] args){

        // Create nodes
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);

        // Connect next pointers
        n1.next = n2;
        n2.next = n3;

        // Connect random pointers
        n1.random = n3;  // 1 → 3
        n2.random = n1;  // 2 → 1
        n3.random = n2;  // 3 → 2

        System.out.println("Original List:");
        printList(n1);

        Random_pointer_Copy obj = new Random_pointer_Copy();
        Node copiedHead = obj.copyRandom(n1);

        System.out.println("\nCopied List:");
        printList(copiedHead);
    }
}
