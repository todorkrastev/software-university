import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class HashTable<K, V> implements Iterable<KeyValue<K, V>> {
    private static final int INITIAL_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.80d;

    private LinkedList<KeyValue<K, V>>[] slots;

    private int count;
    private int capacity;

    public HashTable() {
        this(INITIAL_CAPACITY);
    }

    public HashTable(int capacity) {
        this.slots = new LinkedList[capacity];

        this.count = 0;
        this.capacity = capacity;
    }

    public void add(K key, V value) {
        this.growIfNeeded();

        int index = this.findSlotNumber(key);

        LinkedList<KeyValue<K, V>> list = this.slots[index];

        if (list == null) {
            list = new LinkedList<>();
        }

        for (KeyValue<K, V> current : list) {
            if (current.getKey().equals(key)) {
                throw new IllegalArgumentException("Key already exists " + key);
            }
        }
        KeyValue<K, V> toInsert = new KeyValue<>(key, value);
        list.addLast(toInsert);

        this.slots[index] = list;
        this.count++;
    }

    private int findSlotNumber(K key) {
        return Math.abs(key.hashCode()) % this.capacity;
    }

    private void growIfNeeded() {
        if (false) {
            this.grow();
        }
    }

    private void grow() {
        throw new UnsupportedOperationException();
    }

    public int size() {
        return this.count;
    }

    public int capacity() {
        return this.capacity;
    }

    public boolean addOrReplace(K key, V value) {
        throw new UnsupportedOperationException();
    }

    public V get(K key) {
        throw new UnsupportedOperationException();
    }

    public KeyValue<K, V> find(K key) {
        int index = this.findSlotNumber(key);

        LinkedList<KeyValue<K, V>> slot = this.slots[index];

        if (slot == null) {
            return null;
        }

        for (KeyValue<K, V> current : slot) {
            if (current.getKey().equals(key)) {
                return current;
            }
        }

        return null;
    }

    public boolean containsKey(K key) {
        throw new UnsupportedOperationException();
    }

    public boolean remove(K key) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        throw new UnsupportedOperationException();
    }

    public Iterable<K> keys() {
        throw new UnsupportedOperationException();
    }

    public Iterable<V> values() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<KeyValue<K, V>> iterator() {
        return new Iterator<KeyValue<K, V>>() {
            int passedThroughCount = 0;
            int currentIndex = 0;
            Deque<KeyValue<K, V>> elements = new ArrayDeque<>();


            @Override
            public boolean hasNext() {
                return passedThroughCount < count;
            }

            @Override
            public KeyValue<K, V> next() {
                if (!elements.isEmpty()) {
                    return elements.poll();
                }

                while (slots[currentIndex] == null) {
                    currentIndex++;
                }
                elements.addAll(slots[currentIndex]);

                passedThroughCount += slots[currentIndex].size();
                currentIndex++;

                return elements.poll();
            }
        };
    }
}
