package ru.geekbrains.geometricFigures;

public class Main {

    public static void main(String[] args) {
        GeometricFigure circle = new Circle(10);
        System.out.println(circle.countPerimeter());
        System.out.println(circle.countArea());

        GeometricFigure square = new Square(7);
        System.out.println(square.countPerimeter());
        System.out.println(square.countArea());

        GeometricFigure triangle = new Triangle(4, 9, 8);
        System.out.println(triangle.countPerimeter());
        System.out.println(triangle.countArea());
    }
}
