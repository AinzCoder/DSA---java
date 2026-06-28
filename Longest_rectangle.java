import java.util.Stack;
class Longest_rectangle{
    private static int heightRec(int[] num){
        int maxArea=-1;
        var stack = new Stack<Integer>();
        int n=num.length;

        for(int i=0;i<=n;i++){
            int currHeight=(i==n)?0:num[i]; // if we crossed every single element in the array mark current height as zero or we just take the 
            //subsequnt height of num

            while(!stack.isEmpty() && currHeight<num[stack.peek()]){
                int height = num[stack.pop()];
                int width = stack.isEmpty()?i:i-stack.peek()-1;
                maxArea=Math.max(maxArea,height*width);
            }
            stack.push(i);
        }
        return maxArea;
    }
    public static void main(String []args){
        int[] height= {2,1,5,6,2,3};
        int result = heightRec(height);
        System.out.println(result);
    }
}