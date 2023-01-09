package ru.aberezhnoy.stack;

public interface Stack<T>{

    void push(T element);

    T pop();

    T peek();

    boolean isEmpty();

    boolean isFull();

    void display();

}
