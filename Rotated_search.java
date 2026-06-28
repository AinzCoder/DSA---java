public class Rotated_search {
    private static int isSearch(int[] num,int target){
        int left=0;
        int right=num.length-1;

        while(left<=right){
            int mid=(left+right)/2;
            if(num[mid]==target){
                return mid;
            }
            if(num[left]<=num[mid]){
                if(target< num[left] || target > num[mid]){
                    left=mid+1;
                }
                else{
                    right=mid-1;
                }
            }
            else{
                if(num[right]< target || target < num[mid]){
                    right=mid-1;
                }
                else{
                    left=mid+1;
                }
            }
        }
        return -1;
    }
    public static void main(String []args){
        int[] num={3,4,5,0,1,2};
        int target=2;
        int result = isSearch(num,target);
        System.out.println(result);
    }
    
}
