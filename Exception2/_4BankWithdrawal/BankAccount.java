package Exception2._4BankWithdrawal;

public class BankAccount {
    private double balance;

    public BankAccount(double initialBalance)  {
        this.balance = initialBalance;

    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if(amount > balance) {
            throw new InsufficientFundsException();
        }

        this.balance = balance-amount;

        System.out.println("Withdrawal successful. Remaining balance: " + balance);
    }
}