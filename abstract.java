//Question 2(A & B): Abstract Class Accounts and SavingsAccount

abstract class Accounts {
    double balance;
    int accountNumber;
    String accountHoldersName;
    String address;

    Accounts(double balance, int accountNumber, String accountHoldersName, String address) {
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.accountHoldersName = accountHoldersName;
        this.address = address;
    }

    abstract void withdrawl(double amount);

    abstract void deposit(double amount);

    void display() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHoldersName);
        System.out.println("Address: " + address);
        System.out.println("Balance: " + balance);
    }
}

class SavingsAccount extends Accounts {
    double rateOfInterest;

    SavingsAccount(double balance, int accountNumber, String name, String address, double rateOfInterest) {
        super(balance, accountNumber, name, address);
        this.rateOfInterest = rateOfInterest;
    }

    void withdrawl(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal Successful");
        } else {
            System.out.println("Insufficient Balance");
        }
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit Successful");
    }

    void calculateAmount() {
        double interest = balance * rateOfInterest / 100;
        double totalAmount = balance + interest;

        System.out.println("Rate of Interest: " + rateOfInterest + "%");
        System.out.println("Interest Amount: " + interest);
        System.out.println("Total Amount: " + totalAmount);
    }

    public static void main(String[] args) {
        SavingsAccount s = new SavingsAccount(50000, 101, "Rahul", "Kolkata", 5);

        s.display();
        s.deposit(10000);
        s.withdrawl(5000);

        System.out.println("\nUpdated Account Details:");
        s.display();

        System.out.println("\nInterest Calculation:");
        s.calculateAmount();
    }
}