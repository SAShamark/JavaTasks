package com.example;

import java.util.HashMap;
import java.util.Map;

class BankAccount {
    private int accountNumber;
    private String accountName;
    private double balance;

    public BankAccount(int accountNumber, String accountName, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = initialDeposit;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new NegativeAmountException("Deposit amount must be positive");
        }
        balance += amount;
    }

    public void withdraw(double amount) throws InsufficientFundsException, NegativeAmountException {
        if (amount <= 0) {
            throw new NegativeAmountException("Withdrawal amount must be positive");
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds");
        }
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountSummary() {
        return "Account Number: " + accountNumber + "\nAccount Name: " + accountName + "\nBalance: " + balance;
    }
}

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

class NegativeAmountException extends Exception {
    public NegativeAmountException(String message) {
        super(message);
    }
}

class AccountNotFoundException extends Exception {
    public AccountNotFoundException(String message) {
        super(message);
    }
}

class Bank {
    private Map<Integer, BankAccount> accounts;

    public Bank() {
        this.accounts = new HashMap<>();
    }

    public BankAccount createAccount(String accountName, double initialDeposit) {
        int accountNumber = accounts.size() + 1;
        BankAccount account = new BankAccount(accountNumber, accountName, initialDeposit);
        accounts.put(accountNumber, account);
        return account;
    }

    public BankAccount findAccount(int accountNumber) throws AccountNotFoundException {
        BankAccount account = accounts.get(accountNumber);
        if (account == null) {
            throw new AccountNotFoundException("Account not found");
        }
        return account;
    }

    public void transferMoney(int fromAccountNumber, int toAccountNumber, double amount)
            throws InsufficientFundsException, NegativeAmountException, AccountNotFoundException {
        BankAccount fromAccount = findAccount(fromAccountNumber);
        BankAccount toAccount = findAccount(toAccountNumber);

        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
    }
}

public class App {
    public static void main(String[] args) {
        Bank bank = new Bank();

        BankAccount account1 = bank.createAccount("John Doe", 1000);
        BankAccount account2 = bank.createAccount("Jane Smith", 500);

        try {
            account1.deposit(200);
            System.out.println(account1.getAccountSummary());

            account1.withdraw(150);
            System.out.println(account1.getAccountSummary());

            bank.transferMoney(1, 2, 300);
            System.out.println(account1.getAccountSummary());
            System.out.println(account2.getAccountSummary());

        } catch (InsufficientFundsException | NegativeAmountException | AccountNotFoundException e) {
            e.printStackTrace();
        }
    }
}
