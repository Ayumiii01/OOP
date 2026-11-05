package Exception;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //System.out.print("Enter age: ");    1     // If String inputted = Stack trace (red warning) = input mismatch
        //int age = sc.nextInt(); //input     1
        // int age = Integer.parseInt("vince");  2 // If parseInt is String = input mismatch NumberFormatException

        //int age = 15 / 0;   3          // ArithmeticException
        //String name = "Justin";       4
        //name.charAt(100);     4
        //int age = 15;     4
        //System.out.println("Your age is: " + age);        4
        //System.out.print(name);       4
        //int[] array = {1,2,3,4,5};        5
        //System.out.println(array[10]);        5
        //List<Integer> nums = Arrays.asList(1,2,3,4,5);        6
        //System.out.println(nums.get(100));        6
        //List<Integer> nums = new ArrayList<>();       7
        //nums.add(2);      7
        //nums.add(2);      7
        //nums.add(3);      7
        //System.out.println(nums.get(100));      7

        //List<Integer> nums = null;        8
        //nums.add(2);      8
        //nums.add(2);      8
        //nums.add(3);      8
        //System.out.println(nums.get(100));        8

        //Object o = sc;        9
        //int[] array = {1,2,3,4,5};        9
        //List<Integer> nums = (List<Integer>) o;       9
        //nums.add(2);      9
        //nums.add(2);      9
        //nums.add(3);      9
        //System.out.println(nums.get(100));        9

        //System.out.print("Enter age: ");      10
        //try {         10
        //     int age = sc.nextInt();       10
        //     System.out.println("Your age is " + age);         10
        //} catch (InputMismatchException e) {      10
        //     System.out.println("Cannot understand your input");       10
        //} catch (ArithmeticException e) {         10
        //     System.out.println("Cannot divide by zero");      10
        //}         10


        //while(true) {
        //    System.out.print("Enter age: ");
        //    try {
        //        int age = sc.nextInt();
        //        if(age < 0) {
        //            throw new Exception("You cannot have a negative age.");         //throw is like a return but it is more complicated
         //       }
         //       System.out.println("Your age is " + age);
         //       break;
        //    } catch (InputMismatchException e) {
        //        sc.nextLine();
        //        System.out.println("Cannot understand your input");
        //    } catch (Exception e) {
        //       System.out.println(e.getMessage());
        //    } // you cannot put this before the InputMismatchException = this must be the last = because you will catch all the Exception = in the rule you cannot catch again the same Exception you caught
        //}



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
