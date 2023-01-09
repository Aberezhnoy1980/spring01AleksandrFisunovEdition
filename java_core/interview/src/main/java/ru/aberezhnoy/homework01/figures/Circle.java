package ru.aberezhnoy.homework01.figures;

public class Circle implements Figure{

    private float radius;

    public Circle(float radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Нарисован круг радиусом " + radius + "см");
    }

    @Override
    public float countSquare() {
        return 3.14f*radius*radius;
    }

    @Override
    public float countPerimeter() {
        return 2f*3.14f*radius;
    }
}
