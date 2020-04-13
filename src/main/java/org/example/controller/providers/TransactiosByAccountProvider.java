package org.example.controller.providers;

import org.example.controller.interfaces.IInfoProvider;
import org.example.model.Transaction;
import org.example.model.interfaces.IDataSaver;

import java.util.List;

public class TransactiosByAccountProvider implements IInfoProvider<List<Transaction>, Integer> {

    private IDataSaver dataSaver;

    public TransactiosByAccountProvider(IDataSaver dataSaver) {
        this.dataSaver = dataSaver;
    }

    @Override
    public List<Transaction> get(Integer accountId) {
        return dataSaver.getAccountById(accountId).getTransactions();
    }
}
