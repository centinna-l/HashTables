import java.util.HashMap;
import java.util.Map;

public class LargestSubarrayWithEqualZerosAndOnes {
    public static int findLargestSubarray(int[] nums) {
        int maxLength = 0;
        int prefixSum = 0;
        Map<Integer, Integer> sumToIndex = new HashMap<>();

        sumToIndex.put(0, -1); // Initialize the hashtable with a prefix sum of 0 at index -1

        for (int i = 0; i < nums.length; i++) {
            // Convert 0s to -1 to calculate the prefix sum
            if (nums[i] == 0) {
                prefixSum -= 1;
            } else {
                prefixSum += 1;
            }

            if (sumToIndex.containsKey(prefixSum)) {
                int startIndex = sumToIndex.get(prefixSum);
                int currentLength = i - startIndex;

                maxLength = Math.max(maxLength, currentLength);
            } else {
                sumToIndex.put(prefixSum, i);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 1, 0, 1, 0, 1 };
        int largestSubarrayLength = findLargestSubarray(nums);
        System.out.println("Largest subarray with equal 0s and 1s: " + largestSubarrayLength);
    }
}
