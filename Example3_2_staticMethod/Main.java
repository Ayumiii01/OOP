package Example3_2_staticMethod;

class GradeHelper {
    static boolean isPassing(double grade) {
        return grade >= 75;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(GradeHelper.isPassing(80));   // true, no object needed
    }
}

// Compare

/*
class GradeHelper {
    boolean isPassing(double grade) {
        return grade >= 75;
    }
}

public class Main {
    public static void main(String[] args) {
        GradeHelper helper = new GradeHelper();   // must create an object first
        System.out.println(helper.isPassing(80));  // true
    }
}
 */
