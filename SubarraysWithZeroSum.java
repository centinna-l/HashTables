import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubarraysWithZeroSum {
    public static List<List<Integer>> findSubarraysWithZeroSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> sumMap = new HashMap<>();
        int sum = 0;

        List<Integer> zeroSumList = new ArrayList<>();
        zeroSumList.add(-1); // Handle subarrays starting from the first element
        result.add(zeroSumList);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sumMap.containsKey(sum)) {
                List<Integer> indices = sumMap.get(sum);
                for (int index : indices) {
                    List<Integer> subarray = new ArrayList<>();
                    for (int j = index + 1; j <= i; j++) {
                        subarray.add(nums[j]);
                    }
                    result.add(subarray);
                }
                indices.add(i);
            } else {
                List<Integer> indices = new ArrayList<>();
                indices.add(i);
                sumMap.put(sum, indices);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 2, -3, -1, 0, 4 };

        List<List<Integer>> subarrays = findSubarraysWithZeroSum(nums);
        System.out.println("Subarrays with zero sum:");
        for (List<Integer> subarray : subarrays) {
            System.out.println(subarray);
        }
    }
}
