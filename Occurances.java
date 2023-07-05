public class Occurances {
    public static int countNumberOfOccurrences(int[] arr, int x) {
        int firstIndex = findFirstIndex(arr, x);
        if (firstIndex == -1) {
            return 0; // Element not found, no occurrences
        }
        int lastIndex = findLastIndex(arr, x);
        return (lastIndex - firstIndex + 1);
    }

    private static int findFirstIndex(int[] arr, int x) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == x) {
                result = mid;
                right = mid - 1; // Continue searching in the left subarray
            } else if (arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    private static int findLastIndex(int[] arr, int x) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == x) {
                result = mid;
                left = mid + 1; // Continue searching in the right subarray
            } else if (arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 2, 3, 4, 5, 5, 5, 6 };
        int x = 2;

        int occurrences = countNumberOfOccurrences(arr, x);
        System.out.println(occurrences);
    }
}
