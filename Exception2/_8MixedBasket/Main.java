package Exception2._8MixedBasket;
public class Main {
    public static void main(String[] args) {
        try {
            MixedBag.performTask();
        } catch(NumberFormatException e) {
            System.out.println("Selected item is not an integer");
        } catch(IndexOutOfBoundsException e) {
            System.out.println("Invalid position");
        }

    }
}