public class longComPreStr {
    public static String longestCom(String[] str){
        if(str==null || str.length==0){
            return "";
        }
        //start with first string in the array as the initial prefix
        // start with the first string as prefix
        String prefix=str[0];
        //compare the current prefix with each string in the array
        // compare prefix with remaining strings
        for(int i=1;i<str.length;i++){
            //i=1 because 0th element is already taken
            //narrow down the prefix with each comparision
            // reduce prefix until it matches the start of str[i]
            while(str[i].indexOf(prefix)!=0){
                //shorten the prefix by one character from the end
                prefix=prefix.substring(0,prefix.length()-1);

                //if the prefix becomes empty there is no common prefix
                if(prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
    public static void main(String []args){
        String[] s={"flow","flower","float","flight"};
        String result=longestCom(s);
        System.out.println(result);
    }
}
