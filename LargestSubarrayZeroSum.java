import java.util.Arrays;
import java.util.HashMap;

public class LargestSubarrayZeroSum {
    public static void findLargestSubarray(int[] array) {
        HashMap<Integer, Integer> sumTable = new HashMap<>();
        int maxLen = 0;
        int endIndex = -1;
        int sum = 0;

        sumTable.put(0, -1); // Initialize the hashtable with a sum of 0 at index -1

        for (int i = 0; i < array.length; i++) {
            sum += array[i];

            if (sumTable.containsKey(sum)) {
                int len = i - sumTable.get(sum);
                if (len > maxLen) {
                    maxLen = len;
                    endIndex = i;
                }
            } else {
                sumTable.put(sum, i);
            }
        }

        if (endIndex != -1) {
            int startIndex = endIndex - maxLen + 1;
            int[] subarray = new int[maxLen];
            System.arraycopy(array, startIndex, subarray, 0, maxLen);
            System.out.println("Largest subarray with sum 0: " + Arrays.toString(subarray));
        } else {
            System.out.println("No subarray with sum 0 found");
        }
    }

    public static void main(String[] args) {
        int[] array = { 4, 2, -3, 1, 6, -7, -2, 7, 9, -5, 1, -4 };

        findLargestSubarray(array);
    }
}
