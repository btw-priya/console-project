import java.util.ArrayList;
import java.util.Scanner;

class Account {
    int accountId;
    String accountName;
    double balance;

    Account(int accountId, String accountName, double balance) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.balance = balance;
    }
}

public class BankingManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Account> accounts = new ArrayList<>();

        while (true) {

            System.out.println("\n===== Banking Management System =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Balance Check");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Account ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    boolean duplicate = false;

                    // Manual loop for duplicate ID validation
                    for (int i = 0; i < accounts.size(); i++) {
                        if (accounts.get(i).accountId == id) {
                            duplicate = true;
                            break;
                        }
                    }

                    if (duplicate) {
                        System.out.println("Account ID already exists!");
                    } else {

                        System.out.print("Enter Account Holder Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Initial Balance: ");
                        double balance = sc.nextDouble();

                        accounts.add(new Account(id, name, balance));

                        System.out.println("Account Created Successfully.");
                    }
                    break;


                case 2:
                    System.out.print("Enter Account ID: ");
                    id = sc.nextInt();

                    boolean found = false;

                    // Manual loop for account search
                    for (int i = 0; i < accounts.size(); i++) {

                        Account acc = accounts.get(i);

                        if (acc.accountId == id) {

                            System.out.print("Enter Deposit Amount: ");
                            double amount = sc.nextDouble();

                            acc.balance = acc.balance + amount;

                            System.out.println("Deposit Successful.");
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Account Not Found.");
                    }
                    break;


                case 3:
                    System.out.print("Enter Account ID: ");
                    id = sc.nextInt();

                    found = false;

                    // Manual loop for withdrawal validation
                    for (int i = 0; i < accounts.size(); i++) {

                        Account acc = accounts.get(i);

                        if (acc.accountId == id) {

                            System.out.print("Enter Withdrawal Amount: ");
                            double amount = sc.nextDouble();

                            if (amount <= acc.balance) {

                                acc.balance = acc.balance - amount;
                                System.out.println("Withdrawal Successful.");

                            } else {

                                System.out.println("Insufficient Balance.");
                            }

                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Account Not Found.");
                    }
                    break;


                case 4:
                    System.out.print("Enter Account ID: ");
                    id = sc.nextInt();

                    found = false;

                    // Manual loop for balance checking
                    for (int i = 0; i < accounts.size(); i++) {

                        Account acc = accounts.get(i);

                        if (acc.accountId == id) {

                            System.out.println("Account Holder: " + acc.accountName);
                            System.out.println("Account Balance: ₹" + acc.balance);

                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Account Not Found.");
                    }
                    break;


                case 5:
                    System.out.println("Thank you for using Banking Management System.");
                    sc.close();
                    System.exit(0);


                default:
                    System.out.println("Invalid Choice. Please try again.");
            }
        }
    }
}