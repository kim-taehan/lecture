package lecture.mid2.set;

import java.util.LinkedList;
import java.util.List;

public class HashXSet<T> implements XSet<T> {

    static final int DEFAULT_INITIAL_CAPACITY = 16;
    List<T>[] buckets;

    private int size = 0;
    private int capacity = DEFAULT_INITIAL_CAPACITY;

    public HashXSet() {
        initBuckets();
    }

    public HashXSet(int capacity) {
        this.capacity = capacity;
        initBuckets();
    }

    private void initBuckets() {
        buckets = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList<>();
        }
    }
    @Override
    public boolean add(T value) {
        List<T> bucket = buckets[hashIndex(value)];
        if (bucket.contains(value)) {
            return false;
        }
        size++;
        bucket.add(value);
        return true;
    }

    private int hashIndex(T value) {
        return value.hashCode() % capacity;
    }

    @Override
    public boolean contains(T searchValue) {
        List<T> bucket = buckets[hashIndex(searchValue)];
        return bucket.contains(searchValue);
    }

    @Override
    public boolean remove(T value) {
        List<T> bucket = buckets[hashIndex(value)];
        return  bucket.remove(value);
    }

    @Override
    public int getSize() {
        return size;
    }
}
