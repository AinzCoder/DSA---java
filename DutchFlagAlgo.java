import java.util.Arrays;

public class DutchFlagAlgo {
    public static void sortColor(int[] nums){
        int low=0,high=nums.length-1,curr=0;

        while(curr<=high){
            if(nums[curr]==0){
                //if current element is zero swap it with the element at low
                //and move both current and low one step forward
                swap(nums,curr,low);
                low++;
                curr++;
            }
            else if(nums[curr]==2){
                //if the current element is 2, swap it with the element at high and move high one step forward
                //we don't move current forward in this case because the swaped element from the high could
                //could be 0 and we need to process it to next iteratioin
                swap(nums,curr,high);
                high--;
            }
            else{
                //if the current element is 1 just move current one step forward
                curr++;
            }
        }
    }
    private static void swap(int[] num,int i,int j){
        int temp=num[i];
        num[i]=num[j];
        num[j]=temp;
    }
    public static void main(String []args){
        int[] num={1,0,2,2,1,1,0};
        sortColor(num);//since it returns void you directly print the method
        System.out.println(Arrays.toString(num));
    }
}
