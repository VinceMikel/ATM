package com.atm.model;
import java.util.ArrayList;
import java.util.List;

public class Account {

    private int accountNumber;
    private int pin;
    private double balance;
    private List<String> transactionHistory;


    public Account(int accountNumber, int pin, double balance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;

        transactionHistory = new ArrayList<>();
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public boolean validatePin(int userPin) {
        return this.pin == userPin;
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

    public void addTransaction(String transaction) {

        transactionHistory.add(transaction);
    }

    public List<String> getTransactionHistory() {

        return transactionHistory;
    }
}