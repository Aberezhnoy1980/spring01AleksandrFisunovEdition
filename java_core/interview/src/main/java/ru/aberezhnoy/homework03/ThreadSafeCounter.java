package ru.aberezhnoy.homework03;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeCounter {

    private int result;

    private void increment(int value) {
        result += value;
        System.out.println("Result after increment = " + result);
    }

    private void decrement(int value) {
        result -= value;
        System.out.println("Result after decrement = " + result);
    }

    public void makeIncrementAndDecrementOperations(int incrementValue, int quantityOfIncrement,
                                                    int decrementValue, int quantityOfDecrement) {
        final Lock lock = new ReentrantLock();
        new Thread(() -> {
            for (int i = 0; i < quantityOfIncrement; i++) {
                lock.lock();
                increment(incrementValue);
                lock.unlock();
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < quantityOfDecrement; i++) {
                lock.lock();
                decrement(decrementValue);
                lock.unlock();
            }
        }).start();
    }

    public static void main(String[] args) {
        ThreadSafeCounter counter = new ThreadSafeCounter();
        counter.makeIncrementAndDecrementOperations(1, 10, 2, 5);
    }
}
