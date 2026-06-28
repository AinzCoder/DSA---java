import java.util.Arrays;
public class firstLastPos {
    public static int[] search(int[] nums,int target){
        int first = find(nums,target,true);//true to calculate first value
        if(first==-1){
            return new int[] {-1,-1};
        }
        int last = find(nums,target,false);//false to calculate last value
            return new int[] {first,last};
    }
    public static int find(int[] num,int target,boolean isFirst){
        int start=0;
        int end=num.length-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(num[mid]==target){

                if(isFirst){//right pointer moving forward
                    if(mid==start || num[mid-1]!=target){
                        return mid;
                    }
                    //shift our search by updating the end pointer
                    end=mid-1;
                }
                else{
                    if(mid==end || num[mid+1]!=target){//left pointer moves forward
                        return mid;
                    }
                    //shift our search by updating the start pointer
                    start=mid+1;
                }
            }
            //if mid is not equal to target
            else if(num[mid]>target){//right=mid-1
                end=mid-1;
            }
            else{//left=mid+1
                start=mid+1;
            }
        }
        return -1;
    }
    public static void main(String []args){
        int[] num={0,1,1,1,5,4};
        int target=1;
        int[] result = search(num,target);
        System.out.println(Arrays.toString(result));
    }
}
