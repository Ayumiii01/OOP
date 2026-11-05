package Exception2._8MixedBasket;

import java.util.ArrayList;
import java.util.Scanner;

public class MixedBag {
    public static void performTask() {
        ArrayList<String> items = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Enter item: ");
            String input = sc.nextLine();
            if (input.equals("STOP")) {
                break;
            }
            items.add(input);
        }
        System.out.print("Adding the items: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int item1 = Integer.parseInt(items.get(a-1));
        int item2 = Integer.parseInt(items.get(b-1));
        System.out.println("Result: " + (item1 + item2));
    }
}