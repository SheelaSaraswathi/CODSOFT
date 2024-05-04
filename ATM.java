import java.util.Scanner;

// Bank account class to represent user's account
class BankAccount {
    private double balance;

    // Constructor to initialize balance
    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    // Method to get current balance
    public double getBalance() {
        return balance;
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful. Current balance: " + balance);
    }

    // Method to withdraw money from the account
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds. Withdrawal failed.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful. Current balance: " + balance);
        }
    }
}

// ATM class to represent the ATM machine
public class ATM {
    private final BankAccount account;

    // Constructor to initialize ATM with user's bank account
    public ATM(BankAccount userAccount) {
        account = userAccount;
    }

    // Method to display options to the user
    public void displayOptions() {
        System.out.println("MENU");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    // Method to handle user's choice
    public void handleChoice(int choice, Scanner scanner) {
        switch (choice) {
            case 1 -> {
                System.out.print("Enter amount to withdraw: ");
                double withdrawAmount = scanner.nextDouble();
                account.withdraw(withdrawAmount);
            }
            case 2 -> {
                System.out.print("Enter amount to deposit: ");
                double depositAmount = scanner.nextDouble();
                account.deposit(depositAmount);
            }
            case 3 -> System.out.println("Current balance: " + account.getBalance());
            case 4 -> {
                System.out.println("Exiting ATM. Have a nice day!");
                System.exit(0);
            }
            default -> System.out.println("Invalid choice. Please try again.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize user's bank account with initial balance
        BankAccount userAccount = new BankAccount(1000);

        // Initialize ATM with user's bank account
        ATM atm = new ATM(userAccount);
        System.out.println("Welcome to ATM");
        while (true) {
            // Display options to the user
            atm.displayOptions();

            // Prompt user to choose an option
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            // Handle user's choice
            atm.handleChoice(choice, scanner);
        }
    }
}
