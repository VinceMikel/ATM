package com.atm.util;

import com.atm.model.Account;

public class Session {

    private static Account currentAccount;

    public static void setCurrentAccount(Account account) {
        currentAccount = account;
    }

    public static Account getCurrentAccount() {
        return currentAccount;
    }
}