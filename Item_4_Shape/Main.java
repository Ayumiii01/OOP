package Item_4_Shape;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String opt;
        double length, width, side, base, height, a, b, c, r;
        String color;

        do {
            System.out.print("Enter option: ");
            opt = sc.nextLine();

            switch(opt) {
                case "Rectangle":
                    System.out.print("Enter length: ");
                    length = sc.nextDouble();
                    System.out.print("Enter width: ");
                    width = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Enter color: ");
                    color = sc.nextLine();

                    shapes.add(new Rectangle(length, width, color));
                    break;
                case "Square":
                    System.out.print("Enter side: ");
                    side = sc.nextDouble();
                    System.out.print("Enter color: ");
                    color = sc.nextLine();

                    shapes.add(new Rectangle.Square(side, color));
                    break;
            }
        } while(!opt.equals("DONE"));
    }
}
