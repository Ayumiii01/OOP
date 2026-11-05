package Exception;

import java.util.List;
import java.util.Scanner;

public class _09Exception {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Object o = sc;
        int[] array = {1,2,3,4,5};
        List<Integer> nums = (List<Integer>) o;     // java.lang.ClassCastException
        nums.add(2);
        nums.add(2);
        nums.add(3);
        System.out.println(nums.get(100));
    }
}
