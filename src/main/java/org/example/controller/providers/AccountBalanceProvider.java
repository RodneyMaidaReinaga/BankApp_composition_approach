package org.example.controller.providers;

import org.example.controller.interfaces.IInfoProvider;
import org.example.model.Transaction;
import org.example.model.TransactionType;
import org.example.model.interfaces.IDataSaver;

import java.util.List;

public class AccountBalanceProvider implements IInfoProvider<Double, Integer> {

    private IDataSaver dataSaver;

    public AccountBalanceProvider(IDataSaver dataSaver) {
        this.dataSaver = dataSaver;
    }

    @Override
    public Double get(Integer accountId) {

        double balance = 0;

        for (Transaction trasaction : dataSaver.getAccountById(accountId).getTransactions()) {

            if (trasaction.getTransactionType() == TransactionType.DEPOSIT) {
                balance = balance + trasaction.getAmount();
            } else {
                balance = balance - trasaction.getAmount();
            }
        }

        return balance;
    }
}
