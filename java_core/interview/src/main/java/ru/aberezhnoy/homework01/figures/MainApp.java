package ru.aberezhnoy.homework01.figures;

public class MainApp {
    public static void main(String[] args) {
        Figure circle = new Circle(10);
        Figure square = new Square(4);
        Figure triangle = new Triangle(2,4,6,45,45,90);

        Figure [] array = {circle,square,triangle};

        for (Figure f: array) {
            f.draw();
            System.out.println("Площадь фигуры " + f.getClass().getSimpleName() + " равна " + f.countSquare());
            System.out.println("Периметр фигуры " + f.getClass().getSimpleName() + " равен " +f.countPerimeter());
        }
    }
}
