public class containWater {
    public static int isWater(int[] num){
        int left=0;
        int right=num.length-1;
        int max=0;
        while(left<right){
            int width=right-left;
            //selecting the lesser height among the left or right height
            int area=Math.min(num[left],num[right])*width;
            //check if we need to change max value or not
            max = Math.max(max,area);

            if(num[left]<=num[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return max;
    }
    public static void main(String []args){
        int[] num ={1,8,6,2,5,4,8,3,7};
        int result = isWater(num);
        System.out.println(result);
    }
}
