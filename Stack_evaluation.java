
import java.util.Stack;

public class Stack_evaluation {
    private static int evalStack(String[] tokens){
        var stack = new Stack<Integer>();
        for(String token:tokens){
            if(isOperator(token)){
                int b = stack.pop();
                int a = stack.pop();
                int result = applyOperation(token,a,b);
                stack.push(result);
            }
            else{
                // parseInt() → faster (no object creation)
                // valueOf()  → slightly slower (object)
                stack.push(Integer.parseInt(token)); //converts it into integer
            }
        }
        return stack.pop();
    }
    private static boolean isOperator(String token){
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private static int applyOperation(String operator,int a,int b){
        switch(operator){
            case "+" -> {
                return a+b;
            }
            case "-" -> {
                return a-b;
            }
            case "*" -> {
                return a*b;
            }
            case "/" -> {
                return a/b;
            }
            default -> throw new IllegalArgumentException("Invalide operator");
        }
    }
    public static void main(String []args){
        String[] num={"2","3","+","3","+"};
        int result = evalStack(num);
        System.out.println(result);
    }
    
}
