package Example_1_Sort_numbers;

import java.util.*;

class Student implements Comparable<Student> {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.id, other.id);   // smaller id first
    }

    @Override
    public String toString() {
        return id + " " + name;
    }
}

public class Example1 {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student(3, "Maria"));
        list.add(new Student(1, "Juan"));
        list.add(new Student(2, "Ana"));

        Collections.sort(list);
        System.out.println(list);
    }
}
