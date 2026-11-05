package Exception;

import java.util.Scanner;

public class _4Exception {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name = "Justin";     //if you're accessing a character on a specific position that is not in the string or if
        name.charAt(100);           //the length of the string is too short for you to access it =  java.lang.StringIndexOutOfBoundsException
        int age = 15;
        System.out.println("Your age is: " + age);
        System.out.print(name);
    }
}
