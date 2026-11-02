//Write a program to implement the Multiple Inheritance kind of framework (Bank Interface, Customer & Account classes).

interface Bank {
    void displayBank();
}

class Customer {
    int customerId;
    String name;

    Customer(int customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }
}

class Account extends Customer implements Bank {
    int accountNumber;
    double balance;

    Account(int customerId, String name, int accountNumber, double balance) {
        super(customerId, name);
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void displayBank() {
        System.out.println("Bank Name: State Bank of India");
    }

    void display() {
        System.out.println("Customer ID: " + customerId);
        System.out.println("Customer Name: " + name);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }

    public static void main(String[] args) {
        Account a = new Account(101, "Rahul", 123456, 50000);

        a.displayBank();
        a.display();
    }
}