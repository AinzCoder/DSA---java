import java.util.ArrayDeque;

public class DvsRVoiting {
    private static String predictVoting(String senate){
        int n=senate.length();
        var r = new ArrayDeque<Integer>();
        var d = new ArrayDeque<Integer>();

        //put  the index of party in each separate groups
        for(int i=0;i<n;i++){
            if(senate.charAt(i)=='R') r.offer(i);
            else d.offer(i);
        }

        //simulate rounds
        //the senate with samller index acts first and bans other
        //the winner samller index reqeues with index+n to act in a future round

        while(!r.isEmpty() && !d.isEmpty()){
            int ri=r.poll();
            int di=d.poll();
            if(ri<di){
                //R acts fast and removes the D
                r.offer(ri+n);
            }else{
                //D acts fast and removes the R
                d.offer(di+n);
            }
        }
        return r.isEmpty()? "Democrate":"Republic";
    }
    
}
