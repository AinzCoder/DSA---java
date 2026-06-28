// Problem:

// You have a 4-wheel lock starting at "0000"
// Each wheel:
// can rotate up or down
// Goal:
// reach target in minimum moves

// Why BFS?
// Because:
// BFS always finds shortest path
// Each lock state:
// is a node in a graph
// Each wheel turn:
// is an edge



import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;

public class OpentheLock {
    private int openLock(String[] deadends, String target){

        //Stores blocked states
        var dead = new HashSet<String>(Arrays.asList(deadends));

        //edge cases
        if(dead.contains("0000")) return -1;
        if("0000".equals(target)) return  0;


        //BFS implementation using queue

        //Queue stores: states to explore
        var q = new ArrayDeque<String>();
        var seen = new HashSet<String>();

        //Start BFS
        q.offer("0000"); //add values inside the queue
        seen.add("0000"); //add values inside the hashset

        int step=0;

        while(!q.isEmpty()){
            int size = q.size();
            for(int s=0; s < size;s++){
                String cur = q.poll(); //remove the front element from the queue
                if(dead.contains(cur)) continue;    //skip blocked states
                if(cur.equals(target)) return step;  //reached in minimum move

                //generate neighbours by turning each wheel +/-1
                char[] cs = cur.toCharArray();  //['0','0','0','0']
                for(int i = 0; i < 4 ;i++){ //Turn wheel: UP DOWN (4 wheels)
                    char orig = cs[i];

                    // It converts: character digit → integer digit
                    //ex orig='7' so
                    // '7' - '0'
                    // = 55 - 48 -> ascii values of '7' and '0'
                    // = 7
                    int d = orig - '0';

                    //turn up
                    // This line rotates the lock wheel UP by 1 then coverts it back to char 
                    cs[i]=(char) ('0' + ((d+1)%10)); //Turn UP  Add to queue.
                    String up = new String(cs);
                    if(!dead.contains(up) && seen.add(up)) q.offer(up);

                    //turn down
                    // This line rotates the wheel downward with circular wraparound
                    cs[i]=(char) ('0' + ((d+9)%10));// Turn DOWN
                    //Why +9?
                    // Because: 0-1 = -1
                    // Need circular rotation.
                    // (0+9)%10 = 9
                    // Result: 9000 Add to queue.

                    String down = new String(cs);
                    if(!dead.contains(down) && seen.add(down)) q.offer(down);

                    cs[i]=orig; //restore for next wheel
                }
            }
            step++;
        }
        return -1; // unreachable;
    }
    public static void main(String[] args) {

    OpentheLock lock = new OpentheLock();

    String[] deadends = {
            "0201",
            "0101",
            "0102",
            "1212",
            "2002"
    };

    String target = "0202";

    int result = lock.openLock(deadends, target);

    System.out.println("Minimum moves: " + result);

    }
    
}
