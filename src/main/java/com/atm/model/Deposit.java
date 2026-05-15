package com.atm.model;

import com.atm.database.BankDatabase;

public class Deposit extends Transaction {

    private double amount;

    public Deposit(Account account,
                   BankDatabase bankDatabase,
                   double amount) {

        super(account, bankDatabase);
        this.amount = amount;
    }

    @Override
    public void execute() {

        account.deposit(amount);

        account.addTransaction(
                "Deposit: $" + amount
        );

        System.out.println("Successfully deposited $" + amount);
    }
}