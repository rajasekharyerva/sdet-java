package sdet.java.java11;

public class SealedClass {
    // Define a sealed class
    //
    public sealed class Shape permits Circle, Rectangle {}

    // Permitted subclasses
    public final class Circle extends Shape {
        double radius;
    }

    public final class Rectangle extends Shape {
        double length, width;
    }


}
