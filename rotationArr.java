public class rotationArr {
    public static int findMin(int[] num){
        int left=0;
        int right=num.length-1;
        int ans=num[0];

        if(num.length==1){
            return num[0];
        }
        while(left<=right){
            if(num[left]<=num[right]){
                //l<r-ideal case
                ans=Math.min(ans,num[left]);
            }
            int mid=(left+right)/2;
            ans=Math.min(ans,num[mid]);
            //if left < mid remove left update left and mid
            if(num[left]<=num[mid]){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return ans;
    }
    public static void main(String []args){
        int[] arr={1,2,3,4,5};
        int result=findMin(arr);
        System.out.println(result);
    }
    
}
