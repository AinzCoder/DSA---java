
import java.util.HashSet;
import java.util.Stack;

public class Minimum_remove {
    private static String minRemove(String str){
        var stack = new Stack<Integer>();
        var invalidePar = new HashSet<Integer>();

        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(c=='('){
                stack.push(i);
            }
            else if(c==')'){
                if(stack.isEmpty()){
                    invalidePar.add(i);
                }else{
                    stack.pop();
                }
            }
        }

        //uneven paranthesis we need to remove this ex: ((h)
        while(!stack.isEmpty()){
            invalidePar.add(stack.pop());
        }

        //build the string as output
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<str.length();i++){
            if(!invalidePar.contains(i)){
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
    public static void main(String []args){
        String str="p)(a)+((h)";
        String result = minRemove(str);
        System.out.println(result);
    }
    
}
