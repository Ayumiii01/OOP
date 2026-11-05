package Exception2._3YoureTooYoung;

public class Main {
    public static void main(String[] args) {
        try {
            int age = 16;
            if (age < 18) {
                throw new AgeException(age);
            }
            System.out.println("User is eligible.");
        } catch (AgeException e) {
            System.out.println(e.getMessage());
        }

        try {
            int age = 18;
            if (age < 18) {
                throw new AgeException(age);
            }
            System.out.println("User is eligible.");
        } catch (AgeException e) {
            System.out.println(e.getMessage());
        }
    }
}