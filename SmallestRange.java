import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class SmallestRange {
    static class Element {
        int listIndex;
        int elementValue;

        Element(int listIndex, int elementValue) {
            this.listIndex = listIndex;
            this.elementValue = elementValue;
        }
    }

    public static int[] findSmallestRange(int[][] lists) {
        int k = lists.length;
        int minRangeStart = 0;
        int minRangeEnd = Integer.MAX_VALUE;
        int currentMax = Integer.MIN_VALUE;

        // Hashtable to store the frequency of elements from each list
        HashMap<Integer, Integer> frequencyTable = new HashMap<>();

        // Min heap to store the current minimum and maximum elements
        PriorityQueue<Element> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.elementValue));

        // Initialize the min heap with the first element from each list
        for (int i = 0; i < k; i++) {
            int element = lists[i][0];
            minHeap.offer(new Element(i, element));
            frequencyTable.put(element, 1);
            currentMax = Math.max(currentMax, element);
        }

        while (true) {
            // Remove the minimum element (smallest value) from the heap
            Element minElement = minHeap.poll();
            int rangeStart = minElement.elementValue;
            int rangeEnd = currentMax;

            // Calculate the range based on the minimum element and the current maximum
            if (rangeEnd - rangeStart < minRangeEnd - minRangeStart) {
                minRangeStart = rangeStart;
                minRangeEnd = rangeEnd;
            }

            int listIndex = minElement.listIndex;
            int nextIndex = frequencyTable.get(minElement.elementValue) + 1;

            // If there are no more elements in the list, stop the iteration
            if (nextIndex >= lists[listIndex].length) {
                break;
            }

            int nextElement = lists[listIndex][nextIndex];

            // If the next element is greater than the current maximum, update the current
            // maximum
            if (nextElement > currentMax) {
                currentMax = nextElement;
            }

            // Add the next element to the heap
            minHeap.offer(new Element(listIndex, nextElement));

            // Update the frequency hashtable
            frequencyTable.put(nextElement, frequencyTable.getOrDefault(nextElement, 0) + 1);
            frequencyTable.put(minElement.elementValue, nextIndex);
        }

        return new int[] { minRangeStart, minRangeEnd };
    }

    public static void main(String[] args) {
        int[][] lists = {
                { 4, 7, 9, 12, 15 },
                { 0, 8, 10, 14, 20 },
                { 6, 12, 16, 30, 50 }
        };

        int[] smallestRange = findSmallestRange(lists);
        System.out.println("Smallest range: [" + smallestRange[0] + ", " + smallestRange[1] + "]");
    }
}
