package Example3_6_staticCallingFieldsInStaticClass;

class Student {
    final String name;      //comment out this if you want to check the Simpler example
    //String name = "Ana";      //2nd method - Simpler one

    public Student(String name) {
        this.name = name;           //comment out this constructor if you want to check the Simpler example
    }

    static class Printer {
        void print(Student s) {
            System.out.println(s.name);   // OK: "s" tells Java whose name
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Student ana = new Student("Ana");
        Student juan = new Student("Juan");
        //Student ana = new Student();
        //Student juan = new Student();
        //juan.name = "Juan";

        Student.Printer p = new Student.Printer();
        p.print(ana);    // Ana
        p.print(juan);   // Juan
    }
}