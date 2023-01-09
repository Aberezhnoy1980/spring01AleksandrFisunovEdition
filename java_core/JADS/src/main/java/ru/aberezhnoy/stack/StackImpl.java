package ru.aberezhnoy.stack;

import java.util.Arrays;

public class StackImpl<T> implements Stack<T> {
    private int maxSize;
    private final T[] stack;
    private int top;

    public StackImpl(int maxSize) {
        this.maxSize = maxSize;
        this.stack = (T[]) new Object[this.maxSize];
        this.top = -1;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public void push(T element) {
        if (this.isFull()) {
            this.maxSize++;
        }
        this.stack[++this.top] = element;
    }

    @Override
    public T pop() {
        return this.stack[this.top--];
    }

    @Override
    public T peek() {
        return this.stack[top];
    }

    @Override
    public boolean isEmpty() {
        return (this.top == -1);
    }

    @Override
    public boolean isFull() {
        return (this.top == this.maxSize - 1);
    }

    @Override
    public void display() {
        System.out.println(Arrays.toString(stack));
    }
}

class Test {
    public static void main(String[] args) {
        Stack<Integer> stack = new StackImpl<>(4);

        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.push(3);

        stack.display();

        System.out.println(stack.isEmpty());
        System.out.println(stack.isFull());

        System.out.println(stack.pop());
        System.out.println(stack.peek());

        System.out.println(stack.isEmpty());
        System.out.println(stack.isFull());

        stack.push(3);
        stack.display();
        System.out.println(stack.isFull());

    }
}
