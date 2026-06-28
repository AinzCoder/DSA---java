import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TaskShedular {
    private static int leatInterval(char[] tasks,int n){
        //count frequency of each task
        var freqmap = new HashMap<Character,Integer>();
        for(char task:tasks){
            freqmap.put(task,freqmap.getOrDefault(task,0)+1);
        }

        //Build a maxHeap based on frequency
        var maxHeap = new PriorityQueue<Integer>((a,b) -> b-a);
        maxHeap.addAll(freqmap.values());

        //process the task
        int time=0;
        while(!maxHeap.isEmpty()){
            var temp = new ArrayList<Integer>();
            for(int i=0;i<n+1;i++){
                if(!maxHeap.isEmpty()){
                    temp.add(maxHeap.poll());
                }
            }

            //reduce values from frequency
            for(int freq : temp){
                if(--freq>0){
                    maxHeap.add(freq);
                }
            }

            //update time
            time+=maxHeap.isEmpty()?temp.size():n+1;
        }
        return time;
    }
    public static void main(String []args){
        char[] tasks={'A','A','A','B','B','B'};
        int n=2;
        int result = leatInterval(tasks, n);
        System.out.println(result);
    }
    
}
