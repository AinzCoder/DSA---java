public class FindmissPosit {
    public static int firstMiss(int[] num){
        //checking if 1 is present or not if it's not present return 1 as the answer
        int contains=0;//flag to check if 1 exists
        int n = num.length;

        //If 1 is found → increase contains and stop checking
        for(int i=0;i<num.length;i++){
            if(num[i]==1){
                contains++;
                break;
            }
        }
        //If 1 is not present, the smallest missing positive number is always 1
        //So we directly return 1
        if(contains==0){
            return 1;
        }
        //any single value that is following between the given range convert to value number 1 and
        //invalide numbers--0,-1,16
        //0 or negative numbers
        //Numbers greater than n (array size)
        for(int i=0;i<num.length;i++){
            if(num[i]<=0 || num[i]>n){
                num[i]=1;
            }
        }
        //change it subsequent index value to -ve
        //If number a exists, mark index a as negative
        //Negative value means → number is present
        //Index n does not exist (array indices go 0 to n-1)
        //So we use index 0 to represent number n
        for(int i=0;i<num.length;i++){
            int a = Math.abs(num[i]);
            if(a==n){
                num[0]=-Math.abs(num[0]);
                
                //The number n is present in the array
                //Since index n doesn’t exist,
                //We use index 0 to represent number n
            }
            else{
                num[a]=-Math.abs(num[a]);
                //Number a exists
                //Mark its presence by making num[a] negative
            }
            //Why this trick works
            //We reuse the input array
            //No extra space needed
            //Index → represents number
            //Sign → represents presence
        }
        //if we identity any +ve index value simple return the index charactor and that is going to be the answer
        //Positive value means → that index number was never marked
        //So i is the missing positive number
        for(int i=1;i<n;i++){
            if(num[i]>0){
                return i;
            }
        }
        //If index 0 is positive → number n is missing
        if(num[0]>0){
            return n;
        }
        //If all numbers 1 to n are present
        //Then the answer is n + 1
        return n+1;
    }
    public static void main(String []args){
        int[] num={1,2,0};
        int result = firstMiss(num);
        System.out.println(result);
    }
}
