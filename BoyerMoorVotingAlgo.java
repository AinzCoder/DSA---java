public class BoyerMoorVotingAlgo {
    public static int majorElement(int[] num){
        int candidate=0;//potentcial major candidate
        int count=0;//vote count
        
        for(int n:num){
            if(count==0){
                candidate=n;//choose new candidate
            }
            if(n==candidate){
                count++;//vote for
            }
            else{
                count--;//vote against
            }
        }
        return candidate;
    }
    public static void main(String []args){
        int[] num={1,1,2,3,3,2};
        int result=majorElement(num);
        System.out.println(result);
    }
}
