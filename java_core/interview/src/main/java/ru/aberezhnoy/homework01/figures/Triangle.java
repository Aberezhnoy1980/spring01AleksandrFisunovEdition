package ru.aberezhnoy.homework01.figures;

public class Triangle implements Figure {

    private float leftSideLength;
    private float rightSideLength;
    private float bottomSideLength;
    private double leftCorner;
    private double rightCorner;
    private double topCorner;

    public Triangle(float leftSideLength, float rightSideLength, float bottomSideLength, double leftCorner, double rightCorner, double topCorner) {
        this.leftSideLength = leftSideLength;
        this.rightSideLength = rightSideLength;
        this.bottomSideLength = bottomSideLength;
        this.leftCorner = leftCorner;
        this.rightCorner = rightCorner;
        this.topCorner = topCorner;
    }

    @Override
    public void draw() {
        System.out.printf("Нарисован треугольник со сторонами %f, %f, %f  сантиметров и углами %f, %f, %f градусов\n",
                leftSideLength, rightSideLength,bottomSideLength,leftCorner,rightCorner,topCorner);
    }

    @Override
    public float countSquare() {
        return (float) (leftSideLength*bottomSideLength*Math.sin(leftCorner))/2;
    }

    @Override
    public float countPerimeter() {
        return leftSideLength+rightSideLength+bottomSideLength;
    }
}
