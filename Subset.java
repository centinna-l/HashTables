import java.util.HashMap;

class Subset {
    public static boolean isSubset(int[] array1, int[] array2) {
        HashMap<Integer, Boolean> hashMap = new HashMap<>();
        for (int element : array1) {
            hashMap.put(element, true);
        }
        // check is second array.
        for (int element : array2) {
            if (!hashMap.containsKey(element)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] array1 = { 1, 2, 3, 4, 5, 6 };
        int[] array2 = { 3, 6, 1 };

        if (isSubset(array1, array2)) {
            System.out.println("array2 is a subset of array1");
        } else {
            System.out.println("array2 is not a subset of array1");
        }
    }
}