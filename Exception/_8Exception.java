package Exception;

import java.util.List;
import java.util.Scanner;

public class _8Exception {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        Object o = sc;

        List<Integer> nums = (List<Integer>) o;     //same as the class
        nums.add(2);
        nums.add(2);
        nums.add(3);
        System.out.println(nums.get(100));
    }
}
