package Example3_1_staticField;

class Student {
    String name;
    static int count = 0;   // static: ONE shared count

    Student(String name) {
        this.name = name;
          // increases the shared count
    }

    void print() {
        count++;
        System.out.println(count);
    }
}

public class Main {
    public static void main(String[] args) {
        Student a = new Student("Ana");
        Student b = new Student("Juan");
        Student c = new Student("Maria");

        //System.out.println(Student.count);   // 3
        a.print();
        b.print();
        c.print();
    }
}

//Compare
/*
class Student {
    String name;
    int count = 0;   // non-static: every student gets its OWN count

    Student(String name) {
        this.name = name;
        count++;      // only increases THIS student's count
    }
}

public class Main {
    public static void main(String[] args) {
        Student a = new Student("Ana");
        Student b = new Student("Juan");
        Student c = new Student("Maria");

        System.out.println(a.count);   // 1
        System.out.println(b.count);   // 1
        System.out.println(c.count);   // 1
    }
}
 */