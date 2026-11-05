package Exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Another {
    static void main() {
        Scanner sc = new Scanner(System.in);
        String[] numbers = {"2", "jay", "21", "kim", "13", "67"};

        //try {
        //    System.out.print("Enter index: ");
        //    int i = sc.nextInt();
        //    int n = Integer.parseInt(numbers[i]);
        //    System.out.println("Your lucky number is " + n);
        //} catch (ArrayIndexOutOfBoundsException e) {
        //    System.out.println("There are only " + numbers.length + " to choose from");
        //} catch (NumberFormatException e) {
        //    System.out.println("Hmm,, I seem to cannot produce a number for you");
        //} catch (InputMismatchException e) {
        //    System.out.println("Your index does not seem to be a number to me");
        //}

        try {
            System.out.print("Enter index: ");
            int i = sc.nextInt();
            int n = Integer.parseInt(numbers[i]);
            System.out.println("Your lucky number is " + n);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("There are only " + numbers.length + " to choose from");
        } catch (NumberFormatException | InputMismatchException e) {
            System.out.println("Hmm,, I seem to cannot produce a number for you");
        }
    }

}
