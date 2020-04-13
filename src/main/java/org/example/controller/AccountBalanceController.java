package org.example.controller;

import org.example.controller.interfaces.IInfoProvider;
import org.example.controller.providers.AccountBalanceProvider;
import org.example.controller.providers.TransactiosByAccountProvider;
import org.example.model.Transaction;

import java.util.List;

public class AccountBalanceController {
    private IInfoProvider<Double, Integer> accountBalanceProvider;

    public AccountBalanceController(AccountBalanceProvider accountBalanceProvider) {
        this.accountBalanceProvider = accountBalanceProvider;
    }

    public Double getBalanceByAccount(Integer accountId) {
        return accountBalanceProvider.get(accountId);
    }

}
