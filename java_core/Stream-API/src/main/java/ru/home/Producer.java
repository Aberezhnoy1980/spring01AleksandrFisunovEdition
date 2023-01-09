package ru.home;

@FunctionalInterface
public interface Producer<T> {
    T produce();

    default void consume(T t) {
    }
}
