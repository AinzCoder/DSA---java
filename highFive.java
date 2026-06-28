import java.util.ArrayList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class highFive {
    private static int[][] highfive(int[][] items){
        Map<Integer, Queue<Integer>> scores = new TreeMap<>();

        for(int[] item:items){
            int id = item[0];
            int score=item[1];
            if(!scores.containsKey(id)){
                scores.put(id, new PriorityQueue<>((a,b) -> (b-a))); //by default ascending order so (b-a) to get desending order
            }
            scores.get(id).add(score);//add operation is used for queue
        }
        var ans = new ArrayList<>();

        for(int id:scores.keySet()){//all KEYS of the map ex: 1,2,3 not scores
            int sum=0;

            for(int i=0;i<5;i++){
                sum+=scores.get(id).poll();
            }
            ans.add(new int[]{id,sum/5});
        }

        int[][] ansArray = new int[ans.size()][];
        return ans.toArray(ansArray);
    }

    public static void main(String[] args) {

        int[][] items = {
                {1, 91},
                {1, 92},
                {2, 93},
                {2, 97},
                {1, 60},
                {2, 77},
                {1, 65},
                {1, 87},
                {1, 100},
                {2, 100},
                {2, 76}
        };

        int[][] result = highfive(items);

        for (int[] r : result) {
            System.out.println("ID: " + r[0] + " Average: " + r[1]);
        }
    }
    
    
}
