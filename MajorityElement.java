
import java.util.HashMap;
import java.util.Map;
public class MajorityElement {
    //Returns a Map containing frequency of each number
    private static Map<Integer,Integer> countNum(int[] num){
        Map<Integer,Integer> map = new HashMap<>();
        for(int n:num){
            if(!map.containsKey(n)){
                map.put(n,1);
            }
            else{
                map.put(n,map.get(n)+1);//update the number of occurences
            }
        }
        return map;
    }
    public static int major(int[] num){
        Map<Integer,Integer> map = countNum(num);//initialize new hashmap and call countNum method with nums
        //as input it populates the map array
        //find the value that is most occurences
        Map.Entry<Integer,Integer> majorEntry=null;//To store the current largest frequency entry
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){//what is map.Entry-> A single key–value pair inside a map
            //Go through each (key, value) pair in the map
            if(majorEntry==null || entry.getValue() > majorEntry.getValue()){//check which element contains most entries
                //First entry becomes majorEntry
                //entry.getKey()   → 2 number
                //entry.getValue() → 4 occurence
                majorEntry=entry;
            }
        }
        return majorEntry.getKey();//Returns the number (not the count)
    }
    public static void main(String []args){
        int[] num={2,1,1,1,2,2,2};
        int result = major(num);
        System.out.println(result);
    }
    
}
