package Item_3;

public class Ellipse extends Shape {
    private double a;
    private double b;

    public Ellipse(String color, double a, double b) {
        super(color);
        this.a = a;
        this.b = b;
    }


    @Override
    public double area() {
        return Math.PI * a * b;
    }

    @Override
    public double perimeter() {
        return 1;
    }

    @Override
    public String toString() {
        return super.toString() + "which is also an Ellipse ";
    }

    public static class Circle extends Ellipse{
        public Circle(double radius, String color) {
            super(color, radius, radius);
        }

        @Override
        public String toString() {
            return super.toString() + "which is also a Circle ";
        }

    }
}
