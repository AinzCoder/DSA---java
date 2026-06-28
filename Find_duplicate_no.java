public class Find_duplicate_no {

    // Think of array as a linked list

    private static int findDuplicate(int[] num){

        //We are NOT moving in the array by index — we are jumping using values
        // Value itself tells where to go next

        //slow = num[0] = 1
        // fast = num[num[0]] = num[1] = 2

        // You stand at index i
        // num[i] tells you where to go next

        //initialize slow and fast variable
        int slow = num[0];
        // Go to index = slow
        // Then pick value at that index
        int fast = num[num[0]];

        //find the intersection point of two pointers
        //fast poointer is inside the cycle

        while(slow != fast){
            slow = num[slow];
            fast = num[num[fast]];
        }

        //kicking out the slow pointer outside the cycle
        slow=0;
        while(slow != fast){
            slow = num[slow];
            fast = num[fast];

        }
        return slow;
    }

    public static void main(String []args){
        int[] num={1,2,3,4,5,4,6};
        int result = findDuplicate(num);
        System.out.println(result);
    }
    
}
