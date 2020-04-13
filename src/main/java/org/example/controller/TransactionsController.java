package org.example.controller;

import org.example.controller.interfaces.IInfoProvider;
import org.example.controller.providers.TransactiosByAccountProvider;
import org.example.model.Account;
import org.example.model.Transaction;

import java.util.List;

public class TransactionsController {

    private IInfoProvider<List<Transaction>, Integer> transactiosByAccountProvider;

    public TransactionsController(TransactiosByAccountProvider transactiosByAccountProvider) {
        this.transactiosByAccountProvider = transactiosByAccountProvider;
    }

    public List<Transaction> getTransactionsByAccount(Integer accountId) {
        return transactiosByAccountProvider.get(accountId);
    }

}
