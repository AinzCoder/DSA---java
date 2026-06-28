import java.util.HashSet;


public class DuplicatArr {
    public static boolean containsDuplicate(int[] num){
        HashSet<Integer> seen = new HashSet<>();
        for(int n:num){
            if(seen.contains(n)){//contains checks for duplicate values
                return true;
            }
            seen.add(n);//saves the number so next time we see it
        }
        return false;
    }
    public static void main(String [] args){
        int num[]={4,8,5,6,2,6};
        boolean result=containsDuplicate(num);
        System.out.println("Duplicate Exist: " + result);
    }
}
