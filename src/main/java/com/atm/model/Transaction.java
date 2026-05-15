package com.atm.model;

import com.atm.database.BankDatabase;

public abstract class Transaction {

    protected Account account;
    protected BankDatabase bankDatabase;

    public Transaction(Account account, BankDatabase bankDatabase) {
        this.account = account;
        this.bankDatabase = bankDatabase;
    }

    public Account getAccount() {
        return account;
    }

    public abstract void execute();
}