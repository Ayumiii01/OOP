package Item_2;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int size;
        System.out.print("How many numbers?: ");
        size = input.nextInt();
        System.out.print("Enter " + size + " integers: ");
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < size; i++) {
            list.add(input.nextInt());
        }
        int closeTo;
        System.out.print("Sort closest to: ");
        closeTo = input.nextInt();
        list.sort(new NumberComparator(closeTo));
        for(int n : list) {
            System.out.print(n + " ");
        }
    }
}
