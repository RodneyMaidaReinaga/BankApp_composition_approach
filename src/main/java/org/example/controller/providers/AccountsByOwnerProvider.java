package org.example.controller.providers;

import org.example.controller.interfaces.IInfoProvider;
import org.example.model.Account;
import org.example.model.interfaces.IDataSaver;

import java.util.List;

public class AccountsByOwnerProvider implements IInfoProvider<List<Account>, String> {

    private IDataSaver dataSaver;

    public AccountsByOwnerProvider(IDataSaver dataSaver) {
        this.dataSaver = dataSaver;
    }

    @Override
    public List<Account> get(String owner) {
        return dataSaver.getAccountsByOwner(owner);
    }
}
