public class Main {
    public static void main(String[] args) {
        BankAccount cuenta1 = new BankAccount("123456789", 1000.0);
        BankAccount cuenta2 = new BankAccount("987654321", 100.0);

        Command deposit = TransactionFactory.createTransaction("Deposit", cuenta1, 500.0, null);
        Command withdrawal = TransactionFactory.createTransaction("Withdrawal", cuenta1, 200.0, null);
        Command transfer = TransactionFactory.createTransaction("Transfer", cuenta1, 300.0, cuenta2);

        cuenta1.doTransaction(deposit);
        cuenta1.doTransaction(withdrawal);
        cuenta1.doTransaction(transfer);

        cuenta1.showHistory();

        cuenta1.undoLastTransaction();
        cuenta1.showHistory();
    }
}
