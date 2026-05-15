package com.atm.model;

import com.atm.database.BankDatabase;

public class Withdrawal extends Transaction {

    private double amount;

    public Withdrawal(Account account,
                      BankDatabase bankDatabase,
                      double amount) {

        super(account, bankDatabase);
        this.amount = amount;
    }

    @Override
    public void execute() {

        boolean success = account.withdraw(amount);

        if (success) {
            System.out.println("Successfully withdrew $" + amount);
        } else {
            System.out.println("Insufficient funds.");
        }
    }
}