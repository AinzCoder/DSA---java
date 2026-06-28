

public class cpermu {
    
    public static boolean isSame(String s1,String s2){
        if(s1.length()>s2.length()){
            return false;
        }
        int[] s1Map = new int[26];
        int[] s2Map = new int[26];
        //initialize frequency map for s1 and the first window of s2
        for(int i=0;i<s1.length();i++){
            s1Map[s1.charAt(i) - 'a']++;
            s2Map[s2.charAt(i) - 'a']++;
        }
        //slide the window through s2 and compare the map
        for(int i=0;i<s2.length() - s1.length();i++){
            if(matches(s1Map,s2Map)){
                return true;
            }
            s2Map[s2.charAt(i+s1.length()) - 'a']++;//adding new charactor to the window
            s2Map[s2.charAt(i) - 'a']--;//remove old charactor from window
        }
        //check the last window
        return matches(s1Map,s2Map);
    }
    public static boolean matches(int[] s1Map,int[] s2Map){
        for(int i=0;i<26;i++){
            if(s1Map[i]!=s2Map[i]){//check is the value is same
                return false;
            }
        }
        return true;
    }
    public static void main(String []args){
        String s1="ab";
        String s2="eidbaooo";
        boolean result = isSame(s1,s2);
        System.out.println(result);
    }
}
