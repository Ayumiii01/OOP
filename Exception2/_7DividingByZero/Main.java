package Exception2._7DividingByZero;

public class Main {

    public static void main(String[] args) {
        // Hey there, start typing your Java code here...
        Divider divide = new Divider();

        try {
            divide.performTask();
        } catch(ArithmeticException e) {
            System.out.println("Cannot divide by zero.");
        } catch(RuntimeException e) {
            System.out.println("Invalid input. Please enter an integer.");
        }
    }
}