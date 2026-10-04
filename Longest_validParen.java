
import java.util.Stack;

public class Longest_validParen {
    private static int longestParenthesis(String s){
        int maxlen=0;
        var stack = new Stack<Integer>();
        stack.push(-1); //base for next valid substring

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                //push the index of '(' into the stack
                stack.push(i);
            }else{
                //pop the top of the stack
                stack.pop();

                if(stack.isEmpty()){
                    // if stack is empty, push the current index as base  for the next valid substring
                    stack.push(i);
                }
                else{
                    // current index - startindex (at is element in stack) to get the length of maxLength
                    maxlen = Math.max(maxlen, i-stack.peek());
                }
            }
        }
        return maxlen;
    }
    public static void main(String[] args) {
        String str = "(()()(";
        int result = longestParenthesis(str);
        System.out.println(result);
    }
    
}

// 1. Calculating correct length for valid substrings starting at index 0
// The length of a valid substring between two indices is calculated as:
// length = current - index_before_valid_substring
// If a valid string starts at index 0 (e.g., s = "()"):
// At i = 0 ('('), index 0 is pushed onto the stack.
// At i = 1 (')'), index 0 is popped off.
// The stack now contains -1.
// The length is calculated as: 1 - {stack.peek()} = 1 - (-1) = 2.
// Without -1, popping index 0 would leave the stack empty, 
// and you wouldn't have a reference index to compute 1 - (-1) = 2.
