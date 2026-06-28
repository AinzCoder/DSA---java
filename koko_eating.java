// Find the minimum eating speed (k) such that Koko can finish all bananas within h hours.
// There is a range of speeds, and we want the minimum valid speed

// This is why we use binary search



// public class koko_eating {
//     public static int minEatingSpeed(int[] piles,int h){
//         int left=1,right=1;
//         for(int pile : piles){
//             right=Math.max(right,pile);
//         }

//         while(left<right){
//             int mid=(left+right)/2;
            
//             // Can Koko finish all bananas at speed = mid within h hours?

//             if(canFinish(piles,mid,h)){
//                 right=mid;  //Try smaller speed (we want minimum)
//             }
//             else{
//                 left=mid+1;
//             }
//         }
//         return left;
//     }
//     public static boolean canFinish(int[] piles,int speed,int h){
//         int hours=0;
//         for(int pile:piles){
// // Why ceil?Because:
// // If pile = 7, speed = 3
// // 7/3 = 2.33 → needs 3 hours, not 2

//             hours +=Math.ceil((double)pile/speed);
//         }
//         return hours <= h;
//     }
//     public static void main(String []args){
//         int[] num={3,6,7,11};
//         int h=8;
//         int result = minEatingSpeed(num, h);
//         System.out.println(result);
//     }
// }

// OLD → “Keep shrinking until both meet”

// NEW → “Eliminate impossible values”
class koko_eating {
    public static int minEatingSpeed(int[] piles, int h) {
        int l =1;
        int r = getMax(piles);
        while(l<=r){
            int mid = l + (r-l)/2; // Why this is better: Prevents integer overflow Safer than (l + r) / 2
            if(canFinish(mid,piles,h)){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return  l;
    }
    public static boolean canFinish(int mid, int[] piles, int h){
        long hours = 0;
        for(int i : piles){
           hours += (i + mid - 1) / mid; //No floating point operations
// i = 7, mid = 3
// (i + mid - 1) / mid
// = (7 + 3 - 1) / 3
// = 9 / 3 = 3

        }
        return hours<=h;

    }
    public static int getMax(int[] piles){
        int max =0;
        for(int i:piles){
            if(i>max){
                max = i;
            }
        }
        return max;
    }
        public static void main(String []args){
        int[] num={3,6,7,11};
        int h=8;
        int result = minEatingSpeed(num, h);
        System.out.println(result);
    }
}