
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Time_key_Value {
    private final Map<String,TreeMap<Integer,String>> map;
    //  Initializes the main map
    public Time_key_Value(){
        map = new HashMap<>();
    }
    public void set(String key,String value,int timeStamp){
        // If key is missing, use that key (k) to create a new TreeMap
        map.computeIfAbsent(key,k -> new TreeMap<>()).put(timeStamp,value);
        // If key exists → return its TreeMap
        // If not → create new TreeMap and store it

        // or
        // if (!map.containsKey(key)) {
        // map.put(key, new TreeMap<>());
        // }
        // map.get(key).put(timeStamp, value);
    }
    public String get(String key,int timeStamp){
        TreeMap<Integer,String> treeMap = map.get(key);
        if(treeMap==null){
            return "";
        }
        Map.Entry<Integer,String> entry = treeMap.floorEntry(timeStamp);
        return entry==null?"": entry.getValue();
    }
    public static void main(String []args){
        Time_key_Value obj = new Time_key_Value();

        obj.set("foo", "bar", 1);
        obj.set("foo", "car", 4);
        obj.set("foo", "bat", 3);

        System.out.println(obj.get("foo",1));
        System.out.println(obj.get("foo",5));

    }
}
