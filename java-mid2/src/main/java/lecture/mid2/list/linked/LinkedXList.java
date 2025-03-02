package lecture.mid2.list.linked;

import lecture.mid2.list.XList;

import java.util.Iterator;

public class LinkedXList<T> implements XList<T> {

    private Node<T> firstNode;
    private int size = 0;

    @Override
    public void add(T item) {
        Node<T> newNode = new Node<>(item);
        if (size++ == 0) {
            firstNode = newNode;
            return;
        }
        getLastNode().setNext(newNode);
    }

    private Node<T> getLastNode() {
        Node<T> currentNode = firstNode;
        while (!currentNode.isLast()) {
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }

    @Override
    public T getIndex(int index) {
        Node<T> currentNode = getCurrentNode(index);
        return currentNode.getItem();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void put(T item, int index) {
        Node<T> newNode = new Node<>(item);
        Node<T> currentNode = getCurrentNode(index);
        size++;
        newNode.setNext(currentNode.getNext());
        currentNode.setNext(newNode);
    }

    @Override
    public T remove(int index) {
        Node<T> currentNode = getCurrentNode(index);
        T result = currentNode.getItem();
        Node<T> preNode = getCurrentNode(index-1);
        preNode.setNext(currentNode.getNext());
        currentNode.setNext(null);
        size--;
        return result;
    }

    private Node<T> getCurrentNode(int index) {
        Node<T> currentNode = firstNode;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
