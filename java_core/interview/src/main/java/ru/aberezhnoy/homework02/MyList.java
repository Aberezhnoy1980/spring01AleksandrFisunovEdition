package ru.aberezhnoy.homework02;

public interface MyList<E> {
    boolean add(E element);

    void delete(int index);

    void deleteFirst();

    void deleteLast();

    E get(int index);

    int size();

    boolean contains(E element);

    boolean isEmpty();

    boolean set(int index, E element);
}
