import java.util.PriorityQueue;

public class lastStoneWeight {
    private static int lastStone(int[] stone){
        //create max-heap
        var maxheap = new PriorityQueue<Integer>((a,b) -> b-a); //b-a to get the max values

        //add all stones into the heap
        for(int stones: stone){
            maxheap.add(stones);
        }

        //Continue removing and smash the two heaviest stones
        while(maxheap.size()>1){
            int x = maxheap.poll();//heaviest
            int y = maxheap.poll();//second heaviest

            if(x!=y){
                maxheap.add(x-y); //add remaining stone back to the heap
            }
        }
        //return the weight of the last remaining stone or 0 if no stone is left
        return maxheap.isEmpty()?0:maxheap.poll();
    }
    public static void main(String []args){
        int[] stone = {2,7,4,5,6,1};
        int result = lastStone(stone);
        System.out.println(result);
    }
    
}
