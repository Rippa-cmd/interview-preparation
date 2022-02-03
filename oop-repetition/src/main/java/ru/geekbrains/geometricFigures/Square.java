package ru.geekbrains.geometricFigures;

public class Square implements GeometricFigure{

    private double side;

    public Square(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    @Override
    public double countArea() {
        return side*side;
    }

    @Override
    public double countPerimeter() {
        return 4*side;
    }
}
