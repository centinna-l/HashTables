import java.util.HashMap;

public class DistinctElementsWindow {
    public static void countDistinctElements(int[] array, int k) {
        HashMap<Integer, Integer> frequencyTable = new HashMap<>();
        int distinctCount = 0;
        int windowStart = 0;

        for (int i = 0; i < array.length; i++) {
            // Increment the frequency of the current element in the hashtable
            frequencyTable.put(array[i], frequencyTable.getOrDefault(array[i], 0) + 1);

            // Check if the current window size is equal to k
            if (i - windowStart + 1 == k) {
                distinctCount = frequencyTable.size();
                System.out.println("Window " + (windowStart + 1) + "-" + (i + 1) + ": " + distinctCount);

                // Reduce the frequency of the element at windowStart and update distinctCount
                // accordingly
                int startElement = array[windowStart];
                frequencyTable.put(startElement, frequencyTable.get(startElement) - 1);
                if (frequencyTable.get(startElement) == 0) {
                    frequencyTable.remove(startElement);
                }

                windowStart++;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = { 1, 2, 1, 3, 4, 2, 3 };
        int k = 4;

        countDistinctElements(array, k);
    }
}
