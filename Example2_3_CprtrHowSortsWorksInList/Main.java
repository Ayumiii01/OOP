package Example2_3_CprtrHowSortsWorksInList;

import java.util.*;

class Student {
    String name;

    Student(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("Juan"));
        list.add(new Student("Ana"));
        list.add(new Student("Ben"));
        list.add(new Student("Jose"));
        list.add(new Student("Shane"));

        System.out.println("Before: " + list);

        list.sort((a, b) -> {
            System.out.println("compare(" + a.name + ", " + b.name + ")");
            return a.name.compareTo(b.name);
        });

        System.out.println("After:  " + list);
    }
}

//Before: [Juan, Ana, Ben, Jose, Shane]
//compare(Ana, Juan)
//compare(Ben, Ana)
//compare(Ben, Juan)
//compare(Ben, Ana)
//compare(Jose, Ben)
//compare(Jose, Juan)
//compare(Shane, Jose)
//compare(Shane, Juan)
//After:  [Ana, Ben, Jose, Juan, Shane]

//#	Printed	                a	        b	        Lambda runs	                Result	        Meaning	                                                            List after this call
//1	compare(Ana, Juan)	    Ana	        Juan	    "Ana".compareTo("Juan")	    -9 (negative)	Ana goes before Juan	                                            [Juan, Ana, Ben, Jose, Shane]
//2	compare(Ben, Ana)       Ben	        Ana	        "Ben".compareTo("Ana")	    1 (positive)	Ben goes after Ana, so the first run ends. Sort flips Juan, Ana	    [Ana, Juan, Ben, Jose, Shane]
//3	compare(Ben, Juan)	    Ben	        Juan	    "Ben".compareTo("Juan")	    -8 (negative)	Ben goes before Juan	                                             no change yet
//4	compare(Ben, Ana)	    Ben	        Ana	        "Ben".compareTo("Ana")	    1 (positive)	Ben goes after Ana, so insert between them	                        [Ana, Ben, Juan, Jose, Shane]
//5	compare(Jose, Ben)	    Jose	    Ben	        "Jose".compareTo("Ben")	    8 (positive)	Jose goes after Ben	                                                no change yet
//6	compare(Jose, Juan)	    Jose	    Juan	    "Jose".compareTo("Juan")	-6 (negative)	Jose goes before Juan, so insert between Ben and Juan	            [Ana, Ben, Jose, Juan, Shane]
//7	compare(Shane, Jose)	Shane	    Jose	    "Shane".compareTo("Jose")  	9 (positive)	Shane goes after Jose	                                            no change yet
//8	compare(Shane, Juan)	Shane	    Juan	    "Shane".compareTo("Juan")	9 (positive)	Shane goes after Juan, so it stays at the end	                    [Ana, Ben, Jose, Juan, Shane]