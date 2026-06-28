import java.util.Arrays;
import java.util.Stack;

public class Daily_temp {
   private static int[] dailyTemp(int[] temp){
    int[] answer = new int[temp.length];
    var stack = new Stack<Integer>();
    for(int i=0;i<temp.length;i++){
        while(!stack.isEmpty() && temp[i] > temp[stack.peek()]){
            int index=stack.pop();
            answer[index] = i - index;
        }
        stack.push(i);
    }
    return answer;
   }
   public static void main(String []args){
    int[] num={73,74,75,71,69,72,76,73};
    int[] result = dailyTemp(num);
    System.out.println(Arrays.toString(result));
   }
}
