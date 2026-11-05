package Item_4_Shape;

import java.util.Comparator;

public abstract class Shape implements Comparable<Shape> {
    String color;

    public Shape(String color) {
        this.color = color;
    }

    public abstract double area();
    public abstract double perimeter();

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
            int compColor = s1.color.compareToIgnoreCase(s2.color);
            if(compColor != 0) {
                return compColor;
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
