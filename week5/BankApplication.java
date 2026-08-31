import java.io.*;
import java.util.*;

class Account {
    int accountId;
    String name;
    double balance;

    Account(int accountId, String name, double balance) {
        this.accountId = accountId;
        this.name = name;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return accountId + "|" + name + "|" + balance;
    }
}

public class BankApplication {

    static final String FILE_NAME = "accounts.txt";
    static ArrayList<Account> accounts = new ArrayList<>();

    // Load accounts from text file
    static void loadAccounts() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));

            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                double balance = Double.parseDouble(data[2]);

                accounts.add(new Account(id, name, balance));
            }

            br.close();

        } catch (FileNotFoundException e) {
            // File will be created when first account is saved
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }

    // Save all accounts to text file
    static void saveAccounts() {
        try {
            BufferedWriter bw =
                    new BufferedWriter(new FileWriter(FILE_NAME));

            for (Account acc : accounts) {
                bw.write(acc.toString());
                bw.newLine();
            }

            bw.close();

        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }

    // Find account by ID
    static Account findAccount(int id) {
        for (Account acc : accounts) {
            if (acc.accountId == id) {
                return acc;
            }
        }
        return null;
    }

    // Create new account
    static void createAccount(Scanner sc) {
        System.out.print("Enter Account ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (findAccount(id) != null) {
            System.out.println("Account ID already exists!");
            return;
        }

        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Initial Deposit: ");
        double balance = sc.nextDouble();

        Account acc = new Account(id, name, balance);
        accounts.add(acc);

        saveAccounts();

        System.out.println("Account created successfully.");
    }

    // Deposit money
    static void deposit(Scanner sc) {
        System.out.print("Enter Account ID: ");
        int id = sc.nextInt();

        Account acc = findAccount(id);

        if (acc == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.print("Enter Deposit Amount: ");
        double amount = sc.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return;
        }

        acc.balance += amount;
        saveAccounts();

        System.out.println("Deposit successful.");
        System.out.println("New Balance: " + acc.balance);
    }

    // Withdraw money
    static void withdraw(Scanner sc) {
        System.out.print("Enter Account ID: ");
        int id = sc.nextInt();

        Account acc = findAccount(id);

        if (acc == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.print("Enter Withdrawal Amount: ");
        double amount = sc.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return;
        }

        if (amount > acc.balance) {
            System.out.println("Insufficient balance.");
            return;
        }

        acc.balance -= amount;
        saveAccounts();

        System.out.println("Withdrawal successful.");
        System.out.println("New Balance: " + acc.balance);
    }

    // Check balance
    static void checkBalance(Scanner sc) {
        System.out.print("Enter Account ID: ");
        int id = sc.nextInt();

        Account acc = findAccount(id);

        if (acc == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.println("Account ID : " + acc.accountId);
        System.out.println("Name       : " + acc.name);
        System.out.println("Balance    : " + acc.balance);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Load previous data
        loadAccounts();

        while (true) {

            System.out.println("\n===== BANK APPLICATION =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Balance Check");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    createAccount(sc);
                    break;

                case 2:
                    deposit(sc);
                    break;

                case 3:
                    withdraw(sc);
                    break;

                case 4:
                    checkBalance(sc);
                    break;

                case 5:
                    saveAccounts();
                    System.out.println("Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}