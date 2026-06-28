
import java.util.HashSet;

public class LonConSeqArr {
    @SuppressWarnings("UnnecessaryContinue")
    public static int longcon(int[] num){
        if(num.length==0){
            return 0;
        }
        HashSet<Integer> numSet = new HashSet<>();//using hashset to remove duplicate
        for(int i=0;i<num.length;i++){
            numSet.add(num[i]);//entri for unique elements in the hashset
        }
        int longestseq=1;//At minimum, a single number is a sequence of length 1.

        for(int nu:numSet){//We loop through each unique number.
            //We only want to start counting from the beginning of a sequence.
            //2 is NOT a start because 1 exists
            //3 is NOT a start because 2 exists
            //1 IS a start because 0 does not exist
            //👉 This avoids unnecessary re-counting and keeps time complexity O(n).
            if(numSet.contains(nu-1)){
                continue;
            }
            else{
                int currNum=nu;//currNum → current number in the sequence
                int currSub=1;//currSub → length of current sequence
                while(numSet.contains(currNum+1)){
                    currNum++;
                    currSub++;
                }
                longestseq=Math.max(longestseq,currSub);//Keeps track of the maximum sequence length found so far.
            }
        }
        return longestseq;
    }
    public static void main(String []args){
        int[] num={100,4,200,1,2,3};
        int result = longcon(num);
        System.out.println(result);
    }
}
