package ru.home.lesson2.homework2;

public class MyArraySizeException extends RuntimeException {
    public MyArraySizeException(){
        super("Wrong array size");
    }
}
