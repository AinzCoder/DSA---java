public class twoDArr {
    public static boolean searchMatrix(int[][] arr,int target){
        int m=arr.length;
        int n=arr.length;

        //pointers
        int left=0;//first postion of the given matrix
        int right=m*n-1;//last postition of the given matrix

        while(left<=right){
            //first find the mid pointer in the martix after finding the mid have to point the midValue because it
            //is a 2-D matrix we can achive this by doing mid / n and mid % n 
            int mid=(left+right)/2;
            // Convert 1D index to 2D index
            int midValue=arr[mid/n][mid%n];//this gives excate value of mid in 2-D array

            //do binary search 
            if(midValue==target){
                return true;
            }
            else if(midValue<target){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return false;
    }
    public static void main(String []args){
        int[][] arr={
             {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };
        int target=5;
        boolean result=searchMatrix(arr, target);
        System.out.println(result);
    }
    
}
