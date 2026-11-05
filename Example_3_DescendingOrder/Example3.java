package Example_3_DescendingOrder;

import java.util.*;

class Player implements Comparable<Player> {
    String name;
    int points;

    Player(String name, int points) {
        this.name = name;
        this.points = points;
    }

    @Override
    public int compareTo(Player other) {
        return Integer.compare(other.points, this.points);   // other first = descending
    }

    @Override
    public String toString() {
        return name + " (" + points + ")";
    }
}

public class Example3 {
    public static void main(String[] args) {
        List<Player> list = new ArrayList<>();
        list.add(new Player("Ana", 70));
        list.add(new Player("Juan", 95));
        list.add(new Player("Maria", 82));

        Collections.sort(list);
        System.out.println(list);
    }
}