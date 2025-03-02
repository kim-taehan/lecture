package lecture.mid2.list.array;

import lecture.mid2.list.XList;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayXList<T> implements XList<T> {

    private static final int DEFAULT_CAPACITY = 10;

    private Object[] items;
    private int size = 0;

    public ArrayXList(int capacity) {
        items = new Object[capacity];
    }

    public ArrayXList() {
        items = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void add(T t) {
        // 배열이 가득 차 있는 경우 배열의 크기를 증가시킨다.
        if(items.length == size) {
            growSize();
        }
        items[size++] = t;
    }

    /**
     * 배열이 가득 차 있는 경우 배열의 크기를 증가시킨다.
     */
    private void growSize() {
        int currentLength = items.length;
        items = Arrays.copyOf(items, currentLength * 2);
    }

    @SuppressWarnings("unchecked")
    @Override
    public T getIndex(int index) {
        return (T) items[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void put(T item, int index) {
        // 배열이 가득 차 있는 경우 배열의 크기를 증가시킨다.
        if(items.length == size) {
            growSize();
        }
        shiftRight(index);
        size++;
        items[index] = item;
    }

    private void shiftRight(int index) {
        // index 부터 한칸씩 증가시킨다.
        for (int i = size; i > index; i--) {
            items[i] = items[i - 1];
        }
    }

    @Override
    public T remove(int index) {

        Object currentItem = items[index];
        shiftLeft(index);
        size--;


        return (T) currentItem;
    }

    private void shiftLeft(int index) {
        for (int i = index; i < size-1; i++) {
            items[i] = items[i + 1];
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayXListIterator<>(items);
    }
}
