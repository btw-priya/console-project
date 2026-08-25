import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class BankingManagementSystem {

    // TreeMap automatically keeps accounts sorted by Account ID
    private static final TreeMap<Integer, Account> storage = new TreeMap<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("==========================================");
        System.out.println("     BANKING MANAGEMENT SYSTEM");
        System.out.println("        Week 4 - TreeMap Storage");
        System.out.println("==========================================");

        boolean running = true;

        while (running) {
            displayMainMenu();

            int choice = readInt("Enter your choice: ");

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
                    viewAllAccounts();
                    break;

                case 6:
                    System.out.println("\nThank you for using the Banking Management System.");
                    running = false;
                    break;

                default:
                    System.out.println("\nInvalid choice! Please select 1-6.");
            }
        }

        scanner.close();
    }

    // =========================
    // MAIN MENU
    // =========================
    private static void displayMainMenu() {
        System.out.println("\n------------- MAIN MENU -------------");
        System.out.println("1. Create Account");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Check Balance");
        System.out.println("5. View All Accounts (Sorted)");
        System.out.println("6. Exit");
        System.out.println("-------------------------------------");
    }

    // =========================
    // OPTION 1: CREATE ACCOUNT
    // =========================
    private static void createAccount() {

        System.out.println("\n========== CREATE ACCOUNT ==========");

        int accountId = readInt("Input Account ID: ");

        // Check whether Account ID already exists
        if (storage.containsKey(accountId)) {
            System.out.println("Account ID already exists!");
            return;
        }

        String accountHolderName = readString("Input Account Holder Name: ");
        double initialBalance = readDouble("Input Initial Balance: ");

        if (initialBalance < 0) {
            System.out.println("Initial balance cannot be negative!");
            return;
        }

        Account account = new Account(
                accountId,
                accountHolderName,
                initialBalance
        );

        // Put account into TreeMap
        storage.put(accountId, account);

        System.out.println("Account created successfully!");
    }

    // =========================
    // OPTION 2: DEPOSIT
    // =========================
    private static void deposit() {

        System.out.println("\n============ DEPOSIT ============");

        int accountId = readInt("Input Account ID: ");

        // Check if account exists
        if (!storage.containsKey(accountId)) {
            System.out.println("Account not found!");
            return;
        }

        double depositAmount = readDouble("Input Deposit Amount: ");

        if (depositAmount <= 0) {
            System.out.println("Deposit amount must be greater than 0!");
            return;
        }

        Account account = storage.get(accountId);

        account.deposit(depositAmount);

        System.out.println("Deposit successful!");
        System.out.printf("New Balance: %.2f%n", account.getBalance());
    }

    // =========================
    // OPTION 3: WITHDRAW
    // =========================
    private static void withdraw() {

        System.out.println("\n=========== WITHDRAW ===========");

        int accountId = readInt("Input Account ID: ");

        // Check if account exists
        if (!storage.containsKey(accountId)) {
            System.out.println("Account not found!");
            return;
        }

        double withdrawAmount = readDouble("Input Withdraw Amount: ");

        if (withdrawAmount <= 0) {
            System.out.println("Withdraw amount must be greater than 0!");
            return;
        }

        Account account = storage.get(accountId);

        // Check whether balance is sufficient
        if (account.getBalance() < withdrawAmount) {
            System.out.println("Insufficient balance!");
            return;
        }

        account.withdraw(withdrawAmount);

        System.out.println("Withdrawal successful!");
        System.out.printf("New Balance: %.2f%n", account.getBalance());
    }

    // =========================
    // OPTION 4: CHECK BALANCE
    // =========================
    private static void checkBalance() {

        System.out.println("\n========= CHECK BALANCE =========");

        int accountId = readInt("Input Account ID: ");

        if (!storage.containsKey(accountId)) {
            System.out.println("Account not found!");
            return;
        }

        Account account = storage.get(accountId);

        System.out.println("Account Holder Name: "
                + account.getAccountHolderName());

        System.out.printf("Balance: %.2f%n", account.getBalance());
    }

    // =========================
    // OPTION 5: VIEW ALL ACCOUNTS
    // =========================
    private static void viewAllAccounts() {

        System.out.println("\n======= ALL ACCOUNTS (SORTED) =======");

        if (storage.isEmpty()) {
            System.out.println("No accounts available.");
            return;
        }

        System.out.printf("%-12s %-25s %-15s%n",
                "Account ID", "Account Holder", "Balance");

        System.out.println("--------------------------------------------------");

        // TreeMap automatically returns entries in ascending key order
        for (Map.Entry<Integer, Account> entry : storage.entrySet()) {

            Account account = entry.getValue();

            System.out.printf("%-12d %-25s %.2f%n",
                    account.getAccountId(),
                    account.getAccountHolderName(),
                    account.getBalance());
        }

        System.out.println("==============================================");
    }

    // =========================
    // INPUT METHODS
    // =========================
    private static int readInt(String message) {

        while (true) {
            System.out.print(message);

            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }

    private static double readDouble(String message) {

        while (true) {
            System.out.print(message);

            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private static String readString(String message) {

        while (true) {
            System.out.print(message);

            String input = scanner.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }

            System.out.println("Input cannot be empty.");
        }
    }
}


// =====================================================
// ACCOUNT CLASS
// =====================================================
class Account {

    private int accountId;
    private String accountHolderName;
    private double balance;
    private LocalDateTime createdDate;

    // Transaction list corresponds to the Transaction entity
    private List<Transaction> transactions;

    public Account(int accountId, String accountHolderName, double balance) {

        this.accountId = accountId;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.createdDate = LocalDateTime.now();
        this.transactions = new ArrayList<>();

        // Record initial deposit if initial balance is greater than zero
        if (balance > 0) {
            transactions.add(
                    new Transaction(
                            accountId,
                            "DEPOSIT",
                            balance,
                            "Initial balance"
                    )
            );
        }
    }

    public int getAccountId() {
        return accountId;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void deposit(double amount) {

        balance += amount;

        transactions.add(
                new Transaction(
                        accountId,
                        "DEPOSIT",
                        amount,
                        "Deposit"
                )
        );
    }

    public void withdraw(double amount) {

        balance -= amount;

        transactions.add(
                new Transaction(
                        accountId,
                        "WITHDRAW",
                        amount,
                        "Withdrawal"
                )
        );
    }
}


// =====================================================
// TRANSACTION CLASS
// =====================================================
class Transaction {

    private static long nextTransactionId = 1;

    private long transactionId;
    private int accountId;
    private String type;
    private double amount;
    private LocalDateTime transactionDate;
    private String description;

    public Transaction(
            int accountId,
            String type,
            double amount,
            String description) {

        this.transactionId = nextTransactionId++;
        this.accountId = accountId;
        this.type = type;
        this.amount = amount;
        this.transactionDate = LocalDateTime.now();
        this.description = description;
    }

    public long getTransactionId() {
        return transactionId;
    }

    public int getAccountId() {
        return accountId;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public String getDescription() {
        return description;
    }
}
