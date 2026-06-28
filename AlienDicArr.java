import java.util.HashMap;
import java.util.Map;


public class AlienDicArr {
    public static boolean isAlian(String[] word,String order){
        Map<Character,Integer> orderMap = new HashMap<>();
        for(int i=0; i<order.length();i++){
            orderMap.put(order.charAt(i),i);
        }
        //compare charactor by charactor
        for(int i=0;i<word.length-1;i++){//-1 because not comparing the last word since we are comparing 2 word 
        //we no need to go arrayoutofbounds
        //create another for loop to compare two adjacent charactor
            for(int j=0;j<word[i].length();j++){
                //batman,bat scinario return false
                if(j>=word[i+1].length()){
                    return false;
                }
                //if that's not the case compare charactor by charactor
                if(word[i].charAt(j)!=word[i+1].charAt(j)){
                    //comapre their positions
                    int currLetter = orderMap.get(word[i].charAt(j));
                    int nextLetter = orderMap.get(word[i+1].charAt(j));
                    if(nextLetter<currLetter){
                        return false;
                    }
                    else{
                        break;//correct order move to the next word
                    }

                }
            }

        }
        return true;
    }
    public static void main(String []args){
        String[] words={"word","world","row"};
        String order="worldabcefghijkmnpqstuvxyz";
        boolean result = isAlian(words,order);
        System.out.println(result); 
    }
    
}
