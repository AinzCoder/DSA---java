
import java.util.Arrays;
// import java.util.Comparator;

public class largest_num {
    public static String largestNum(int[] num){
        //convert int array to string array, so we can sort later
        String[] asStr = new String[num.length];
        for(int i=0;i<num.length;i++){
            asStr[i]=String.valueOf(num[i]);
        }
        //sort string according to the custom comparator
        // Arrays.sort(asStr,new Comparator<String>(){
        //     @Override
        //     public int compare(String a,String b){
        //         String order1 = a + b;
        //         String order2 = b + a;
        //         return order2.compareTo(order1); //because we want descending order
        //     }
        // });

        //or use lambda because comparator is a function interface it has only one method compare()
        Arrays.sort(asStr, (a,b) -> (b + a).compareTo(a + b));


        //if after being sorted the largest number is "0" return 0
        if(asStr[0].equals("0")){
            return "0";
        }

        //build largest number from sorted array
        var largestNumStr = new StringBuilder();
        for(String numAsStr: asStr){
            largestNumStr.append(numAsStr);
        }
        return largestNumStr.toString();
    }
    public static void main(String []args){
        int[] num={10,2};
        String result = largestNum(num);
        System.out.println(result);
    }
    
}
