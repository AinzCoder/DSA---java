import java.util.HashSet;
import java.util.Set;

public class DuplicaSlideArr {
    public static boolean containDuplicate(int[] num, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < num.length; i++) {
            if (set.contains(num[i])) {
                return true;
            }
            set.add(num[i]);
            if (set.size() > k) {// current size of hashset is greater than the given input k
                // sliding window
                set.remove(num[i - k]);// remove the earliest entry inside our hashset and contain only the k elements
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int num[] = { 1, 2,3,1,2,3 };
        int k = 3;
        boolean result = containDuplicate(num, k);
        System.out.println("Duplicate exist:" + result);
    }
}
