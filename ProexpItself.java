import java.util.Arrays;

public class ProexpItself {
    public static int[] productitself(int[] num){//put int[] because you are passing an array
        int[] result = new int[num.length];

        Arrays.fill(result,1);//by default all values to 1

        int pre=1 , post=1;//initalizing pre & post to 1

        for(int i=0;i<num.length;i++){
            result[i]=pre;
            pre=num[i]*pre;
        }
        for(int i=num.length-1;i>=0;i--){
            //update value inside result array
            result[i]=result[i]*post;
            post=post*num[i];
        }
        return result;
    }
    public static void main(String []args){
        int num[]={1,2,3,4};
        int result[] = productitself(num);
        System.out.println(Arrays.toString(result));//Arrays.toString(result) converts the array into a readable string
    }
}
