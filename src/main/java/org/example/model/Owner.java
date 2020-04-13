package org.example.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Owner {
    private String username;
    private List<Account> accounts;

    public Owner(String username) {
        this.username = username;
        this.accounts = new ArrayList<>();
    }

    public String getId() {
        return username;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public List<Account> getAccounts() {
        return Collections.unmodifiableList(accounts);
    }
}
