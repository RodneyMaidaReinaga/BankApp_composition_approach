package org.example.view.console;

import org.example.controller.*;
import org.example.model.Account;
import org.example.model.Transaction;
import org.example.model.TransactionType;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class ConsoleApp {
    private BankAccountController bankAccountControllerWithdraw;
    private BankAccountController bankAccountControllerDeposit;
    private TransactionsController transactionsController;
    private OwnerController ownerController;
    private AccountBalanceController accountBalanceController;

    public static void main(String[] args) {
        new ConsoleApp().run();
    }

    public ConsoleApp() {
        ControllerManager controllerManager = new ControllerManager();
        bankAccountControllerWithdraw = controllerManager.getAccountController();
        bankAccountControllerDeposit = controllerManager.getAccountControllerDeposit();
        transactionsController = controllerManager.getTransactionsControler();
        ownerController = controllerManager.getOwnerController();
        accountBalanceController = controllerManager.getBalanceController();
    }

    public void run() {
        String ownerName = "jperez";

        // TODO Change this to use DTOs
        List<Account> accounts = ownerController.getAccountsByOwner(ownerName);

        // TODO Add InfoProvider to replace this logic
        Account account = accounts.get(0);

        printWelcomeMessage(ownerName, account.getId());
        showMainMenu();
        selectOption(account.getId());
    }

    private static void print(String message) {
        System.out.println(message);
    }

    private void printWelcomeMessage(String name, int accountId) {
        // Welcome to the BankApp
        print("Welcome " + name);
        print("Your current account is " + accountId);
    }

    private void showMainMenu() {
        // Main Menu
        print(System.lineSeparator());
        print("********************");
        print("(W) Withdraw");
        print("(D) Deposit");
        print("(B) My Balance");
        print("(T) My Transactions");
        print("(E) Exit");
        print("********************");
    }

    private void selectOption(int accountId) {
        // Press a key to select an option
        try (Scanner scanner = new Scanner(System.in)){
            boolean closeApp = false;
            char option;
            while (true) {
                System.out.print("Select an option: ");
                option = getSelectedOption(scanner);
                switch (option) {
                    case 'A':
                        showMainMenu();
                        break;
                    case 'B':
                        print("My Balance is ... " + myBalance(accountId));
                        //myBalance(accountId);
                        break;
                    case 'D':
                        deposit(scanner, accountId);
                        break;
                    case 'E':
                        print("Exit...");
                        closeApp = true;
                        break;
                    case 'T':
                        myTransactions(accountId);
                        break;
                    case 'W':
                        withdraw(scanner, accountId, myBalance(accountId));
                        break;
                    default:
                        print(option + " is an invalid option");
                        break;
                }

                // Is running
                if (closeApp) {
                    break;
                }

                print("(A) Show All options");
            }
        }
    }

    private char getSelectedOption(Scanner scanner) {
        return scanner.next().trim().toUpperCase().charAt(0);
    }

//    private void withdraw(Scanner scanner, int accountId) {
//        System.out.print("Enter amount you need to withdraw: ");
//        double amount = scanner.nextDouble();
//        if (myBalance(accountId) >= amount) {
//            bankAccountControllerWithdraw.withdraw(accountId, amount);
//            System.out.println("successful withdraw operation");
//        } else {
//            System.out.println("You don't have enough funds to withdraw " + amount);
//        }
//    }

//    private void withdraw(Scanner scanner, int accountId, double balance) {
//        System.out.print("Enter amount you need to withdraw: ");
//        double amount = scanner.nextDouble();
//        if (balance >= amount) {
//            bankAccountControllerWithdraw.withdraw(accountId, amount);
//            System.out.println("successful withdraw operation");
//        } else {
//            System.out.println("You don't have enough funds to withdraw " + amount);
//        }
//    }

    private void withdraw(Scanner scanner, int accountId, double balance) {
        System.out.print("Enter amount you need to withdraw: ");
        double amount = scanner.nextDouble();
        bankAccountControllerWithdraw.withdraw(accountId, amount, balance);
    }

    private void deposit(Scanner scanner, int accountId) {
        System.out.print("Enter amount you want to deposit: ");
        double amount = scanner.nextDouble();
        bankAccountControllerDeposit.deposit(accountId, amount);
        System.out.println("successful deposit operation");
    }

    private void myTransactions(int accountId) {

        for (Transaction transaction : transactionsController.getTransactionsByAccount(accountId)) {
            System.out.println(transaction.toString());
        }
    }

    private double myBalance(int accountId) {
        return accountBalanceController.getBalanceByAccount(accountId);
    }
}
