
import java.util.ArrayList;
import java.util.List;

public class fizzBuzzstr {
    public static List<String> isFizz(int num){
        List<String> result = new ArrayList<>();
        for(int i=1;i<=num;i++){
            if(i % 3==0 || i % 5==0){
                //number is divisible by 3 and 5
                result.add("FizzBuzz");
            }
            else if(i % 3==0){
                //num is divisible by 3
                result.add("Fizz");
            }
            else if(i % 5==0){
                //num is divisible is 5
                result.add("Buzz");
            }
            else{
                //when num is not divisible by both 3 and 5
                result.add(Integer.toString(i));
            }
        }
        return result;
    }
    public static void main(String [] args){
        int num=3;
        List<String> result=isFizz(num);
        System.out.println(result);
    }    
}
