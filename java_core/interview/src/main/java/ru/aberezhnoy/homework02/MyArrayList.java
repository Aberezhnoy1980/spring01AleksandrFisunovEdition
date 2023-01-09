package ru.aberezhnoy.homework02;

import java.util.Arrays;

public class MyArrayList<E> implements MyList<E> {

    private int capacity;

    private int size;

    private Object[] array;

    public MyArrayList() {
        capacity = 10;
        size = 0;
        this.array = new Object[capacity];
    }

    @Override
    public boolean add(E element) {
        size++;
        if (size > capacity) {
            capacity *= 1.5;
            Object[] newArray = new Object[capacity];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
        array[size - 1] = element;
        return true;
    }

    @Override
    public void delete(int index) {
        if (index > size - 1 || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Element with " + index + " not found");
        }
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[size - 1] = null;
        size--;
    }

    @Override
    public void deleteFirst() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("List is empty. No elements fo delete");
        }
        delete(0);
    }

    @Override
    public void deleteLast() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("List is empty. No elements fo delete");
        }
        delete(size - 1);
    }

    @Override
    public E get(int index) {
        if (index > size - 1 || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Element with " + index + " not found");
        }
        return (E) array[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(E element) {
        if (isEmpty()) return false;
        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)) return true;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean set(int index, E element) {
        if (index > size - 1 || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Element with " + index + " not found");
        }
        array[index] = element;
        return true;
    }

    public int capacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "MyArrayList{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
