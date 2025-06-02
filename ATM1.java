import java.util.List;
import java.util.ArrayList;

// ATM Class
class ATM {
    private String location;
    private Bank bank;

    public ATM(String location, Bank bank) {
        this.location = location;
        this.bank = bank;
    }

    public void authenticateUser(Card card, String pin) {
        if (bank.verifyCard(card, pin)) {
            System.out.println("Authentication successful.");
        } else {
            System.out.println("Authentication failed.");
        }
    }

    public void performTransaction(Transaction transaction) {
        transaction.execute();
    }

    public void displayMenu() {
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
    }
}

// Bank Class
class Bank {
    private String name;
    private List<Account> accounts;

    public Bank(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public Account getAccount(String accountNumber) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                return acc;
            }
        }
        return null;
    }

    public boolean verifyCard(Card card, String pin) {
        return card.validatePin(pin);
    }
}

// Account Class
class Account {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    public Account(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}

// Card Class
class Card {
    private String cardNumber;
    private String pin;
    private Account linkedAccount;

    public Card(String cardNumber, String pin, Account linkedAccount) {
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.linkedAccount = linkedAccount;
    }

    public boolean validatePin(String inputPin) {
        return pin.equals(inputPin);
    }

    public Account getLinkedAccount() {
        return linkedAccount;
    }
}

// Abstract Transaction Class
abstract class Transaction {
    protected Account account;
    protected double amount;

    public Transaction(Account account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    public abstract void execute();
}

// Withdrawal Class
class Withdrawal extends Transaction {
    public Withdrawal(Account account, double amount) {
        super(account, amount);
    }

    @Override
    public void execute() {
        if (account.withdraw(amount)) {
            System.out.println("Withdrawal of " + amount + " successful.");
        } else {
            System.out.println("Insufficient funds.");
        }
    }
}

// Deposit Class
class Deposit extends Transaction {
    public Deposit(Account account, double amount) {
        super(account, amount);
    }

    @Override
    public void execute() {
        account.deposit(amount);
        System.out.println("Deposit of " + amount + " successful.");
    }
}

// Balance Inquiry Class
class BalanceInquiry extends Transaction {
    public BalanceInquiry(Account account) {
        super(account, 0);
    }

    @Override
    public void execute() {
        System.out.println("Current Balance: " + account.getBalance());
    }
}

// Main class for testing
public class Main {
    public static void main(String[] args) {
        // Setup
        Bank bank = new Bank("MyBank");
        Account acc = new Account("12345", "Sima Rani Debi", 5000.0);
        bank.addAccount(acc);
        Card card = new Card("9876-5432", "1234", acc);
        ATM atm = new ATM("Chattogram", bank);

        // Authenticate and test transactions
        atm.authenticateUser(card, "1234");
        atm.displayMenu();

        atm.performTransaction(new Deposit(acc, 1000.0));
        atm.performTransaction(new Withdrawal(acc, 2000.0));
        atm.performTransaction(new BalanceInquiry(acc));
    }
}