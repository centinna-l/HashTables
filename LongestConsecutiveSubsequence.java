import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSubsequence {
    public static int longestConsecutive(int[] nums) {
        Map<Integer, Boolean> numMap = new HashMap<>();
        int maxLength = 0;

        // Store all numbers in the hashtable
        for (int num : nums) {
            numMap.put(num, true);
        }

        // Iterate over each number in the array
        for (int num : nums) {
            // Check if the current number is the start of a consecutive subsequence
            if (!numMap.containsKey(num - 1)) {
                int currentNum = num;
                int currentLength = 1;

                // Keep incrementing the current number and length until the consecutive
                // subsequence ends
                while (numMap.containsKey(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }

                // Update the maximum length if necessary
                maxLength = Math.max(maxLength, currentLength);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = { 100, 4, 200, 1, 3, 2 };

        int longestLength = longestConsecutive(nums);
        System.out.println("Longest consecutive subsequence length: " + longestLength);
    }
}
