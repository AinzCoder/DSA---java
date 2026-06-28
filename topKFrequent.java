import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class topKFrequent {
    public static int[] topK(int[] num,int k){
        if(k==num.length){
            return num;
        }
        Map<Integer,Integer> count = new HashMap<>();
        //count each number
        for(int n:num){
            //Get the current count of n (or 0 if it doesn’t exist), add 1, and store it back in the map
            count.put(n,count.getOrDefault(n,0) +1);//getOrDefault-->Give me the value mapped to n.
            // If n is not present in the map, return 0.
        }
        //min-heap based on frequency
        Queue<Integer> heap = new PriorityQueue<>(//inside priorityQueue assing the method of insertiton
            //based on number of occurences and count hashmap
            //its lambda expression
            (a,b) -> count.get(a) - count.get(b));//This line orders the PriorityQueue so that elements with smaller frequency come first.
            //Negative value → a has higher priority (comes first)
            //Positive value → b has higher priority
            //Zero → equal priority
            //So this creates a MIN-HEAP based on frequency.
        //add number into heap;
        for(int n:count.keySet()){//keySet() -->Gives all keys in the map.
            heap.add(n);
            if(heap.size()>k){
                //Remove and return the smallest element from the priority queue
                heap.poll();//returns 1 and removes it

            }
        }
        int[] ans = new int[k];
        for(int i=0;i<k;i++){
            ans[i]=heap.poll();//remove samllest frequency or occurance
        }
        return ans;
    }
    public static void main(String []args){
        int num[]={1,1,1,2,5,5,5,1,7};
        int k=3;
        int[] output = topK(num,k);
        System.out.println(Arrays.toString(output));
    }
    
}
