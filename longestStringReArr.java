import java.util.HashSet;
public class longestStringReArr {
    public static int isRepeated(String s){
        if(s==null || s.length()==0){
            return 0;
        }
        if(s.length()==1){
            return 1;
        }
        int left=0;
        int right=0;
        int ans=0;

        HashSet<Character> set = new HashSet<>();
        //loop till the point where right reaches to the end of the string
        while(right<s.length()){
            //to find the value of that perticular index
            char c = s.charAt(right);
            while(set.contains(c)){
                //if value contains in the hash set remove the charactor
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c);
            ans = Math.max(ans,right - left+ 1);
            //update the right pointer 
            right++;

        }
        return ans;
    }
    public static void main(String []args){
        String s= "abcabcbb";
        int result = isRepeated(s);
        System.out.println(result);
    }
}
