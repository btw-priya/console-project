import java.util.HashMap;
import java.util.Scanner;

class Account {
    private int accountNumber;
    private String accountHolder;
    private double balance;

    public Account(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit Successful.");
        } else {
            System.out.println("Invalid Deposit Amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid Withdrawal Amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient Balance.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal Successful.");
        }
    }

    public void displayBalance() {
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Holder : " + accountHolder);
        System.out.println("Current Balance: ₹" + balance);
    }
}

public class BankManagement {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // HashMap to store accounts
        HashMap<Integer, Account> accounts = new HashMap<>();

        int choice;

        do {
            System.out.println("\n===== BANK MENU =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Balance Check");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Account Number: ");
                    int accNo = sc.nextInt();

                    if (accounts.containsKey(accNo)) {
                        System.out.println("Account already exists.");
                        break;
                    }

                    sc.nextLine(); // Consume newline

                    System.out.print("Enter Account Holder Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Initial Balance: ");
                    double balance = sc.nextDouble();

                    Account account = new Account(accNo, name, balance);
                    accounts.put(accNo, account);

                    System.out.println("Account Created Successfully.");
                    break;

                case 2:
                    System.out.print("Enter Account Number: ");
                    accNo = sc.nextInt();

                    Account depositAccount = accounts.get(accNo);

                    if (depositAccount != null) {
                        System.out.print("Enter Deposit Amount: ");
                        double amount = sc.nextDouble();
                        depositAccount.deposit(amount);
                    } else {
                        System.out.println("Account Not Found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Account Number: ");
                    accNo = sc.nextInt();

                    Account withdrawAccount = accounts.get(accNo);

                    if (withdrawAccount != null) {
                        System.out.print("Enter Withdrawal Amount: ");
                        double amount = sc.nextDouble();
                        withdrawAccount.withdraw(amount);
                    } else {
                        System.out.println("Account Not Found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Account Number: ");
                    accNo = sc.nextInt();

                    Account balanceAccount = accounts.get(accNo);

                    if (balanceAccount != null) {
                        balanceAccount.displayBalance();
                    } else {
                        System.out.println("Account Not Found.");
                    }
                    break;

                case 5:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice.");
            }

        } while (choice != 5);

        sc.close();
    }
}