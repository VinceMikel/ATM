package com.atm.database;

import com.atm.model.Account;

import java.util.ArrayList;
import java.util.List;

public class BankDatabase {

    private List<Account> accounts;

    public BankDatabase() {

        accounts = new ArrayList<>();

        accounts.add(new Account(12345, 11111, 1000));
        accounts.add(new Account(54321, 22222, 500));
    }

    public Account authenticateUser(int accountNumber, int pin) {

        for (Account account : accounts) {

            if (account.getAccountNumber() == accountNumber
                    && account.validatePin(pin)) {

                return account;
            }
        }

        return null;
    }
}