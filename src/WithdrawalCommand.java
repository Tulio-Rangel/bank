public class WithdrawalCommand implements Command {
    private BankAccount account;
    private double amount;

    public WithdrawalCommand(BankAccount account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void execute() {
        if (amount <= 0) {
            System.out.println("El monto a retirar debe ser positivo.");
        } else if (amount > account.getBalance()) {
            System.out.println("Fondos insuficientes. Saldo actual: $" + account.getBalance());
        } else {
            account.subtractBalance(amount);
            System.out.println("Retiro exitoso. Saldo actual: $" + account.getBalance());
        }
    }

    @Override
    public void undo() {
        account.addBalance(amount);
        System.out.println("Retiro deshecho. Saldo actual: $" + account.getBalance());
    }

    @Override
    public String getDescription() {
        return "Retiro de $" + amount;
    }
}
