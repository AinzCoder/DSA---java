import java.util.HashMap;
import java.util.Map;

public class minSlidArr {
    public static String isMin(String s,String t){
        if(s.length()==0 || t.length()==0 ||s.length()<t.length()){
            return " ";
        }
        Map<Character,Integer> tmap = new HashMap<>();
        //enter all entries to the map t
        for(int i=0;i<t.length();i++){
            //getOrDefault(c, 0)
            //Checks if character c already exists in the map subString
            // If it exists → returns its current count
            //If it does NOT exist → returns 0
            //+ 1
            //Increments the count of that character
            //put(c, value)
            //Stores the updated count back into the map
            tmap.put(t.charAt(i),tmap.getOrDefault(t.charAt(i),0)+1);
        }
        int require = tmap.size();
        int l=0,r=0; //two pointers
        int create=0;//no of varibales that we have created so far that also present inside the given t
        int[] ans={-1,0,0};//to store the value of answer and initialize l=0 and r=0 "-1 to keep track of length of current substring"
        Map<Character,Integer> subString = new HashMap<>();
        //run until right reaches to the end of the string
        while(r<s.length()){
            //add entry to hashmap
            char c =s.charAt(r);
            int count = subString.getOrDefault(c,0);
            subString.put(c,count+1);

            //if the same value is present inside the tmap as in subString add to create and check the requirement
            if(tmap.containsKey(c) && subString.get(c).intValue() == tmap.get(c).intValue()){
                //subString.get(c) → returns an Integer
                //tmap.get(c) → returns an Integer

                //.intValue() converts an Integer object into a primitive int. so,
                //HashMap<Character, Integer> stores values as Integer objects, not int
                //But comparisons often work with primitive int
                //.intValue() → extracts the actual int number from the object
                
                //update the value of create variable
                create++;
            }
            //check if current subString is valide or not
            //wheater required and create has same value if thats the case update the left pointer and shrink your size
            //and also add entries to ans array
            //l is the left pointer
            //r is the right pointer
            //We shrink the window from the left, so l <= r must hold.
            while(l<=r && require == create){
                //check if we want to update our ans or not
                //also update the value of character c variable
                c = s.charAt(l);
                if(ans[0]==-1  || r-l+1 < ans[0]){
                    ans[0]=r-l+1;
                    ans[1]=l;
                    ans[2]=r;
                }
                //need to remove an entry from the subString map because we are updating the left pointer
                subString.put(c,subString.get(c) - 1);
                //the entry we have removed did it caused us to reduce our create variable
                if(tmap.containsKey(c) && subString.get(c).intValue() < tmap.get(c).intValue()){
                    create--;
                }
                //update the left pointer
                l++;
            }
            r++;

        }
        //if we are not able to find any answer
        if(ans[0]==-1){
            return " ";
        }
        //return the value from answer array for the left and right pointer value which means ans[1],ans[2]
        //r+1 because the indexing workes from 0 to r so that's why we need to add one more entry to the right
        return s.substring(ans[1],ans[2]+1);

    }
    public static void main(String []args){
        String s="ADOBECODEBANC";
        String t="ABC";
        String result = isMin(s,t);
        System.out.println(" " + result);
    }
    
}
