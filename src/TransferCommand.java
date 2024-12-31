public class TransferCommand implements Command {
    private BankAccount sourceAccount;
    private BankAccount targetAccount;
    private double amount;

    public TransferCommand(BankAccount sourceAccount, BankAccount targetAccount, double amount) {
        this.sourceAccount = sourceAccount;
        this.targetAccount = targetAccount;
        this.amount = amount;
    }

    @Override
    public void execute() {
        if (amount <= 0) {
            System.out.println("El monto a transferir debe ser positivo.");
        } else if (amount > sourceAccount.getBalance()) {
            System.out.println("Fondos insuficientes para transferir. Saldo actual: $" + sourceAccount.getBalance());
        } else {
            sourceAccount.subtractBalance(amount);
            targetAccount.addBalance(amount);
            System.out.println("Transferencia exitosa de $" + amount + " a la cuenta " + targetAccount.getAccountNumber() + ". Saldo actual: $" + sourceAccount.getBalance());
        }
    }

    @Override
    public void undo() {
        targetAccount.subtractBalance(amount);
        sourceAccount.addBalance(amount);
        System.out.println("Transferencia deshecha. Saldo actual: $" + sourceAccount.getBalance());
    }

    @Override
    public String getDescription() {
        return "Transferencia de $" + amount + " a la cuenta " + targetAccount.getAccountNumber();
    }
}
