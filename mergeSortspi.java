import java.util.Arrays;
public class mergeSortspi {
    public static void merge(int[] num1,int[] num2,int m,int n){
        //pointer for num1 & num2 the end of the merge array
        int p1=m-1;//last element of num1
        int p2=n-1;//last element of num2
        int i=m+n-1;//last index of num1
        //merge in reverse order
        while(p2>=0){//since there are zero's grater the value must be greater than 0
            if(p1>=0 && num1[p1]>num2[p2]){//if m is greater than n
                num1[i]=num1[p1];//adding it to the last because it must be sorted
                p1--;
            }
            else{
                num1[i]=num2[p2];//else n will be add to last as it's the highest value
                p2--;
            }
            i--;
        }
    }
    public static void main(String []args){
        int[] n1={1,2,4,0,0,0};
        int[] n2={5,6,6};
        @SuppressWarnings("unused")
                int m = 3;
        @SuppressWarnings("unused")
                int n = 3;
        merge(n1,n2,3,3);
        System.out.println(Arrays.toString(n1));
    }
    
}
