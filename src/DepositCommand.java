public class DepositCommand implements Command {
    private BankAccount account;
    private double amount;

    public DepositCommand(BankAccount account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void execute() {
        if (amount > 0) {
            account.addBalance(amount);
            System.out.println("Depósito exitoso. Saldo actual: $" + account.getBalance());
        } else {
            System.out.println("El monto a depositar debe ser positivo.");
        }
    }

    @Override
    public void undo() {
        account.subtractBalance(amount);
        System.out.println("Depósito deshecho. Saldo actual: $" + account.getBalance());
    }

    @Override
    public String getDescription() {
        return "Depósito de $" + amount;
    }
}

