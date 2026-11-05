package Exception;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _6Exception {
    static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);

        List<Integer> nums = Arrays.asList(1,2,3,4,5);    //same logic as the array exception problem = java.lang.ArrayIndexOutOfBoundsException
        System.out.println(nums.get(100));
    }
}
