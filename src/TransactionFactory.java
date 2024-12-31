public class TransactionFactory {
    public static Command createTransaction(String type, BankAccount sourceAccount, double amount, BankAccount targetAccount) {
        switch (type) {
            case "Deposit":
                return new DepositCommand(sourceAccount, amount);
            case "Withdrawal":
                return new WithdrawalCommand(sourceAccount, amount);
            case "Transfer":
                return new TransferCommand(sourceAccount, targetAccount, amount);
            default:
                throw new IllegalArgumentException("Tipo de transacción no válido.");
        }
    }
}