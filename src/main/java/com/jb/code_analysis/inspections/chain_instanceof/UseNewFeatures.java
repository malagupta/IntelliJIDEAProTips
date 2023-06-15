package com.jb.code_analysis.inspections.chain_instanceof;

sealed interface Shape permits Point, Cirle, Rectangle {}
record Point (int x, int y) implements Shape {}
record Cirle(double radius) implements Shape {}
record Rectangle (int width, int height) implements Shape {}

public class UseNewFeatures {
    double getArea(Shape shape) {
        double result;
        if (shape instanceof Point) {
            result = 0;
        } else if (shape instanceof Cirle cirle) {
            result = Math.PI * Math.pow(cirle.radius(), 2);
        } else if (shape instanceof Rectangle rectangle) {
            result = rectangle.width() * rectangle.height();
        } else {
            throw new IllegalArgumentException();
        }
        return result;
    }
}
