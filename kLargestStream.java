import java.util.PriorityQueue;

public class kLargestStream {
    private PriorityQueue<Integer> minHeap;
    private int k;

    public kLargestStream(int[] nums,int k){
        this.k=k;
        this.minHeap= new PriorityQueue<>(k); //min heap with the capacity of k

        //Add internal elements to the minheap
        for(int num:nums){
            add(num);
        }
    }

    private int add(int val){
        if(minHeap.size()<k){
            minHeap.offer(val);
        }else if(val > minHeap.peek()){
            minHeap.poll(); //remove the samllest element
            minHeap.offer(val); //Add the new element
        }
        return minHeap.peek(); //returns the kth largest element
    }
    public static void main(String []args){
        int[] nums={4,3,2,5,6,7};
        int k=2;
        kLargestStream stream = new kLargestStream(nums, k);

        System.out.println("Kth largest: "+stream.add(8));
        System.out.println("Kth largest: "+stream.add(1));
        System.out.println("Kth largest: "+stream.add(10));
        
    }
}
