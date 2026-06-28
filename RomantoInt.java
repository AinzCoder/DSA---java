import java.util.HashMap;
import java.util.Map;

public class RomantoInt {
    static Map<String,Integer> values = new HashMap<>();
    static{
        values.put("I",1);
        values.put("V",5);
        values.put("X",10);
        values.put("L",50);
        values.put("C",100);
        values.put("D",500);
        values.put("M",1000);
        values.put("IV",4);
        values.put("IX",9);
        values.put("XL",40);
        values.put("XC",90);
        values.put("CD",400);
        values.put("CM",900);
    }
    public static int romanTOint(String s){
        int sum=0;
        int i=0;
        while(i<s.length()){
            //check for two numbered roman letter
            if(i<s.length()-1){//it ensures that Only try 2-character symbols if at least 2 characters remain
                //When i = 3 (last character):
                //i + 1 does NOT exist
                //So we must prevent substring errors
                String twoSymbol = s.substring(i,i+2);//It extracts two consecutive Roman characters starting at index i.
                
                if(values.containsKey(twoSymbol)){
                    //If the pair exists:
                    //Get its value from the HashMap
                    //Add it directly to sum
                    sum += values.get(twoSymbol);
                    i=i+2;//Because we already consumed two characters.
                    continue;//It skips the rest of the loop and jumps to the next iteration.
                    //Because we already handled this Roman pair
                    //We do NOT want the single-character logic to run like after IV then again I 
                }

            }
            //Because not all Roman numerals are two-character combinations.
            
            String oneSymbol = s.substring(i,i+1);//Extracts one Roman character at index i
            //Converts the Roman character to its integer value
            //Adds it to sum
            sum += values.get(oneSymbol);
            i=i+1;//Move to the next character
            //Because we consumed only one symbol
        }
        return sum;
    }
    public static void main(String []args){
        String s="MDXI";
        int result = romanTOint(s);
        System.out.println(result);
    }
}
