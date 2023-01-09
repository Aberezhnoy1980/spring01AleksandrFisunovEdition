package ru.aberezhnoy.queue;

import java.util.Arrays;

public class QueueImpl<T> implements Queue<T> {

    private final int maxSize;
    private T[] queue;
    private int front;
    private int rear;
    private int items;

    public QueueImpl(int size) {
        this.maxSize = size;
        this.queue = (T[]) new Object[this.maxSize];
        this.front = 0;
        this.rear = -1;
        this.items = 0;
    }

    @Override
    public void insert(T element) {
        if (rear == maxSize - 1)
            rear = -1;
        queue[++rear] = element;
        items++;
//        this.queue[this.front++] = element;
    }

    @Override
    public T remove() {
        T temp = queue[front++];
        if (front == maxSize)
            front = 0;
        items--;
        return temp;
    }

    @Override
    public T peek() {
        return queue[front];
    }

    @Override
    public boolean isEmpty() {
        return (items == 0);
    }

    @Override
    public boolean isFull() {
        return (items == maxSize);
    }

    @Override
    public int getSize() {
        return items;
    }

    @Override
    public void display() {
        System.out.println(Arrays.toString(queue));
    }
}
