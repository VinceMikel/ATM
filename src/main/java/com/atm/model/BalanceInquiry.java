package com.atm.model;

import com.atm.database.BankDatabase;

public class BalanceInquiry extends Transaction {

    public BalanceInquiry(Account account,
                          BankDatabase bankDatabase) {

        super(account, bankDatabase);
    }



    @Override
    public void execute() {

        account.addTransaction(
                "Balance Inquiry: $" + account.getBalance()
        );

        System.out.println(
                "Current balance: $" + account.getBalance()
        );
    }
}