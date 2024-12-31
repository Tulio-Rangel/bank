import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private final String accountNumber;
    private double balance;
    private final List<Command> transactionHistory;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
    }

    public void doTransaction(Command command) {
        command.execute();
        transactionHistory.add(command);
    }

    public void undoLastTransaction() {
        if (!transactionHistory.isEmpty()) {
            Command lastCommand = transactionHistory.remove(transactionHistory.size() - 1);
            lastCommand.undo();
        } else {
            System.out.println("No hay transacciones para deshacer.");
        }
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

    public void showHistory() {
        System.out.println("Historial de transacciones para la cuenta " + accountNumber + ":");
        for (Command command : transactionHistory) {
            System.out.println(command.getDescription());
        }
    }
}
