package lecture.mid2.list;

public interface XList<T> extends Iterable<T> {

    void add(T item);

    T getIndex(int index);

    int size();

    void put(T item, int index);

    T remove(int index);


}
