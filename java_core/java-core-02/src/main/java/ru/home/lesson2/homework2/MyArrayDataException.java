package ru.home.lesson2.homework2;

public class MyArrayDataException extends RuntimeException {
    private final int indexI;
    private final int indexJ;
    private final String value;

    public MyArrayDataException(int indexI, int indexJ, String value) {
        super("Failed to convert element at position: " + "row: " + indexI + " column: " + indexJ + " value: \"" + value + "\"");
        this.indexI = indexI;
        this.indexJ = indexJ;
        this.value = value;
    }

    public int getIndexI() {
        return indexI;
    }

    public int getIndexJ() {
        return indexJ;
    }

    public String getValue() {
        return value;
    }
}
