package Exception2._9FavoriteLetter;

import java.util.Scanner;

public class FaveLetter {
    public static void performTask(){
        String[] str = new String[3];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter string " + (i+1) + ": ");
            String input= sc.nextLine();
            if (!input.equals("NONE")) {
                str[i] = input;
            }
        }

        System.out.print("Favorite string number: ");
        int pos = sc.nextInt();
        System.out.print("Favorite character number: ");
        int posch = sc.nextInt();
        System.out.println("Your favorite character is " + str[pos-1].charAt(posch-1) + ".");
    }
}