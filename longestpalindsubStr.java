public class longestpalindsubStr {
    public static String isPalindrome(String s){
        if(s==null || s.length()<0){
            return "";
        }
        //need two pointers
        int left=0;
        int right=0;
        for(int i=0;i<s.length();i++){
            int len1=CheckPalindrome(s,i,i);//odd length
            int len2=CheckPalindrome(s,i,i+1);//even lenght
            int len=Math.max(len1,len2);
//i → current center index
//len → length of the palindrome found at center i
//left, right → store the start and end indices of the longest palindrome so far
            if(len > right - left){//right - left = length of the current longest palindrome
                //len = length of the new palindrome
                //👉 If the new palindrome is longer, update the answer.
                left=i - (len-1)/2;//This computes the starting index of the palindrome.
                //Palindrome expands equally on both sides
                //(len - 1) gives total expansion excluding center
                //Dividing by 2 gives how far left we move
                right=i + len/2;//This computes the ending index of the palindrome.
            }
        }
        return s.substring(left,right+1);
        //substring(start, end)
        //start → inclusive
        //end → exclusive
        //So to include right, we add +1.
    }
    public static int CheckPalindrome(String s,int left,int right){
        int l=left,r=right;
        while(l>= 0 &&r<s.length() && s.charAt(l)==s.charAt(r)){
            l--;
            r++;
        }
        //return the length so far
        return r-l-1;//palindrome length
        //it will start from 0->n index then r-l-1 is used to calculate the length of the palindrome
    }
    public static void main(String []args){
        String s="xmadam";
        String result=isPalindrome(s);
        System.out.println(result);
    }
}
