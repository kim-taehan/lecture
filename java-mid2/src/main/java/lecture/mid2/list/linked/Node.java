package lecture.mid2.list.linked;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

public class Node<T> {

    @Setter
    @Getter
    private Node<T> next;

    @Getter
    private final T item;

    public Node(T item) {
        this.item = item;
    }

    public boolean isLast() {
        return next == null;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Node<?> node = (Node<?>) object;
        return Objects.equals(next, node.next) && Objects.equals(item, node.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(next, item);
    }
}
