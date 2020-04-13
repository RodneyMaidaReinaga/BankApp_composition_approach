package org.example.controller;

import org.example.controller.interfaces.IAccountOperator;

public class BankAccountController {
//    private IAccountOperator withdrawOperator;
//
//
//    public BankAccountController(IAccountOperator withdrawOperator) {
//        this.withdrawOperator = withdrawOperator;
//    }
//
//
//    public void withdraw(int accountId, double amount) {
//        this.withdrawOperator.execute(accountId, amount);
//    }


    private IAccountOperator accountOperator;


    public BankAccountController(IAccountOperator accountOperator) {
        this.accountOperator = accountOperator;
    }

//    public void withdraw(int accountId, double amount) {
//        this.accountOperator.execute(accountId, amount);
//    }

    public void withdraw(int accountId, double amount, double balance) {
        if (balance >= amount) {
            this.accountOperator.execute(accountId, amount);
            System.out.println("successful withdraw operation");
        } else {
            System.out.println("You don't have enough funds to withdraw " + amount);
        }
    }

    public void deposit(int accountId, double amount) {
        this.accountOperator.execute(accountId, amount);
    }

}
