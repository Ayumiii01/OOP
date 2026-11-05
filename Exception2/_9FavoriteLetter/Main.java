package Exception2._9FavoriteLetter;

public class Main {
    public static void main(String[] args) {
        try {
            FaveLetter.performTask();
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("There are only 3 strings to choose from");
        } catch(StringIndexOutOfBoundsException e) {
            System.out.println("Whoa! There's not enough characters here");
        } catch(NullPointerException e) {
            System.out.println("You have not elected a string in this number");
        }
    }
}