public class trapWater {
    public static int hasTraped(int[] num){
        int left=0;
        int right=num.length-1;
        int total=0;
        int leftMax=num[0];
        int rightMax=num[right];
        while(left<right){
            //check for height differnece & whichever has lower height we are working onthis side
            if(num[left]<num[right]){
                //update the leftmax
                leftMax=Math.max(leftMax,num[left]);
                //check we are at any valley where we can store some water
                if(leftMax-num[left]>0){
                    total=total+leftMax-num[left];
                }
                left++;
            }
            else{
                rightMax=Math.max(rightMax,num[right]);
                if(rightMax-num[right]>0){
                    total=total+rightMax-num[right];
                }
                right--;
            }
        }
        return total;
    }
    public static void main(String []args){
        int[] num={0,1,0,2,1,0,1,3,2,1,2,1};
        int result=hasTraped(num);
        System.out.println(result);
    }
    
}
