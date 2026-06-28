import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnaArr {
    //List<List<String>> --->list where each item is another list of string or consider it has a big box
    //Inside the big box, there are smaller boxes.Inside each small box, there are strings.
    //List<String> → one group of words
    //List<List<String>> → many groups
    public static List<List<String>> groupAnagram(String[] strs){
        if(strs.length==0){
            return new ArrayList<>();
        }
        //Map stores data in "key --> value" pair
        //key --> "String" && value --> "list of string"
        //so inside the map "key is sorted version of the same word" && " value is list of words that belong to key"
        Map<String, List<String>> map = new HashMap<>();
        int[] count = new int[26];//counts from A to Z 
        
        for(String s:strs){
            Arrays.fill(count,0);//Arrays.fill--> method that sets every element of the array "count to 0"

            //count letter of words eg:- e--> count[4]++
            for(char c:s.toCharArray()){//toCharArray-->converts a string to array of charactors eg-> "eat" --> 'e','a','t'
                count[c-'a']++;
            }

            //create key from the counts
            //StringBuilder lets you add characters or text without creating new string objects.
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<26;i++){
                //sb.append("#") is used to separate the letter counts so,
                //the key string is clear, readable, and unique for each anagram group.
                sb.append("#");
                sb.append(count[i]);
            }

            //put word in the correct group
            String key = sb.toString();
            if(!map.containsKey(key)){//gives true if the key does not exist 
                map.put(key,new ArrayList<>());//creates new group for new set of keys
            }
            map.get(key).add(s);//gets the key and adds to s String
        }
        //return all groups
        return new ArrayList<>(map.values());
    }
    public static void main(String [] args){
        String[] word={"eat","tea","tan","ate","nat","bat"};
        List<List<String>> result = groupAnagram(word);
        System.out.println(result);
    }
}
