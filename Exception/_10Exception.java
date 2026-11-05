package Exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class _10Exception {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);                //try-catch

        System.out.print("Enter age: ");
        try {
             int age = sc.nextInt();
             System.out.println("Your age is " + age);
        } catch (InputMismatchException e) {
             System.out.println("Cannot understand your input");
        } catch (ArithmeticException e) {
             System.out.println("Cannot divide by zero");
        }
    }
}
