import java.util.HashMap;
import java.util.Map;

public class Example {

    public static String getMostFrequency(String[] array) {
        Map<String, Integer> hashtable = new HashMap<>();

        for (String element : array) {
            if (hashtable.containsKey(element)) {
                hashtable.put(element, hashtable.get(element) + 1);
            } else {
                hashtable.put(element, 1);
            }
        }
        // Find the most frequent element
        String mostFrequentElement = null;
        int maxFrequency = 0;

        for (Map.Entry<String, Integer> entry : hashtable.entrySet()) {
            String element = entry.getKey();
            int frequency = entry.getValue();

            if (frequency > maxFrequency) {
                mostFrequentElement = element;
                maxFrequency = frequency;
            }
        }

        return mostFrequentElement;
    }

    public static void main(String[] args) {
        String[] array = { "apple", "banana", "apple", "orange", "banana", "apple" };
        String mostFrequent = getMostFrequency(array);
        System.out.println("Most frequent element: " + mostFrequent);
    }
}
