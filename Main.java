package BankManagmentSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Customer c1 = new Customer(1, "Aysel", "Mammadova", 0501112233);
        Customer c2 = new Customer(2, "Murad", "Aliyev", 0502223344);
        Customer c3 = new Customer(3, "Nigar", "Hasanli", 0703334455);

        Customer[] customers = {c1, c2, c3};


        SavingsAccount s1 = new SavingsAccount(1, 1000, c1, 5);
        CurrentAccount c4 = new CurrentAccount(2, 2000, c2, 300);
        SavingsAccount s3 = new SavingsAccount(3, 3000, c3, 10);

        Account[] accounts = {s1, c4, s3};


        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("===== BANK MANAGEMENT SYSTEM =====");
            System.out.println("1. Show all customers");
            System.out.println("2. Show all accounts");
            System.out.println("3. Deposit money");
            System.out.println("4. Withdraw money");
            System.out.println("5. Transfer money");
            System.out.println("6. Search customer");
            System.out.println("7. Search account");
            System.out.println("8. Show Savings Account");
            System.out.println("9. Show Current Account");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int n1 = sc.nextInt();

            switch (n1) {

                case 1:
                    for (Customer c : customers) {
                        System.out.println(c.getId());
                        System.out.println(c.getName());
                        System.out.println(c.getSurname());
                        System.out.println(c.getPhone());
                    }
                    break;


                case 2:
                    for (Account a : accounts) {
                        System.out.println(a.getAccountId());
                        System.out.println(a.getBalance());
                        System.out.println(a.getCustomer().getId());
                        System.out.println(a.getCustomer().getName());
                        System.out.println(a.getCustomer().getSurname());
                        System.out.println(a.getCustomer().getPhone());

                    }
                    break;


                case 3:
                    System.out.print("Enter account ID: ");
                    int accountId = sc.nextInt();

                    System.out.print("Enter amount: ");
                    double amount = sc.nextDouble();

                    boolean depositFound = false;

                    for (Account a : accounts) {
                        if (a.getAccountId() == accountId) {
                            depositFound = true;
                            a.deposit(amount);
                            break;
                        }
                    }

                    if (!depositFound) {
                        System.out.println("Account not found.");
                    }

                    break;


                case 4:
                    System.out.print("Enter account ID: ");
                    int withdrawAccountId = sc.nextInt();

                    System.out.print("Enter amount: ");
                    double withdrawAmount = sc.nextDouble();

                    boolean withdrawFound = false;

                    for (Account a : accounts) {
                        if (a.getAccountId() == withdrawAccountId) {
                            withdrawFound = true;
                            a.withdraw(withdrawAmount);
                            break;
                        }
                    }

                    if (!withdrawFound) {
                        System.out.println("Account not found.");
                    }

                    break;


                case 5:
                    System.out.print("Enter sender account ID: ");
                    int senderId = sc.nextInt();

                    System.out.print("Enter receiver account ID: ");
                    int receiverId = sc.nextInt();

                    System.out.print("Enter amount: ");
                    double transferAmount = sc.nextDouble();

                    Account sender = null;
                    Account receiver = null;

                    for (Account a : accounts) {

                        if (a.getAccountId() == senderId) {
                            sender = a;
                        }

                        if (a.getAccountId() == receiverId) {
                            receiver = a;
                        }
                    }

                    if (sender != null && receiver != null) {

                        sender.withdraw(transferAmount);
                        receiver.deposit(transferAmount);

                        System.out.println("Transfer completed.");

                    } else {
                        System.out.println("Account not found.");
                    }

                    break;


                case 6:
                    System.out.print("Enter customer ID: ");
                    int number = sc.nextInt();

                    boolean found = false;

                    for (Customer c : customers) {

                        if (number == c.getId()) {

                            found = true;

                            System.out.println("Customer ID: " + c.getId());
                            System.out.println("Name: " + c.getName());
                            System.out.println("Surname: " + c.getSurname());
                            System.out.println("Phone: " + c.getPhone());
                        }
                    }

                    if (!found) {
                        System.out.println("Customer not found.");
                    }

                    break;


                case 7:
                    System.out.print("Enter account ID: ");
                    int number1 = sc.nextInt();

                    boolean found1 = false;

                    for (Account a : accounts) {

                        if (number1 == a.getAccountId()) {

                            found1 = true;

                            System.out.println("Account ID: " + a.getAccountId());
                            System.out.println("Balance: " + a.getBalance());
                            System.out.println("Customer: " + a.getCustomer());
                        }
                    }

                    if (!found1) {
                        System.out.println("Account not found.");
                    }

                    break;


                case 8:
                    System.out.print("Enter Savings Account ID: ");
                    int savingsId = sc.nextInt();

                    boolean savingsFound = false;

                    for (Account a : accounts) {

                        if (a instanceof SavingsAccount
                                && a.getAccountId() == savingsId) {

                            savingsFound = true;

                            SavingsAccount savings =
                                    (SavingsAccount) a;

                            System.out.println(
                                    "Account ID: "
                                            + savings.getAccountId()
                            );

                            System.out.println(
                                    "Customer: "
                                            + savings.getCustomer().getPhone()
                            );

                            System.out.println(
                                    "Customer: "
                                            + savings.getCustomer().getName()
                            );


                            System.out.println(
                                    "Customer: "
                                            + savings.getCustomer().getSurname()
                            );



                            System.out.println(
                                    "Balance: "
                                            + savings.getBalance()
                            );

                            System.out.println(
                                    "Interest Rate: "
                                            + savings.getRate()
                                            + "%"
                            );
                        }
                    }

                    if (!savingsFound) {
                        System.out.println(
                                "Savings Account not found."
                        );
                    }

                    break;


                case 9:
                    System.out.print("Enter Current Account ID: ");
                    int currentId = sc.nextInt();

                    boolean currentFound = false;

                    for (Account a : accounts) {

                        if (a instanceof CurrentAccount
                                && a.getAccountId() == currentId) {

                            currentFound = true;

                            CurrentAccount current =
                                    (CurrentAccount) a;

                            System.out.println(
                                    "Account ID: "
                                            + current.getAccountId()
                            );

                            System.out.println(
                                    "Customer: "
                                            + current.getCustomer().getPhone()
                            );

                            System.out.println(
                                    "Customer: "
                                            + current.getCustomer().getName()
                            );


                            System.out.println(
                                    "Customer: "
                                            + current.getCustomer().getSurname()
                            );

                            System.out.println(
                                    "Balance: "
                                            + current.getBalance()
                            );

                            System.out.println(
                                    "Overdraft Limit: "
                                            + current.getOverdraftLimit()
                            );
                        }
                    }

                    if (!currentFound) {
                        System.out.println(
                                "Current Account not found."
                        );
                    }

                    break;


                case 0:
                    System.out.println(
                            "Thank you for using Bank Management System!"
                    );
                    return;


                default:
                    System.out.println(
                            "Invalid option. Please try again."
                    );
            }
        }
    }
}