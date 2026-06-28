public class Median_sort {
    public static double findMedianSortedArray(int[] num1,int[] num2){
        if(num1.length>num2.length){
            return findMedianSortedArray(num2, num1);
        }
        int x=num1.length;
        int y=num2.length;

        int start = 0;
        int end=x;

        while(start <= end){
            // We divide arrays into left half and right half
            int partX = (start + end)/2; //
            int partY = (x + y + 1)/2 - partX; //Works for 0-based indexing

            //  To handle edge case
            // Case	Value
            // No left elements	-∞ (MIN_VALUE)
            // No right elements	+∞ (MAX_VALUE)
            int xLeft = (partX == 0)? Integer.MIN_VALUE : num1[partX-1];
            int xRight = (partX == x)? Integer.MAX_VALUE : num1[partX];

            int yLeft = (partY == 0)? Integer.MIN_VALUE : num2[partY-1];
            int yRight = (partY == y)? Integer.MAX_VALUE : num2[partY];
            
            // All left elements ≤ all right elements
            if(xLeft <= yRight && yLeft <= xRight){
                // for even 
                //  Median = average of middle two values
                if((x + y) % 2 == 0){
                    return ((double)Math.max(xLeft,yLeft) + Math.min(xRight,yRight))/2;
                }
                else{
                    // for odd
                    // Median = max of left side
                    return Math.max(xLeft,yLeft);
                }
            }
            // Too far right in num1
            else if(xLeft > yRight){
                end = partX-1; // Move left
            }
            else{
                // Too far left
                start = partX+1; // Move right
            }
        }
        return 0;
    }
    public static void main(String []args){
        int[] num1={1,3};
        int[] num2={2};

        double result = findMedianSortedArray(num1, num2);
        System.out.println("Median: " + result);
    }
}
