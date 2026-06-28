
public class AnagramArr {
    public static boolean isAnagram(String s,String t){
        if(s.length()!=t.length()){
            return false;
        }
        //create an array to count charector frequently
        int charCount[] = new int[26];//assume only lowercase charector

        //increment count for each charactor in s and decrement for each charactor in t
        for(int i=0;i<s.length();i++){
            //s.charAt() --> takes the i-th element of the string s
            //s.charAt(i) - 'a' --> this converts charactor to an index between 0-25 eg--> 'a'-'a'=0
            //this works because charactor has ascii values eg-->'a'=97
            //so 'c' - 'a' = 99 - 97 is index 2 soo, in short it converts charactor to index & 
            // check how many time each letter occur in the string
            charCount[s.charAt(i) - 'a']++;
            charCount[t.charAt(i) - 'a']--;

        }
        //check if all counts are 0
        for(int count:charCount){
            if(count!=0){
                return false;
            }
        }
        return true;
    }
    public static void main(String [] args){
        String s="cat";
        String t="tac";
        boolean result =  isAnagram(s,t);
        System.out.println("Anagram word:" + result);
    }    
}
