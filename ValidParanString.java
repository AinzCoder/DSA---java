// Greety range approach
public class ValidParanString{


    private static boolean isValid(String s){
        int minOpen = 0;
        int maxOpen = 0;

        for(char c : s.toCharArray()){
            if(c == '('){
                minOpen++;
                maxOpen++;
            }else if(c == ')'){
                minOpen--;
                maxOpen--;
            }else{
                minOpen--;
                maxOpen++;
            }
            if(maxOpen < 0) return false;
            if(minOpen < 0) minOpen = 0;
        }
        return minOpen == 0;
    }

    public static void main(String[] args) {
        String s = "(*))";
        System.out.println(isValid(s));
    }
}