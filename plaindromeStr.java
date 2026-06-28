public class plaindromeStr {
    public static int isPalin(String s){
        int ans = 0;
        
        for(int i=0;i<s.length();i++){
            //add the value to answer variable
            //pass value of string s ,character position on the middle variable & odd length palindrome 
            //will have same value 
            ans += CheckPalindrome(s,i,i);//odd
            //for to be middle value must have two values so, i+1
            ans += CheckPalindrome(s,i,i+1);//even

        }
        return ans;
    }
    public static int CheckPalindrome(String s,int left,int right){
        int count=0;

        while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){//check if the string is a valide palandrome or not
            left--;
            right++;
            count++;
        }
        return count;
    }
    public static void main(String []args){
        String str="abbc";
        int result=isPalin(str);
        System.out.println(result);
    }
}
