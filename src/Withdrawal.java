public class Withdrawal extends Transaction {
    public Withdrawal(double account) {
        super(account, "Retiro");
    }

    @Override
    public boolean excecuteTransaction(BankAccount account) {
        if (getAmount() <= 0) {
            System.out.println("El monto a retirar debe ser positivo.");
            return false;
        } else if (getAmount() > account.getBalance()) {
            System.out.println("Fondos insuficientes. Saldo actual: $" + account.getBalance());
            return false;
        } else {
            account.subtractBalance(getAmount());
            account.addToHistory(this);
            System.out.println("Monto retirado: $" + getAmount() + ". Saldo restante: $" + account.getBalance());
            return true;
        }
    }
}
