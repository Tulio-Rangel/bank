import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private final String accountNumber;
    private double balance;
    private final List<Transaction> transactionHistory;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
    }

    public void doTransaction(Transaction transaction) {
        transaction.excecuteTransaction(this);
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void addBalance(double amount) {
        balance += amount;
    }

    public void subtractBalance(double amount) {
        balance -= amount;
    }

    public void addToHistory(Transaction transaction) {
        transactionHistory.add(transaction);
    }

    public void showHistory() {
        System.out.println("Historial de transacciones para la cuenta " + accountNumber + ":");
        for (Transaction t : transactionHistory) {
            System.out.println(t.getDescription() + " por $" + t.getAmount());
        }
    }

    public static void main(String[] args) {
        BankAccount cuenta1 = new BankAccount("123456789", 1000.0);
        BankAccount cuenta2 = new BankAccount("987654321", 100.0);

        cuenta1.doTransaction(new Deposit(500.0));
        cuenta1.doTransaction(new Withdrawal(200.0));
        cuenta1.doTransaction(new Withdrawal(1500.0));
        cuenta1.doTransaction(new Transfer(300.0, cuenta2));
        cuenta1.doTransaction(new Transfer(2000.0, cuenta2));

        cuenta1.showHistory();
        cuenta2.showHistory();
    }
}
