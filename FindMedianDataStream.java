import java.util.PriorityQueue;

public class FindMedianDataStream {

    private PriorityQueue<Integer> lo = new PriorityQueue<>((a,b) -> b-a);// max heap
    private PriorityQueue<Integer> hi = new PriorityQueue<>(); // min heap

    //adds a number into the data structure
    private void addNum(int num){
        lo.offer(num); //add to max heap

        // Step 2:
        // Move largest from lo to hi
        hi.offer(lo.poll()); // balancing step

        // Step 3:
        // Maintain size property
        if(lo.size() < hi.size()){ //maintains size property
            lo.offer(hi.poll());
        }
    }

    private double findMedian(){
        return lo.size() > hi.size()? lo.peek() /*odd */:(lo.peek()+hi.peek())*0.5;
    }
    
    public static void main(String []args){
        FindMedianDataStream stream = new FindMedianDataStream();
        stream.addNum(5);
        stream.addNum(9);
        stream.addNum(4);
        stream.addNum(3);

        System.out.println(stream.findMedian());
    }
}
