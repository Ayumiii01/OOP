package Exception;

import java.util.Scanner;

public class _3Exception {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int result = 15 / 0;            //If denominator is 0 or if the logic is not mathematically possible = java.lang.ArithmeticException
        System.out.println(result);
    }
}

