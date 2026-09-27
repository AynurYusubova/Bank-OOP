package BankManagmentSystem;

public class CurrentAccount extends Account {
    private double overdraftLimit = 500;

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    public CurrentAccount(int accountId, double balance, Customer customer, double overdraftLimit) {
        super(accountId, balance, customer);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0) {

            if (amount <= overdraftLimit) {
                super.withdraw(amount);
            } else {
                System.out.println("Overdraft limit exceeded.");
            }

        } else {
            System.out.println("Withdraw amount must be positive.");
        }
    }
}

