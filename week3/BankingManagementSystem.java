import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

// Account class
class Account {
    private int accountId;
    private String name;
    private double balance;

    public Account(int accountId, String name, double balance) {
        this.accountId = accountId;
        this.name = name;
        this.balance = balance;
    }

    public int getAccountId() {
        return accountId;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Account ID: " + accountId +
               ", Name: " + name +
               ", Balance: " + balance;
    }
}

// DAO class - handles storage
class AccountDAO {
    // LinkedHashMap preserves insertion order
    private LinkedHashMap<Integer, Account> accounts = new LinkedHashMap<>();

    // Create Account
    public boolean addAccount(Account account) {
        if (accounts.containsKey(account.getAccountId())) {
            return false;
        }

        accounts.put(account.getAccountId(), account);
        return true;
    }

    // Find Account
    public Account getAccount(int accountId) {
        return accounts.get(accountId);
    }

    // View All Accounts
    public void viewAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts available.");
            return;
        }

        System.out.println("\n--- All Accounts ---");

        // LinkedHashMap displays in insertion order
        for (Map.Entry<Integer, Account> entry : accounts.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}

// Main class
public class BankingManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        AccountDAO dao = new AccountDAO();

        int choice;

        do {
            System.out.println("\n===== BANK MANAGEMENT SYSTEM =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Balance Check");
            System.out.println("5. View All Accounts");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Account ID: ");
                    int id = sc.nextInt();

                    sc.nextLine(); // consume newline

                    System.out.print("Enter Account Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Initial Balance: ");
                    double balance = sc.nextDouble();

                    Account account = new Account(id, name, balance);

                    if (dao.addAccount(account)) {
                        System.out.println("Account created successfully.");
                    } else {
                        System.out.println("Account ID already exists.");
                    }
                    break;

                case 2:
                    System.out.print("Enter Account ID: ");
                    id = sc.nextInt();

                    Account depositAccount = dao.getAccount(id);

                    if (depositAccount != null) {
                        System.out.print("Enter Deposit Amount: ");
                        double amount = sc.nextDouble();

                        if (amount > 0) {
                            depositAccount.deposit(amount);
                            System.out.println("Deposit successful.");
                            System.out.println("New Balance: "
                                    + depositAccount.getBalance());
                        } else {
                            System.out.println("Invalid amount.");
                        }
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Account ID: ");
                    id = sc.nextInt();

                    Account withdrawAccount = dao.getAccount(id);

                    if (withdrawAccount != null) {
                        System.out.print("Enter Withdrawal Amount: ");
                        double amount = sc.nextDouble();

                        if (amount > 0) {
                            if (withdrawAccount.withdraw(amount)) {
                                System.out.println("Withdrawal successful.");
                                System.out.println("New Balance: "
                                        + withdrawAccount.getBalance());
                            } else {
                                System.out.println("Insufficient balance.");
                            }
                        } else {
                            System.out.println("Invalid amount.");
                        }
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Account ID: ");
                    id = sc.nextInt();

                    Account balanceAccount = dao.getAccount(id);

                    if (balanceAccount != null) {
                        System.out.println("Account Name: "
                                + balanceAccount.getName());
                        System.out.println("Current Balance: "
                                + balanceAccount.getBalance());
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 5:
                    dao.viewAllAccounts();
                    break;

                case 6:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 6);

        sc.close();
    }
}