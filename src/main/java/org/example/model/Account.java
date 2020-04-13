package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private int id;
    private String ownerId;
    private List<Transaction> transactions;

    public Account(int id, String ownerId) {
        this.id = id;
        this.ownerId = ownerId;
        transactions = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public String getOwnerId() {
        return ownerId;
    }
}
