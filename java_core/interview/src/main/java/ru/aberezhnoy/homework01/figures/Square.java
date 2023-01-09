package ru.aberezhnoy.homework01.figures;

public class Square implements Figure{

    private float sideLength;

    public Square(float sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public void draw() {
        System.out.println("Нарисован квадрат со сторонами " + sideLength + "см");

    }

    @Override
    public float countSquare() {
        return sideLength*sideLength;
    }

    @Override
    public float countPerimeter() {
        return sideLength*4f;
    }
}