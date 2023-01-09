package ru.home.lesson2;

public class NegativeElementException extends RuntimeException {
    private int index;
    private int value;

    public NegativeElementException(int index, int value) {
        super("There was found the negative item " + value + " at position: " + index);
        this.index = index;
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public int getValue() {
        return value;
    }
}
