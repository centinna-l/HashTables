public class HashTableExample {
    private int size;
    private HashNode[] table;

    public HashTableExample(int size) {
        this.size = size;
        this.table = new HashNode[size];
    }

    private class HashNode {
        private String key;
        private int value;
        private HashNode next;

        public HashNode(String key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private int getHash(String key) {
        int hash = key.hashCode() % size;
        return (hash < 0) ? hash + size : hash;
    }

    public void put(String key, int value) {
        int hash = getHash(key);
        HashNode newNode = new HashNode(key, value);
        if (table[hash] == null) {
            table[hash] = newNode;
        } else {
            HashNode current = table[hash];
            while (current.next != null) {
                if (current.key.equals(key)) {
                    current.value = value;
                    return;
                }
                current = current.next;
            }
            if (current.key.equals(key)) {
                current.value = value;
            } else {
                current.next = newNode;
            }
        }
    }

    public int get(String key) {
        int hash = getHash(key);
        HashNode current = table[hash];

        while (current.next != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return -1;
    }

    public void remove(String key) {
        int hash = getHash(key);
        HashNode current = table[hash];

        if (current == null) {
            return;
        }
        HashNode prev = null;

        while (current.next != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    table[hash] = current.next;
                } else {
                    prev.next = current.next;
                }
                return;
            }
            prev = current;
            current = current.next;
        }

    }
}
