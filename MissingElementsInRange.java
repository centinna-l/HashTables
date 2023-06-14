import java.util.HashMap;
import java.util.Map;

public class MissingElementsInRange {
    public static void findMissingElements(int[] range, int start, int end) {
        Map<Integer, Boolean> elementMap = new HashMap<>();

        // Store the elements of the range in the hashtable
        for (int num : range) {
            elementMap.put(num, true);
        }

        System.out.println("Missing elements in the range " + start + " to " + end + ":");
        // Iterate over the entire range and check for missing elements
        for (int i = start; i <= end; i++) {
            if (!elementMap.containsKey(i)) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        int[] range = { 1, 3, 5, 7, 9 };
        int start = 1;
        int end = 10;

        findMissingElements(range, start, end);
    }
}
