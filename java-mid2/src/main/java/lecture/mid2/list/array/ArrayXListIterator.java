package lecture.mid2.list.array;

import java.util.Iterator;

public class ArrayXListIterator<T> implements Iterator<T> {

    private final Object[] items;
    private int index = 0;

    public ArrayXListIterator(Object[] items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        return items.length > index;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T next() {
        return (T) items[index++];
    }
}
