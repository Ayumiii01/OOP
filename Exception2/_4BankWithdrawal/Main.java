package Exception2._4BankWithdrawal;

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.0); // Initialize account with a balance of $1000

        try {
            // Simulate some withdrawal operations
            account.withdraw(500.0);
            account.withdraw(800.0); // This will throw InsufficientFundsException
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
    }
}