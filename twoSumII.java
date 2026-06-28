import java.util.Arrays;
public class twoSumII {
    //using two pointers
    //for time complexity where we are not additionaly storing any vairable 
    public static int[] isTwo(int[] num,int target){
        int left=0;
        int right=num.length-1;
        while(left<right){
            if(num[right] + num[left] > target){//sum > target decrease right
                right=right-1;
            }
            else if(num[right] + num[left] < target){//sum < target increase left
                left=left+1;
            }
            else{//sum=target return the index value
                return new int[]{left+1,right+1};//because the indexing starts from 1
            }
        }
        return null;
    }
    public static void main(String []args){
        int[] num={1,2,4,5,7,8};
        int target = 12;
        int[] result = isTwo(num,target);
        System.out.println(Arrays.toString(result));
    }
    
}
