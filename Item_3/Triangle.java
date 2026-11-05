package Item_3;

public class Triangle extends Shape {
    private double a;
    private double b;
    private double c;
    private double h;

    public Triangle(double b, double h, double a, double c, String color) {
        super(color);
        this.a = a;
        this.b = b;
        this.c = c;
        this.h = h;
    }

    @Override
    public double area() {
        return 0.5 * h * b;
    }

    @Override
    public double perimeter() {
        return a + b + c;
    }

    @Override
    public String toString() {
        return super.toString() + "which is also a Triangle ";
    }

    public static class EquilateralTriangle extends Triangle {
        public EquilateralTriangle(double side, String color) {
            super(side, Math.sqrt(3)/2 * side, side, side, color);
        }

        @Override
        public String toString() {
            return super.toString() + "which is also an Equilateral Triangle ";
        }
    }
}
