package ru.geekbrains.geometricFigures;

public class Circle implements GeometricFigure{

    private double diagonal;

    public Circle(long diagonal) {
        this.diagonal = diagonal;
    }

    public double getDiagonal() {
        return diagonal;
    }

    @Override
    public double countArea() {
        return 3.14*diagonal*diagonal;
    }

    @Override
    public double countPerimeter() {
        return 3.14*diagonal;
    }
}
