import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Interval{
    int start;
    int end;

    public Interval(int start,int end){
        this.start=start;
        this.end=end;
    }
}

public class EmpFreeTime {

    private static List<Interval> employeeFreeTime(List<List<Interval>> schedule){

        List<Interval> result = new ArrayList<>();
        var pq = new PriorityQueue<Interval>((a,b) -> a.start - b.start); //sort intervals using start time
        //a = [1,3]
        //b = [6,7]
        // becomes:1 - 6 = -5
        // Negative means: a comes before b

        // | Return Value | Meaning    |
        // | ------------ | ---------- |
        // | negative     | a before b |
        // | positive     | b before a |
        // | 0            | equal      |


        //add all intervals into priority queue
        for(List<Interval> intervals: schedule){
            pq.addAll(intervals);
        }
        // You are only storing reference
        Interval prev = pq.poll(); //variable that can point to Interval object
        while(!pq.isEmpty()){
            Interval cur = pq.poll();
            if(prev.end < cur.start){
                //there is a gap between prev and curr, which is commmon free time
                // prev = [1,5]
                // cur  = [6,7]
                // Check: 5 < 6 YES.
                // Gap:[5,6] free time.

                result.add(new Interval(prev.end,cur.start));
                prev=cur; //move prev pointer forward
            }else{
                //overlapping of the intervals, update the end time if needed
                // largest merged interval
                prev.end = Math.max(prev.end,cur.end);
            }
        }
        return result;
    }   
     public static void main(String[] args) {

        List<List<Interval>> schedule = new ArrayList<>();

        // Employee 1
        List<Interval> emp1 = new ArrayList<>();

        emp1.add(new Interval(1, 3));
        emp1.add(new Interval(6, 7));

        // Employee 2
        List<Interval> emp2 = new ArrayList<>();

        emp2.add(new Interval(2, 4));

        // Employee 3
        List<Interval> emp3 = new ArrayList<>();

        emp3.add(new Interval(2, 5));
        emp3.add(new Interval(9, 12));

        schedule.add(emp1);
        schedule.add(emp2);
        schedule.add(emp3);

        List<Interval> free = employeeFreeTime(schedule);

        System.out.println("Employee Free Time:");

        for (Interval in : free) {

            System.out.println("[" + in.start+ ", "+ in.end+ "]");
        }
    }
}
