import java.util.*;

class Bank {
    private String bankName;
    private String branch;
    private List<Customer> customers;

    public Bank(String bankName, String branch) {
        this.bankName = bankName;
        this.branch = branch;
        this.customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public String toString() {
        return bankName + " - " + branch;
    }
}

class Customer {
    private String customerId;
    private String name;
    private String address;
    private List<Account> accounts;

    public Customer(String customerId, String name, String address) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public String toString() {
        return "Customer: " + name + ", Address: " + address;
    }
}

class Account {
    private String accountNumber;
    private double balance;
    private String accountType;
    private List<Transaction> transactions;

    public Account(String accountNumber, double balance, String accountType) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountType = accountType;
        this.transactions = new ArrayList<>();
    }

    public void deposit(double amount) {
        balance += amount;
        transactions.add(new Transaction(UUID.randomUUID().toString(), new Date(), amount, "Deposit"));
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            transactions.add(new Transaction(UUID.randomUUID().toString(), new Date(), amount, "Withdrawal"));
            return true;
        }
        return false;
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public String toString() {
        return accountType + " Account #" + accountNumber + " - Balance: $" + balance;
    }
}

class Transaction {
    private String transactionId;
    private Date date;
    private double amount;
    private String type;

    public Transaction(String transactionId, Date date, double amount, String type) {
        this.transactionId = transactionId;
        this.date = date;
        this.amount = amount;
        this.type = type;
    }

    public String toString() {
        return type + ": $" + amount + " on " + date;
    }
}

class ATM {
    private String atmId;
    private String location;

    public ATM(String atmId, String location) {
        this.atmId = atmId;
        this.location = location;
    }

    public String toString() {
        return "ATM #" + atmId + " located at " + location;
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        Bank bank = new Bank("Global Bank", "Downtown Branch");

        Customer customer1 = new Customer("C001", "Alice Johnson", "123 Maple St");
        Account acc1 = new Account("A1001", 5000.0, "Savings");
        Account acc2 = new Account("A1002", 2000.0, "Checking");

        customer1.addAccount(acc1);
        customer1.addAccount(acc2);

        bank.addCustomer(customer1);

        ATM atm = new ATM("ATM001", "Downtown Plaza");

        System.out.println(bank);
        System.out.println(atm);
        System.out.println(customer1);

        System.out.println("\nCustomer Accounts:");
        for (Account acc : customer1.getAccounts()) {
            System.out.println(acc);
            acc.deposit(1000);
            acc.withdraw(300);
            System.out.println("Transactions:");
            for (Transaction t : acc.getTransactions()) {
                System.out.println("  " + t);
            }
        }
    }
}