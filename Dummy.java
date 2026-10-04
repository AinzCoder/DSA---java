import java.util.Stack;

public class Dummy{

    private static int noOfValid(String s){
        int maxVal = 0;
        var stack = new Stack<Integer>();
        stack.push(-1);

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                stack.push(i);
            }
            else{
                stack.pop();

                if(stack.isEmpty()){
                    stack.push(i);
                }
                else{
                    maxVal = Math.max(maxVal, i - stack.peek());
                }
            }
        }
        return maxVal;
    }

    public static void main(String[] args) {
        
    }
}