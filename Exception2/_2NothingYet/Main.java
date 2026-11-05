package Exception2._2NothingYet;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String myString = null;

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        if(!input.startsWith("-") && !input.endsWith("-")) {
            myString = input;
        }

        try {
            System.out.println(myString.toUpperCase());
        } catch(NullPointerException e) {
            System.out.println("myString is still null");
        }

        System.out.print("Everything's over");

    }
}