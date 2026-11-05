package Exception;

import java.util.Scanner;

public class _5Exception {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] array = {1,2,3,4,5};          //same as the string index exception, if you are trying to access the value in a specific
        System.out.println(array[10]);      //position but the position is greater than the size of the array = java.lang.ArrayIndexOutOfBoundsException
    }
}
