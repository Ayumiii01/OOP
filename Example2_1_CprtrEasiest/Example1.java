package Example2_1_CprtrEasiest;

import java.util.*;

class Student {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return id + " " + name;
    }
}

class StudentById implements Comparator<Student> {
    @Override
    public int compare(Student a, Student b) {
        return Integer.compare(a.id, b.id);   // smaller id first
    }
}

public class Example1 {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student(3, "Maria"));
        list.add(new Student(1, "Juan"));
        list.add(new Student(2, "Ana"));

        Collections.sort(list, new StudentById());   // pass the rule in
        System.out.println(list);
    }
}
