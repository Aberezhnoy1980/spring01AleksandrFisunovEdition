package ru.aberezhnoy.queue;

public interface Queue<T> {
    void insert(T element);

    T remove();

    T peek();

    boolean isEmpty();

    boolean isFull();

    int getSize();

    void display();
}
