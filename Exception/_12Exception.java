package Exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class _12Exception {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.print("Enter age: ");
            try {
                int age = sc.nextInt();
                if(age < 0) {
                    throw new Exception("You cannot have a negative age.");         //throw is like a return but it is more complicated
                }
                System.out.println("Your age is " + age);
                break;
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Cannot understand your input");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } // you cannot put this before the InputMismatchException = this must be the last = because you will catch all the Exception = in the rule you cannot catch again the same Exception you caught
        }
    }
}
