package Example3_3_staticConstants;

class Circle {
    static final double PI = 3.14159;   // ONE copy for all circles
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    double area() {
        return PI * radius * radius;
    }
}

public class Main {
    public static void main(String[] args) {
        Circle c1 = new Circle(2);
        Circle c2 = new Circle(5);

        System.out.println(c1.area());      // 12.56636
        System.out.println(c2.area());      // 78.53975
        System.out.println(Circle.PI);      // 3.14159, reachable without any circle
    }
}

// Compare

/*
class Circle {
    final double PI = 3.14159;   // every Circle object stores its own copy
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    double area() {
        return PI * radius * radius;
    }
}
 */
