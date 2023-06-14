import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromeSubstringQueries {
    public static List<Integer> palindromeSubstringQueries(String s, List<List<Integer>> queries) {
        // Preprocess the string to handle even-length palindromes
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for (char c : s.toCharArray()) {
            sb.append(c);
            sb.append("#");
        }

        String modifiedString = sb.toString();
        int n = modifiedString.length();
        int[] p = new int[n]; // Array to store the lengths of palindromic substrings centered at each
                              // position
        int center = 0; // Center position of the current longest palindromic substring
        int right = 0; // Rightmost position of the current longest palindromic substring

        // Fill the p array using Manacher's algorithm
        for (int i = 1; i < n - 1; i++) {
            int mirror = 2 * center - i;

            if (right > i) {
                p[i] = Math.min(right - i, p[mirror]);
            }

            // Attempt to expand the palindrome centered at i
            while (modifiedString.charAt(i + 1 + p[i]) == modifiedString.charAt(i - 1 - p[i])) {
                p[i]++;
            }

            // Update the center and rightmost positions if necessary
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }
        }

        // Create a hashtable to store the counts of palindromic substrings
        Map<Integer, Integer> countTable = new HashMap<>();
        for (int length : p) {
            countTable.put(length, countTable.getOrDefault(length, 0) + 1);
        }

        // Create a cumulative count table for efficient querying
        int totalCount = 0;
        Map<Integer, Integer> cumulativeTable = new HashMap<>();
        for (int length : countTable.keySet()) {
            totalCount += countTable.get(length);
            cumulativeTable.put(length, totalCount);
        }

        // Process the queries
        List<Integer> result = new ArrayList<>();
        for (List<Integer> query : queries) {
            int k = query.get(0);

            // Binary search to find the largest palindrome length less than or equal to k
            int left = 1;
            int rightBound = modifiedString.length() - 2;
            int maxLength = -1;

            while (left <= rightBound) {
                int mid = left + (rightBound - left) / 2;
                int count = cumulativeTable.getOrDefault(mid, 0);

                if (count <= k) {
                    maxLength = mid;
                    left = mid + 1;
                } else {
                    rightBound = mid - 1;
                }
            }

            result.add(maxLength);
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "ababa";
        List<List<Integer>> queries = new ArrayList<>();
        queries.add(List.of(2));
        queries.add(List.of(3));
        queries.add(List.of(4));
        queries.add(List.of(5));

        List<Integer> result = palindromeSubstringQueries(s, queries);
        System.out.println("Query Results: " + result);
    }
}
