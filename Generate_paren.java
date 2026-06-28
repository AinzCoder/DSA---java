
import java.util.ArrayList;
import java.util.List;

public class Generate_paren {

    private static List<String> gneratePar(int n){
        List<String> ans = new ArrayList<>();
        backTracking(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

//     | Variable | Meaning                    |
// | -------- | -------------------------- |
// | `cur`    | current string being built |
// | `open`   | number of `(` used         |
// | `close`  | number of `)` used         |
// | `max`    | total pairs allowed        |


    private static void backTracking(List<String> ans,StringBuilder cur, int open, int close,int max){
        if(cur.length()==max*2){ //4 = max*2 where n=2
            ans.add(cur.toString());
            return;
        }
        // Add opening bracket  
        if(open<max){ //We still have opening brackets left.
            cur.append("(");
            backTracking(ans, cur, open+1, close, max);
            // Backtrack
            cur.deleteCharAt(cur.length()-1); //Undo last choice and try another possibility
        }
        //StringBuilder keeps old characters.

        // Add closing bracket
        if(close<open){ //Closing brackets cannot exceed opening brackets.
            cur.append(")");
            backTracking(ans, cur, open, close+1, max);
             // Backtrack
            cur.deleteCharAt(cur.length()-1);
        }
    }
    public static void main(String[] args) {
        int n=2;
        List<String> result = gneratePar(n);
        System.out.println(result);
    }
}
