class OccurancesPartTwo {
    public static int countOccurrences(int[] arr, int x) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                count++;
            } else if (arr[i] > x) {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 3, 3, 3, 4, 5, 5, 5 };
        int x = 3;
        int occurrences = countOccurrences(arr, x);
        System.out.println(occurrences);
    }
}