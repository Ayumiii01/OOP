package Example_2_SortbyString;

import java.util.*;

class Person implements Comparable<Person> {
    String name;

    Person(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Person other) {
        return this.name.compareTo(other.name);   // String's own compareTo
    }

    @Override
    public String toString() {
        return name;
    }
}

public class Example2 {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("Maria"));
        list.add(new Person("Juan"));
        list.add(new Person("Ana"));

        Collections.sort(list);
        System.out.println(list);
    }
}