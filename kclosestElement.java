import java.util.Arrays;
import java.util.PriorityQueue;

public class kclosestElement {
    private static int[][] closestElement(int[][] points,int k){
        // √(x1 - x2)2 + (y1 - y2)2)
        // Distance Formula

        // For point:(x,y)
        // Distance from origin:√(x² + y²)
        // But: sqrt unnecessary Because comparison works with: x² + y² alone.

        // Why MAX heap? Because: we want to remove farthest point when size exceeds: k

        //create a maxheap based on formula which the distance from origin
        var maxHeap = new PriorityQueue<int[]>((a,b) -> Integer.compare(
            b[0]*b[0]+b[1]*b[1],
            a[0]*a[0]+a[1]*a[1]));

        //add points to maxheap and remove  the farthest point if heap size exceeds k
        for(int[] point:points){
            maxHeap.add(point);
            if(maxHeap.size()>k){
                maxHeap.poll();
            }
        }

        //collect the closest points from the heap
        int[][] result = new int[k][2];
        for(int i=0;i<k;i++){
            result[i]=maxHeap.poll();
        }
        return result;
    }
    public static void main(String[] args) {

        int[][] points = {
                {1, 3},
                {-2, 2},
                {5, 8},
                {0, 1}
        };

        int k = 2;

        int[][] result = closestElement(points, k);

        System.out.println( "K Closest Points:");

        for (int[] point : result) {
            System.out.println(Arrays.toString(point));
        }
    }
}
