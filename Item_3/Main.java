package Item_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        Scanner input = new Scanner (System.in);
        String option;
        double length, width, side, base, height, a, b, c, radius;
        String color;

        do {
            System.out.print("Enter shape: ");
            option = input.nextLine();

            switch(option) {
                case "Ellipse":
                    System.out.print("Enter a: ");
                    a = input.nextDouble();
                    System.out.print("Enter b: ");
                    b = input.nextDouble();
                    input.nextLine();
                    System.out.print("Enter color: ");
                    color = input.nextLine();
                    shapes.add(new Ellipse(color, a, b));
                    break;
                case "Circle":
                    System.out.print("Enter radius: ");
                    radius = input.nextDouble();
                    input.nextLine();
                    System.out.print("Enter color: ");
                    color = input.nextLine();
                    shapes.add(new Ellipse.Circle(radius, color));
                    break;
                case "Rectangle":
                    System.out.print("Enter length: ");
                    length = input.nextDouble();
                    System.out.print("Enter width: ");
                    width = input.nextDouble();
                    input.nextLine();
                    System.out.print("Enter color: ");
                    color = input.nextLine();
                    shapes.add(new Rectangle(length, width, color));
                    break;
                case "Square":
                    System.out.print("Enter side: ");
                    side = input.nextDouble();
                    input.nextLine();
                    System.out.print("Enter color: ");
                    color = input.nextLine();
                    shapes.add(new Rectangle.Square(side, color));
                    break;
                case "Triangle":
                    System.out.print("Enter base: ");
                    base = input.nextDouble();
                    System.out.print("Enter height: ");
                    height = input.nextDouble();
                    System.out.print("Enter a: ");
                    a = input.nextDouble();
                    System.out.print("Enter c: ");
                    c = input.nextDouble();
                    input.nextLine();
                    System.out.print("Enter color: ");
                    color = input.nextLine();
                    shapes.add(new Triangle(base, height, a, c, color));
                    break;
                case "Equilateral Triangle":
                    System.out.print("Enter side: ");
                    side = input.nextDouble();
                    System.out.print("Enter color: ");
                    color = input.nextLine();
                    shapes.add(new Triangle.EquilateralTriangle(side, color));
                    break;
                case "Check Circle":
                    Shape circle = new Ellipse.Circle(0, "");
                    if(circle instanceof Ellipse) {
                        System.out.println("Circle is an Ellipse");
                    }
                    return;
                case "Check Square":
                    Shape square = new Rectangle.Square(0, "");
                    if(square instanceof Rectangle) {
                        System.out.println("Square is a Rectangle");
                    }
                    return;
                case "Check Equilateral":
                    Shape equi = new Triangle.EquilateralTriangle(0, "");
                    if(equi instanceof Triangle) {
                        System.out.println("Equilateral Triangle is a Triangle");
                    }
                    return;
                case "Done":
                    System.out.print("Exiting...");
                    break;
                default:
                    System.out.println("Enter a valid option...");
            }
        } while(!option.equals("Done"));

        do {
            System.out.print("Sort by: ");
            option = input.nextLine();
            switch(option) {
                case "Area":
                    shapes.sort(new Shape.AreaComparator());
                    for(Shape s : shapes) {
                        System.out.print("Area of " + s + ": " + String.format("%.2f\n", s.area()));
                    }
                    break;
                case "Perimeter":
                    shapes.sort(new Shape.PerimeterComparator());
                    for(Shape s : shapes) {
                        System.out.print("Perimeter of " + s + ": " + String.format("%.2f\n", s.perimeter()));
                    }
                    break;
                case "A_Color":
                    shapes.sort(new Shape.ColorComparator());
                    for(Shape s : shapes) {
                        System.out.print("Area of " + s + ": " + String.format("%.2f\n", s.area()));
                    }
                    break;
                case "P_Color":
                    shapes.sort(new Shape.ColorComparator());
                    for(Shape s : shapes) {
                        System.out.print("Perimeter of " + s + ": " + String.format("%.2f\n", s.perimeter()));
                    }
                    break;
                case "Done":
                    System.out.print("Exiting...");
                    break;
                default:
                    System.out.print("Enter a valid option...");
            }
        } while(!option.equals("Done"));
    }
}
