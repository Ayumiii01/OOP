package Exception;

import java.util.Scanner;

public class _2Exception {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");         //if the string input is a non number = java.lang.NumberFormatException
        String str = sc.nextLine();

        System.out.print("Str number to integer: " + Integer.parseInt(str));
    }
}
