package Item_2;

import java.util.Comparator;

public class NumberComparator implements Comparator<Integer> {
    private int numA;

    public NumberComparator(int numA) {
        this.numA = numA;
    }

    @Override
    public int compare(Integer a, Integer b) {
        int distA = Math.abs(a - numA);
        int distB = Math.abs(b - numA);

        return Integer.compare(distA, distB);
    }
}
