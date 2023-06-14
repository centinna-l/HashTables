import java.util.HashMap;
import java.util.Map;

public class ArrayDivisibleIntoPairs {
    public static boolean canDivideIntoPairs(int[] nums, int k) {
        // Count the remainders of elements when divided by k
        Map<Integer, Integer> remainderCount = new HashMap<>();

        for (int num : nums) {
            int remainder = num % k;
            remainderCount.put(remainder, remainderCount.getOrDefault(remainder, 0) + 1);
        }

        for (int num : nums) {
            int remainder = num % k;
            int complement = (k - remainder) % k;

            // If the remainder and its complement have different counts, it is not possible
            // to form a pair
            if (remainderCount.get(remainder) != remainderCount.get(complement)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] nums = { 9, 7, 5, 3 };
        int k = 6;

        boolean canDividePairs = canDivideIntoPairs(nums, k);
        System.out.println("Array can be divided into pairs: " + canDividePairs);
    }
}
