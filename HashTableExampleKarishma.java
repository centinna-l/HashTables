
public class HashTableExampleKarishma {
    private class HashNode {
        private String key;
        private int value;
        private HashNode next;

        HashNode(String key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

    }

    int size;
    HashNode[] table;

    HashTableExampleKarishma(int size) {
        this.size = size;
        table = new HashNode[size];
    }

    int getHash(String key) {
        int hash = key.hashCode() % size;
        return hash < 0 ? hash + size : hash;
    }
    // put

    public void put(String key, int value) {
        int hash = getHash(key);
        HashNode entry = new HashNode(key, value);
        if (table[hash] == null) {
            table[hash] = entry;
        } else {
            HashNode current = table[hash];
            while (current.next != null) {
                if (current.key.equals(key)) {
                    current.value = value;
                } else {
                    entry.next = current;
                    table[hash] = entry;
                }
                current = current.next;
            }
        }
    }
    // get

    public int get(String key) {
        int hash = getHash(key);
        if (table[hash] == null) {
            return -1;
        }
        return table[hash].value;
    }
    // remove

    public void remove(String key) {
        int hash = getHash(key);
        if (table[hash] == null) {
            return;
        }
        table[hash] = table[hash].next;
    }
}
