package Example_5_TwoFields;

import java.util.*;

class Employee implements Comparable<Employee> {
    String firstName;
    String lastName;

    Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public int compareTo(Employee other) {
        int result = this.lastName.compareTo(other.lastName);   // 1st: last name
        if (result != 0) {
            return result;                                      // not a tie, done
        }
        return this.firstName.compareTo(other.firstName);       // tie: first name
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}

public class Example5 {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Juan", "Cruz"));
        list.add(new Employee("Ana", "Santos"));
        list.add(new Employee("Ana", "Cruz"));

        Collections.sort(list);
        System.out.println(list);
    }
}