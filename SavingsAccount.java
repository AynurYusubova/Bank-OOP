package BankManagmentSystem;

public class SavingsAccount extends Account {
   private int rate;

    public SavingsAccount(int accountId, double balance, Customer customer, int rate) {
        super(accountId, balance, customer);
        this.rate = rate;
    }


    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount);
        double b=(amount*5)/100;
        double b2=b+amount;
        System.out.println("Deposited "+b2);
    }






}
