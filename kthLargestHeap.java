import java.util.PriorityQueue;

public class kthLargestHeap {

    // Always insert first Then remove extra element
    private static int findK(int[] nums,int k){
        var minHeap = new PriorityQueue<Integer>();

        for(int num:nums){
            minHeap.add(num);
            if(minHeap.size()>k){
                minHeap.poll(); //remove the smallest element to maintain  the heap size as k
            }
        }
        return minHeap.peek();//the root of the minheap is the kth largest element
    }
    // Insert everything blindly Remove extra smallest elements

    //================================== OR ===================================================

    // Only insert useful elements
    private static int kth(int[] num,int k){
        var minheap = new PriorityQueue<Integer>();
        for(int i=0;i<num.length;i++){
            if(minheap.size()<k){
                minheap.add(num[i]);
            }else if(minheap.peek()<num[i]){
                minheap.remove();
                minheap.add(num[i]);
            }
        }
        return minheap.peek();
    }
    public static void main(String []args){
        int[] num={7,5,3,2,5,4};
        int k=3;
        int result = findK(num, k);
        System.out.println(result);
    }
    
}
