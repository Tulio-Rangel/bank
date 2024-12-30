public class Deposit extends Transaction {
    public Deposit(double amount) {
        super(amount, "Depósito");
    }

    @Override
    public boolean excecuteTransaction(BankAccount account) {
        if (getAmount() > 0) {
            account.addBalance(getAmount());
            account.addToHistory(this);
            System.out.println("Depósito exitoso. Saldo actual: $" + account.getBalance());
            return true;
        } else {
            System.out.println("El monto a depositar debe ser positivo.");
            return false;
        }
    }
}
