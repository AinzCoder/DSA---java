
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class enAdeCodestr {
    //encode a list of string into a single string
    public static String isEncode(List<String> strs){
        //(char) 258 casts (converts) that number into a character
        //In Unicode, every number maps to a character
        //Character 258 is Ā (A with a bar)
        //“If the list is empty, return a unique string that will never occur in normal input.”
        //Helps the decoder recognize empty input
        if(strs.isEmpty()){
            return Character.toString((char)258);
        }
        String separed=Character.toString((char)257);
        StringBuilder sb = new StringBuilder();
        for(String s:strs){
            sb.append(s);
            //when string ends add separed character
            sb.append(separed);
        }
        //delete last character because that is an additional
        // remove last extra separator
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
    //decode a list string into a single character
    public static List<String> isDecode(String s){
        //empty string list
        //If I see this special character, I know the original list was empty.
        if(s.equals(Character.toString((char)258))){
            return new ArrayList<>();
        }
        String separate = Character.toString((char)257);
        
        return Arrays.asList(s.split(separate,-1));
    }
    public static void main(String []args){
        String[] arr={"hello","world"};
        List<String> list = Arrays.asList(arr);

        String enCode = isEncode(list);
        System.out.println("Encoded: " + enCode);

        List<String> deCode = isDecode(enCode);
        System.out.println("Decoded: " + deCode);
    }
}
