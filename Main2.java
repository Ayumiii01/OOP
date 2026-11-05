import java.util.*;

class Student implements Comparable<Student> {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Comparable: default order by id
    @Override
    public int compareTo(Student other) {
        return this.id - other.id;
    }

    @Override
    public String toString() {
        return id + " " + name;
    }
}

public class Main2 {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student(3, "Maria"));
        list.add(new Student(1, "Juan"));
        list.add(new Student(2, "Ana"));

        // 1. Comparable: no extra argument
        Collections.sort(list);
        System.out.println("By id:   " + list);

        // 2. Comparator: a variable that HOLDS the rule
        Comparator<Student> byName = (a, b) -> a.name.compareTo(b.name); // Lambda expression

        Collections.sort(list, byName);   // pass the rule itself
        System.out.println("By name: " + list);
    }
}
