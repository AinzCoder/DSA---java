import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
public class twoSumIII {
    public static List<List<Integer>> isThree(int[] num){
        //sort the given input nums
        //create new vairable result to store list of list in 
        Arrays.sort(num);
        List<List<Integer>> result = new ArrayList<>();

        for(int i=0;i<num.length && num[i]<=0;i++){//after i becomes +ve so j+k is going to increase so stop at i=0
            if(i==0 || num[i] != num[i-1]){//igonres duplicate value
                twoSum2(num,i,result);
            }
        }
        return result;
    }
    public static void twoSum2(int[] num,int i,List<List<Integer>> result){
        //initialize two pointer 
        int left=i+1;//left will in next element after i
        int right=num.length-1;

        while(left<right){
            //it sums because if the current sum are the triplets it returns zero
            int sum =num[i] + num[left] + num[right];

            if(sum < 0){
                left++;
            }
            else if(sum > 0){
                right--;
            }
            else{//when sum=0
                result.add(Arrays.asList(num[i],num[left++],num[right--]));
                //update the left pointer until the point wheater the loop adjacent pointer of left is same or not
                while(left<right && num[left] == num[left-1]){
                    ++left;
                }
            }
        }
    }
    public static void main(String []args){
        int[] num={-1,0,1,2,-1,-4};
        List<List<Integer>>  result = isThree(num);
        System.out.println(result);
    } 
}
