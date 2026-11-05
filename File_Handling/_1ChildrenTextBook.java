package File_Handling;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.*;
import java.io.IOException;

public class _1ChildrenTextBook {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ltrs = "";
        String nums = "";

        while(true) {
            System.out.print("Enter a character: ");
            char c = sc.next().charAt(0);

            if(Character.isLetter(c)) {
                ltrs += c + "\n";
            } else if(Character.isDigit(c)) {
                nums += c + "\n";
            } else {
                break;
            }
        }

        new File("letters").mkdir();
        new File("numbers").mkdir();

        try {
            BufferedWriter bw1 = new BufferedWriter(new FileWriter("letters/inputted.txt"), 1024);
            bw1.write(ltrs);
            bw1.close();

            BufferedWriter bw2 = new BufferedWriter(new FileWriter("numbers/inputted.txt"), 1024);
            bw2.write(nums);
            bw2.close();
        } catch(IOException e) {
            System.out.println("An error occured: " + e.getMessage());
        }
    }
}