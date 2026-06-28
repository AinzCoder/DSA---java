

public class reDupliSort {
    public static int isCorrect(int[] num){

        int insertIndex=1;//because we have our first value stored in the given input array 
        //that is first value will always be distinct
        for(int i=1;i<num.length;i++){
            //we skip the next index if we see duplicate element
            if(num[i-1]!=num[i]){
                /*storing the unique element at insertIndex index and incrementing the 
                insertIndex by 1 */
                num[insertIndex]=num[i];
                insertIndex++;
            }
        }
        return insertIndex;
   }
   public static void main(String []args){
    int[] num={1,1,2,2,3,5,5};
    int result=isCorrect(num);
    System.out.println("Distint values: " + result);
    for(int i=0;i<result;i++){
        System.out.print(num[i] + " ");
    }
   }
    
}
