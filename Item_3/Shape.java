package Item_3;

import java.util.Comparator;

public abstract class Shape implements Comparable<Shape> {
    String color;

    public Shape(String color) {
        this.color = color;
    }

    public abstract double area();
    public abstract double perimeter();

    @Override
    public String toString() {
        return "a shape that is color " + color + " ";
    }

    @Override
    public int compareTo(Shape other) {
        int compArea = Double.compare(this.area(), other.area());
        if(compArea != 0) {
            return compArea;
        }

        return Double.compare(this.perimeter(), other.perimeter());
    }

    public static class ColorComparator implements Comparator<Shape> {
        @Override
        public int compare(Shape s1, Shape s2) {
            int ColorComp = s1.color.compareToIgnoreCase(s2.color);
            if(ColorComp != 0) {
                return ColorComp;
            }

            return s1.compareTo(s2);
        }
    }

    public static class AreaComparator implements Comparator<Shape> {
        @Override
        public int compare(Shape s1, Shape s2) {
            return Double.compare(s1.area(), s2.area());
        }
    }

    public static class PerimeterComparator implements Comparator<Shape> {
        @Override
        public int compare(Shape s1, Shape s2) {
            return Double.compare(s1.perimeter(), s2.perimeter());
        }
    }
}
