package Item_1;

import java.util.Comparator;


public class NumberComparator1 implements Comparator<Integer> {
    @Override
    public int compare(Integer a, Integer b) {
        int dist1 = Math.abs(a - 50);
        int dist2  = Math.abs(b - 50);

        return Integer.compare(dist2, dist1);
    }

}
