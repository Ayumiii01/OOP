package Example3_4_staticAllThreeTogether;

class Student {
    // STATIC: shared by the whole class
    static int count = 0;
    static final double PASSING_GRADE = 75.0;

    // NON-STATIC: personal to each student
    String name;
    double grade;

    Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
        count++;
    }

    // Static method: needs no particular student
    static boolean isValidGrade(double g) {
        return g >= 0 && g <= 100;
    }

    // Non-static method: needs THIS student's grade
    boolean isPassing() {
        return grade >= PASSING_GRADE;
    }
}

public class Main {
    public static void main(String[] args) {
        Student a = new Student("Ana", 80);
        Student b = new Student("Juan", 60);

        System.out.println("Total students: " + Student.count);        // 2
        System.out.println("Valid grade? " + Student.isValidGrade(105)); // false

        System.out.println(a.name + " passing? " + a.isPassing());      // true
        System.out.println(b.name + " passing? " + b.isPassing());      // false
    }
}