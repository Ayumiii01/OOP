package Exception2._7DividingByZero;

import java.util.Scanner;

public class Divider {
    public static void performTask() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the numerator: ");
        int num = scanner.nextInt();
        System.out.print("Enter the denominator: ");
        int den = scanner.nextInt();
        int result = num / den;
        System.out.println("Result: " + result);
    }
}