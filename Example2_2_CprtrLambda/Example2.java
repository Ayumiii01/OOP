package Example2_2_CprtrLambda;

import java.util.*;

// No Class Needed

class Person {
    String name;

    Person(String name) {
        this.name = name;
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

        list.sort((a, b) -> a.name.compareTo(b.name));   // rule written inline
        System.out.println(list);
    }
}
