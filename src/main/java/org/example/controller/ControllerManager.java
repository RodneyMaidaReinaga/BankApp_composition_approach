package org.example.controller;

import org.example.controller.operators.DepositOperator;
import org.example.controller.operators.WithdrawOperator;
import org.example.controller.providers.AccountBalanceProvider;
import org.example.controller.providers.AccountsByOwnerProvider;
import org.example.controller.providers.TransactiosByAccountProvider;
import org.example.model.persistence.DataSaverInMemory;

public class ControllerManager {

    public BankAccountController getAccountController() {
        return new BankAccountController(new WithdrawOperator(new DataSaverInMemory()));
    }

    public BankAccountController getAccountControllerDeposit() {
        return new BankAccountController(new DepositOperator(new DataSaverInMemory()));
    }

    public OwnerController getOwnerController() {
        return new OwnerController(new AccountsByOwnerProvider(new DataSaverInMemory()));
    }

    public TransactionsController getTransactionsControler() {
        return new TransactionsController(new TransactiosByAccountProvider(new DataSaverInMemory()));
    }

    public AccountBalanceController getBalanceController() {
        return new AccountBalanceController(new AccountBalanceProvider(new DataSaverInMemory()));
    }
}
