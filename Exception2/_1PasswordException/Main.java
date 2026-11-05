package Exception2._1PasswordException;

public class Main {
    public static void main(String[] args) {
        try {
            String password = "weakpas";
            if (!isValidPassword(password)) {
                throw new PasswordException();
            }
            System.out.println("Password is valid.");
        } catch (PasswordException e) {
            System.out.println(e.getMessage());
        }

        try {
            String newPassword = "strongerpassword123" ;
            if (!isValidPassword(newPassword)) {
                throw new PasswordException();
            }
            System.out.println("Password is valid.");
        } catch (PasswordException e) {
            System.out.println(e.getMessage());
        }
    }

    public static boolean isValidPassword(String password) {
        return password.length() >= 8; // A simple example: password should be at least 8 characters
    }
}