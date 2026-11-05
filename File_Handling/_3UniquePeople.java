package File_Handling;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class _3UniquePeople {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of names: ");
        int num = sc.nextInt();
        sc.nextLine();

        ArrayList<String> names = new ArrayList<>();

        for(int i = 0; i < num; i++) {
            System.out.print("Enter name "+ (i + 1) + ": ");
            String name = sc.nextLine();

            if(!names.contains(name)) {
                names.add(name);
            }
        }

        try (BufferedWriter bw= new BufferedWriter(new FileWriter("people.txt"), 1024)) {
            for(String name : names) {
                bw.write(name);
                bw.newLine();
            }
        } catch(IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}
