//longest repeated charactor replacement
public class longestStr {
    public static int charReplace(String s,int k){

        int[] occurence = new int[26];
        int left=0,right;
        int ans=0;
        int maxOccurence=0;

        //Move right from start to end of the string.
        for(right=0;right<s.length();right++){
            //Convert character to index
            //'a' - 'a' = 0, 'b' - 'a' = 1
            //Increase frequency of that character
            //Update maxOccurence (highest frequency in current window)
            //📌 This tells us which character appears the most in the window.
            maxOccurence=Math.max(maxOccurence,++occurence[s.charAt(right) - 'a']);
            //right - left + 1 → window size
            //window size - maxOccurence → number of characters to replace
            //If replacements needed > k, window is invalid
            if(right-left + 1 - maxOccurence > k){
                //Reduce frequency of the left character
                //Move left forward to shrink the window
                occurence[s.charAt(left) - 'a']--;
                //left pointer increments
                left++;
            }
            //Store the largest valid window size
            ans=Math.max(ans,right-left+1);
        }
        return ans;
    }
    public static void main(String []args){
        String s="abab";
        int k=2;
        int result = charReplace(s,k);
        System.out.println(result);
    }
    
}
