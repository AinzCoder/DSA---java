public class nextPermu {
    public static int[] nextPer(int[] num){
        //find first decreasing element
        int i=num.length-2;//because we do not want to be in the out of bounds because we will always be comparing two i values at the same time
        while(i>=0 && num[i+1]<=num[i]){//comparing adjacent value
            i--;
        }
        //when ith element is not incorrect we need to swap the values
        if(i>=0){
            int j =num.length-1;
            while(num[j]<=num[i]){//check if jth value that is less than or equal to i then keep on decreasing the value of j
                //immediate largest value of j
                j--;
            }
            //then swap
            swap(num,i,j);
            //reverse for remaining values
        }
        reverse(num,i+1);//because from i+1 we need to reverse the value of an array
        /* i starts at 1 because we want to reverse the array only after a certain position, 
        not the whole array.Starting from 0 would reverse the entire array, 
        which is not what the algorithm needs. */
        return num;
    }
    public static void swap(int[] num,int i,int j){
        int temp = num[i];
        num[i]=num[j];
        num[j]=temp;
    }
    public static void reverse(int[] num,int i){//ith value as a starting index were it starts doing reverse operation
        int j=num.length-1;//as an end value that is length of given array
        //left starts at index i
        /*Right side starts at the end of the array
          Elements are swapped until both pointers meet
           */
        while(i<j){
            swap(num,j,i);
            i++;
            j--;
        }
    }
    public static void main(String []args){
        int[] num={3,2,1};
        int[] result=nextPer(num);
        for(int i=0;i<result.length;i++){
            System.out.print(num[i] + " ");
        }
    }
    
}
