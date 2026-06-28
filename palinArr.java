public class palinArr {
    public static boolean isPalin(String s){
        int left=0;
        int right=s.length()-1;

        while(left<right){
            //Character."isLetterOrDigit"(s.charAt(left))
            //Returns true if ch is:
            //A letter (a–z, A–Z)
            //OR a digit (0–9)
            //Returns false for:
            //Spaces
            //Punctuation (@ # ! , .)
            //Symbols
            //“Check whether the character at position left is a letter or a digit.”
            while(left<right && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            while(left< right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            //Character is a wrapper class in Java
            //It provides utility methods to work with characters
            //Example methods:
            //toLowerCase()
            //toUpperCase()
            //isDigit()
            //“Take the character at position left in string s and convert it to lowercase.”
            //Convert the character at index right to lowercase.
            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static void main(String []args){
        String s="a man,aplan,a canal:Panama";
        boolean result = isPalin(s);
        System.out.println(result);
    }   
}
