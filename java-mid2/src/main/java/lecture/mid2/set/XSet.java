package lecture.mid2.set;

public interface XSet<T> {

    boolean add(T value);

    boolean contains(T searchValue);

    boolean remove(T value);

    int getSize();
}
