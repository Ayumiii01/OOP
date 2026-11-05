package Exception;

import java.util.Scanner;

public class _1Exception {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter age: ");         // If String inputted = Stack trace (red warning) = input mismatch     java.util.InputMismatchException
        int age = sc.nextInt(); //input
    }
}
