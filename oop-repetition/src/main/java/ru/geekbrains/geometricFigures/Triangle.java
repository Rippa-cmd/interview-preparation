package ru.geekbrains.geometricFigures;

public class Triangle implements GeometricFigure {

    private double sideA;

    private double sideB;

    private double sideC;

    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double getSideC() {
        return sideC;
    }

    @Override
    public double countArea() {
        double perimeter = countPerimeter();
        return Math.sqrt(perimeter * (perimeter - sideA) * (perimeter - sideB) * (perimeter - sideC));
    }

    @Override
    public double countPerimeter() {
        return 0.5 * (sideA + sideB + sideC);
    }
}
