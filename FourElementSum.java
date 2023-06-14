import java.util.HashMap;

public class FourElementSum {
    public static void findFourElements(int[] array) {
        HashMap<Integer, Pair> sumTable = new HashMap<>();
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int sum = array[i] + array[j];
                Pair pair = new Pair(array[i], array[j]);
                sumTable.put(sum, pair);
            }
        }

        // Step 2: Check if the complement of the sum exists in the hashtable
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int sum = array[i] + array[j];
                if (sumTable.containsKey(sum)) {
                    Pair pair = sumTable.get(sum);
                    System.out.println("a = " + pair.a + ", b = " + pair.b + ", c = " + array[i] + ", d = " + array[j]);
                    return;
                }
            }
        }

        System.out.println("No such elements found");
    }

    public static void main(String[] args) {
        int[] array = { 3, 4, 7, 1, 2, 9, 8 };

        findFourElements(array);
    }
}

class Pair {
    int a, b;

    Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }
}
