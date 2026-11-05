package Exception2._6YouCantApplyBeyondCutoffPeriod;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();

        double[] arr = new double[size];



        for(int i = 0; i < size; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            arr[i] = sc.nextDouble();
        }

        System.out.print("Enter the index of the element to print: ");
        int pos = sc.nextInt();
        try{
            double num = arr[pos];
            System.out.print("Element at index " + pos + ": ");
            System.out.printf("%.2f", num);

        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.print("Index " + pos + " is invalid.");
        }
    }
}