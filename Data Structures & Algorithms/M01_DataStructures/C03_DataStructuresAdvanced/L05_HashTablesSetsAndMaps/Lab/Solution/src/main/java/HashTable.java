import java.util.Iterator;

public class HashTable<K, V> implements Iterable<KeyValue<K, V>> {

    public HashTable() {

    }

    public HashTable(int capacity) {

    }

    public void add(K key, V value) {
        throw new UnsupportedOperationException();
    }

    private int findSlotNumber(K key) {
        throw new UnsupportedOperationException();
    }

    private void growIfNeeded() {
        throw new UnsupportedOperationException();
    }

    private void grow() {
        throw new UnsupportedOperationException();
    }

    public int size() {
        throw new UnsupportedOperationException();
    }

    public int capacity() {
        throw new UnsupportedOperationException();
    }

    public boolean addOrReplace(K key, V value) {
        throw new UnsupportedOperationException();
    }

    public V get(K key) {
        throw new UnsupportedOperationException();
    }

    public KeyValue<K, V> find(K key) {
        throw new UnsupportedOperationException();
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
        throw new UnsupportedOperationException();
    }
}
