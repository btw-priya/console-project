import java.util.HashMap;
import java.util.Scanner;

class Account {
    int accountNo;
    String name;
    double balance;

    Account(int accountNo, String name, double balance) {
        this.accountNo = accountNo;
        this.name = name;
        this.balance = balance;
    }
}

public class BankingManagementSystem {

    static HashMap<Integer, Account> accounts = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void createAccount() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Initial Deposit: ");
        double balance = sc.nextDouble();

        accounts.put(accNo, new Account(accNo, name, balance));
        System.out.println("Account Created Successfully!");
    }

    public static void deposit() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        if (accounts.containsKey(accNo)) {
            System.out.print("Enter Deposit Amount: ");
            double amount = sc.nextDouble();

            Account acc = accounts.get(accNo);
            acc.balance += amount;

            System.out.println("Deposit Successful!");
            System.out.println("Current Balance: " + acc.balance);
        } else {
            System.out.println("Account Not Found!");
        }
    }

    public static void withdraw() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        if (accounts.containsKey(accNo)) {
            System.out.print("Enter Withdrawal Amount: ");
            double amount = sc.nextDouble();

            Account acc = accounts.get(accNo);

            if (acc.balance >= amount) {
                acc.balance -= amount;
                System.out.println("Withdrawal Successful!");
                System.out.println("Current Balance: " + acc.balance);
            } else {
                System.out.println("Insufficient Balance!");
            }
        } else {
            System.out.println("Account Not Found!");
        }
    }

    public static void checkBalance() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        if (accounts.containsKey(accNo)) {
            Account acc = accounts.get(accNo);
            System.out.println("Customer Name: " + acc.name);
            System.out.println("Balance: " + acc.balance);
        } else {
            System.out.println("Account Not Found!");
        }
    }

    public static void transferMoney() {
        System.out.print("Enter Sender Account Number: ");
        int sender = sc.nextInt();

        System.out.print("Enter Receiver Account Number: ");
        int receiver = sc.nextInt();

        System.out.print("Enter Amount: ");
        double amount = sc.nextDouble();

        if (accounts.containsKey(sender) && accounts.containsKey(receiver)) {
            Account s = accounts.get(sender);
            Account r = accounts.get(receiver);

            if (s.balance >= amount) {
                s.balance -= amount;
                r.balance += amount;
                System.out.println("Transfer Successful!");
            } else {
                System.out.println("Insufficient Balance!");
            }
        } else {
            System.out.println("Invalid Account Number!");
        }
    }

    public static void viewAccount() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        if (accounts.containsKey(accNo)) {
            Account acc = accounts.get(accNo);

            System.out.println("Account Number : " + acc.accountNo);
            System.out.println("Customer Name : " + acc.name);
            System.out.println("Balance        : " + acc.balance);
        } else {
            System.out.println("Account Not Found!");
        }
    }

    public static void deleteAccount() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        if (accounts.remove(accNo) != null) {
            System.out.println("Account Deleted Successfully!");
        } else {
            System.out.println("Account Not Found!");
        }
    }

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== Banking Management System =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Transfer Money");
            System.out.println("6. View Account");
            System.out.println("7. Delete Account");
            System.out.println("8. Exit");

            System.out.print("Enter Your Choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    checkBalance();
                    break;
                case 5:
                    transferMoney();
                    break;
                case 6:
                    viewAccount();
                    break;
                case 7:
                    deleteAccount();
                    break;
                case 8:
                    System.out.println("Thank You!");
                    System.exit(0);
                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
