import java.util.HashMap;
import java.util.Stack;

class valide_paranthesis{
    private static boolean checker(String s){
        var mapBracket = new HashMap<Character,Character>();

        mapBracket.put(')','(');
        mapBracket.put(']','[');
        mapBracket.put('}','{');

        var stack = new Stack<Character>();

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);

            if(!mapBracket.containsKey(c)){
                stack.push(c);                
            }
            else{
                if(stack.isEmpty()){
                    return false;
                }
                char topElement = stack.pop();
                if(topElement != mapBracket.get(c)){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    public static void main(String []args){
        String str="{[(]}";
        boolean result = checker(str);
        System.out.println(result);
    }
}