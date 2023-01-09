package ru.aberezhnoy.homework02;

public class MyLinkedList<E> implements MyList<E> {
    private Node<E> first;
    private Node<E> last;
    private int size;

    public MyLinkedList() {
        this.size = 0;
        this.first = null;
        this.last = null;
    }

    @Override
    public boolean add(E element) {
        Node<E> node = new Node<>(element);
        if (size == 0) {
            first = node;
        } else {
            last.setNext(node);
            node.setPrevious(last);
        }
        last = node;
        size++;
        return true;
    }

    @Override
    public void delete(int index) {
        if (index > size - 1 || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Element with " + index + " not found");
        }
        if (index == 0) {
            deleteFirst();
        } else if (index == size - 1) {
            deleteLast();
        } else {
            Node<E> temp = findNode(index);
            Node<E> previous = temp.getPrevious();
            previous.setNext(temp.getNext());
            temp.getNext().setPrevious(previous);
            temp = null;
            size--;
        }
    }

    @Override
    public void deleteFirst() {
        Node<E> temp = first.getNext();
        temp.setPrevious(null);
        first = temp;
        size--;
    }

    @Override
    public void deleteLast() {
        Node<E> temp = last.getPrevious();
        temp.setNext(null);
        last = temp;
        size--;
    }

    @Override
    public E get(int index) {
        return findNode(index).getElement();
    }

    private Node<E> findNode(int index) {
        if (index > size - 1 || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Element with " + index + " not found");
        }
        if (index == 0) {
            return first;
        } else if (index == size - 1) {
            return last;
        } else if (index < size / 2) {
            Node<E> temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.getNext();
            }
            return temp;
        } else {
            Node<E> temp = last;
            for (int i = size - 1; i > index; i--) {
                temp = temp.getPrevious();
            }
            return temp;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(E element) {
        if (first.getElement().equals(element) || last.getElement().equals(element)) {
            return true;
        }
        Node<E> temp = first;
        for (int i = 0; i < size - 1; i++) {
            temp = temp.getNext();
            if (temp.getElement().equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean set(int index, E element) {
        findNode(index).setElement(element);
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("MyLinkedList{" + first.getElement());
        Node<E> temp = first;
        for (int i = 0; i < size - 1; i++) {
            temp = temp.getNext();
            sb.append(", ").append(temp.getElement());
        }
        sb.append("}");
        return sb.toString();
    }
}
