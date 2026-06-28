import java.util.ArrayList;
import java.util.List;

public class textJustification {
    public static List<String> isjustification(String[] words,int maxwidth){
        List<String> lines = new ArrayList<>();
        //This will store the final justified text line by line.
        int index=0;
        while(index< words.length){//Each iteration creates one line.
            int count = words[index].length();//Count how many words fit in the current line
            int last = index+1;//keep track of last word 
            while(last<words.length){//last is less than current words length
                //if adding the next word exceeds the maxwidth ,break
                if(count + 1 + words[last].length()> maxwidth) break;
                //+1 → space between words
                //Words from index to last - 1 will be in the current line
                count += 1 + words[last].length();//if it does not exceed increase over counter& last pointer as well
                last++;
            }
            //value of words to be included in one single string
            StringBuilder sb =new StringBuilder();//Start with the first word of the line
            sb.append(words[index]);//words that are currently present at the index
            int diff = last-index-1;//diff = number of spaces (gaps) between words

            //if we are on the last line or the line as only one word, left-justify
            if(last==words.length || diff==0){//Last line of text OR Line has only one word
                //Add words with single spaces
                for(int i=index+1;i<last;i++){
                    sb.append(" ");
                    sb.append(words[i]);
                }//justification example
                //Pad remaining spaces at the end
                //Ensures line length equals maxwidth.
                for(int i=sb.length();i<maxwidth;i++){
                    sb.append(" ");
                }
            }else{//Now we distribute spaces evenly.
                //calculater space
                //else calculate how many spaces we need to do
                int space = (maxwidth - count) /diff;//space → minimum spaces per gap
                int extraspace=(maxwidth-count) % diff;//extraspace → leftover spaces (added from left)
                //Add evenly distributed spaces
                //Extra spaces go to leftmost gaps
                //Add next word
                for(int i=index+1;i<last;i++){
                    for(int s=space;s>0;s--){
                        sb.append(" ");
                    }
                    if(extraspace>0){
                        sb.append(" ");
                        extraspace--;
                    }
                    sb.append(" ");
                    sb.append(words[i]);
                }
            }
            //add all the string we have created
            lines.add(sb.toString());
            index=last;
        }
        return lines;//initiated originally in the array list as answer
    }
    public static void main(String []args){
        String[] str={"this","is","an","exapmle","of","an","justification"};
        int width=16;
        List<String> result = isjustification(str, width);
        System.out.println(result);
    } 
}