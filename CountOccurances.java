public class CountOccurances {
    public static int countOccurrences(int[] arr, int x) {
        int firstIndex = findFirstIndex(arr, x);
        int lastIndex = findLastIndex(arr, x);

        if (firstIndex == -1 || lastIndex == -1) {
            // Element not found
            return 0;
        }

        return (lastIndex - firstIndex + 1);
    }

    private static int findFirstIndex(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == x) {
                result = mid;
                high = mid - 1; // Continue searching on the left side
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }

    private static int findLastIndex(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == x) {
                result = mid;
                low = mid + 1; // Continue searching on the right side
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 2, 3, 3, 4, 5, 5, 5, 5 };
        int x = 2;
        int occurrences = countOccurrences(arr, x);
        System.out.println(occurrences);
    }
}
