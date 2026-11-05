package Exception2._4BankWithdrawal;

public class InsufficientFundsException extends Exception {

    public InsufficientFundsException() {
        super("Insufficient funds for withdrawal.");
    }
}