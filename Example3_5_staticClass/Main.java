package Example3_5_staticClass;

class Outer {
    private String message = "Hello";

    // Static nested: independent of any Outer object
    static class StaticNested {
        void show() {
            System.out.println("Static nested works alone");
            // System.out.println(message);   // ERROR: no Outer object
        }
    }

    // Inner: tied to one Outer object
    class Inner {
        void show() {
            System.out.println("Inner sees: " + message);   // can use message
        }
    }
}
                                //Thing:	            Allowed?:
                                //  Fields	                Yes
                                //  Methods	                Yes
                                //  Nested classes	        Yes
                                //  Top-level classes	     No
                                //  Constructors	         No
public class Main {
    public static void main(String[] args) {
        // Static nested: no Outer object needed
        Outer.StaticNested a = new Outer.StaticNested();
        a.show();

        // Inner: must create an Outer first
        Outer outer = new Outer();
        Outer.Inner b = outer.new Inner();
        b.show();
    }
}