import java.util.HashMap;
import java.util.Map;
public class twoSum1{
    public static void main(String [] args){
        int num[]={1,8,7,5,2};
        int target=9;
        //create a hashmap with num and target
        Map<Integer,Integer> map = new HashMap<>();
        //traversing through num
        for(int i=0;i<num.length;i++){
            int complement=target-num[i];//

            if(map.containsKey(complement)){//"map.containsKey" --->check if the key is already present in the map
                //to get the indices of complement and the value          
                //return new int[] {map.get(complement),i}; //return pair of indices & creates new integer array. 
                System.out.println("Index: " + map.get(complement) + ", " + i);
                System.out.println("Value: " + num[map.get(complement)] + ", " +num[i]);
                return;
            }
            map.put(num[i],i);//to store number with its value
        }
        System.out.println("No index found to get the required value!!"); 
    }
}