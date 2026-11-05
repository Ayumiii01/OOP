package Exception;

import java.util.ArrayList;
import java.util.List;

public class _7Exception {
    static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();     //if you are trying to get the value of the certain position but the position you are trying to access is
        nums.add(2);                                //greater than the List size = java.lang.IndexOutOfBoundsException
        nums.add(2);
        nums.add(3);
        System.out.println(nums.get(100));
    }
}
