import java.util.HashMap;

public class FindPairs {

    public static void findPairs(int[] array1, int targetSum) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < array1.length; i++) {
            int complement = targetSum - array1[i];
            if (hashMap.containsKey(complement)) {
                int complementIndex = hashMap.get(complement);
                System.out.println("Pair found: " + array1[complementIndex] + ", " + array1[i]);
                return;
            }
            hashMap.put(array1[i], i);
        }
        System.out.println("No Pairs Found");
    }

    public static void main(String[] args) {
        int[] array = { 1, 4, 5, 7, 9, 12 };
        int targetSum = 13;

        findPairs(array, targetSum);
    }
}
