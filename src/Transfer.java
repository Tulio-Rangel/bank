public class Transfer extends Transaction {
    private BankAccount destinyAccount;

    public Transfer(double amount, BankAccount destinyAccount) {
        super(amount, "Transferencia");
        this.destinyAccount = destinyAccount;
    }

    @Override
    public boolean excecuteTransaction(BankAccount account) {
        if (getAmount() <= 0) {
            System.out.println("El monto a transferir debe ser positivo.");
            return false;
        } else if (getAmount() > account.getBalance()) {
            System.out.println("Fondos insuficientes para transferir. Saldo actual: $" + account.getBalance());
            return false;
        } else {
            account.subtractBalance(getAmount());
            destinyAccount.addBalance(getAmount());
            account.addToHistory(this);
            destinyAccount.addToHistory(new Deposit(getAmount()));
            System.out.println("Transferencia exitosa de $" + getAmount() + " a la cuenta " + destinyAccount.getAccountNumber() + ". Saldo actual: $" + account.getBalance());
            return true;
        }
    }

}
