package Exception2._5YouCantDoMathLikeThat;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the value of a: ");
        int a = sc.nextInt();


        System.out.print("Enter the value of b: ");
        int b = sc.nextInt();

        try {

            System.out.println("Quotient: " + (a/b));
        } catch(ArithmeticException e) {
            System.out.println("Invalid division");
        }

    }
}