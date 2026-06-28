import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
//Deque → allows insertion/removal from both ends
//LinkedList → implementation of Deque
//Arrays → for printing the result
public class slidingWindMax {
    public static int[] isSlidMax(int[] num,int k){
        //if k is zero return an empty array
        if(num==null || num.length==0 || k<=0){
            return new int[0];
        }
        //Why store indices in deque?
        //To easily remove elements outside the window
        //To compare values using num[index]
        int n=num.length;
        int[] result = new int[n-k+1];//window
        Deque<Integer> deque = new LinkedList<>();
       
        //iterating over the given list
        for(int i=0;i<n;i++){
            //remove the indices that are out of current window
            //check the given queue is not empty and the very first element is the largest element 
            //Current window range = i - k + 1 to i
            //If an index is less than i - k + 1, it is outside the window
            //Remove it from the front
            while(!deque.isEmpty() && deque.peek() < i-k+1){
                deque.poll();
            }
            //remove indices whose coresponding value is less than num[i]
            //iterate over the smaller element in the given current value
            //then keep iterating and keep removing them

            //Smaller elements can never be the maximum if a bigger number comes after them
            //Keep deque in decreasing order of values
            while(!deque.isEmpty() && num[deque.peekLast()]<num[i]){
                deque.pollLast();//deque.pollLast() -removes and returns the last element from the deque.
            }
            //add current index to the queue
            //Add current index at the end
            //Deque still maintains decreasing order
            deque.offer(i);//deque.offer(element) - adds an element to the end (tail) of the deque.

            //add the maximum element of the current window to result
            //Window becomes valid only after i >= k - 1
            //The front of deque always contains the index of the maximum element
            //Store that value in the result array
            if(i>=k-1){//because k starts with 0
                result[i-k+1]=num[deque.peek()];//max value is located at the very first location of the queue
            }
        }
        return result;
    }
    public static void main(String []args){
        int[] num={1,3,-1,-3,5,3,6,7};
        int k=3;
        int[] result=isSlidMax(num, k);
        System.out.println(Arrays.toString(result));
    }
}
