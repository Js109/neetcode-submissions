public class Main {

    public static void main(String[] args) {
        MyHashTable<String, Integer> ages = new MyHashTable<>(8);

        ages.put("Alice", 30);
        ages.put("Bob", 25);
        ages.put("Alice", 31); // Update an existing key
        ages.put("Charlie", 28);

        System.out.println("Alice's age: " + ages.get("Alice"));
        System.out.println("Bob's age: " + ages.get("Bob"));
        System.out.println("Table size: " + ages.size());

        System.out.println("Removed Bob: " + ages.remove("Bob"));
        System.out.println("Bob after removal: " + ages.get("Bob"));

        MyHashTable<String, String> phoneBook = new MyHashTable<>();
        phoneBook.put("Alice", "123-456");
        phoneBook.put("Bob", "987-654");
        System.out.println("Alice's phone: " + phoneBook.get("Alice"));

        SimpleHashTable simpleTable = new SimpleHashTable();
        simpleTable.put("Java", "Programming language");
        simpleTable.put("HashMap", "A hash-based collection");
        simpleTable.put("Java", "Updated value");

        System.out.println("Java value: " + simpleTable.get("Java"));
        System.out.println("HashMap value: " + simpleTable.get("HashMap"));
    }

    private static class MyHashTable<K, V> {

        // Single node for a key-value pair and chaining in case of collisions
        private static class Node<K, V> {
            final K key;
            V value;
            Node<K, V> next;

            Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private Node<K, V>[] buckets;
        private int capacity;
        private int size;

        public MyHashTable(int capacity) {
            this.capacity = capacity;
            this.buckets = new Node[capacity];
            this.size = 0;
        }

        public MyHashTable() {
            this(16); // Default capacity
        }

        // Converts the key hash code into a valid array index
        private int getBucketIndex(K key) {
            if (key == null) return 0;
            // Math.abs prevents negative hash values
            return Math.abs(key.hashCode()) % capacity;
        }

        // PUT: Insert or update
        public void put(K key, V value) {
            int index = getBucketIndex(key);
            Node<K, V> head = buckets[index];

            // 1. Check whether the key already exists (overwrite)
            Node<K, V> current = head;
            while (current != null) {
                if (equalsKey(current.key, key)) {
                    current.value = value;
                    return;
                }
                current = current.next;
            }

            // 2. Insert the new node at the beginning of the list (O(1))
            Node<K, V> newNode = new Node<>(key, value);
            newNode.next = head;
            buckets[index] = newNode;
            size++;
        }

        // GET: Retrieve a value
        public V get(K key) {
            int index = getBucketIndex(key);
            Node<K, V> current = buckets[index];

            while (current != null) {
                if (equalsKey(current.key, key)) {
                    return current.value;
                }
                current = current.next;
            }
            return null; // Key not found
        }

        // REMOVE: Delete a value
        public V remove(K key) {
            int index = getBucketIndex(key);
            Node<K, V> current = buckets[index];
            Node<K, V> prev = null;

            while (current != null) {
                if (equalsKey(current.key, key)) {
                    if (prev != null) {
                        prev.next = current.next;
                    } else {
                        buckets[index] = current.next;
                    }
                    size--;
                    return current.value;
                }
                prev = current;
                current = current.next;
            }
            return null;
        }

        public int size() {
            return size;
        }

        // Helper method for null-safe comparison
        private boolean equalsKey(K k1, K k2) {
            if (k1 == k2) return true;
            if (k1 == null || k2 == null) return false;
            return k1.equals(k2);
        }
    }

    private static class SimpleHashTable {
        private String[] keys = new String[16];
        private String[] values = new String[16];

        // Insert or update a key-value pair.
        public void put(String key, String value) {
            int idx = Math.abs(key.hashCode()) % keys.length;
            // If there is a collision, keep moving forward (linear probing)
            while (keys[idx] != null && !keys[idx].equals(key)) {
                idx = (idx + 1) % keys.length;
            }
            keys[idx] = key;
            values[idx] = value;
        }

        // Retrieve a value by key.
        public String get(String key) {
            int idx = Math.abs(key.hashCode()) % keys.length;
            while (keys[idx] != null) {
                if (keys[idx].equals(key)) return values[idx];
                idx = (idx + 1) % keys.length;
            }
            return null;
        }
    }
}