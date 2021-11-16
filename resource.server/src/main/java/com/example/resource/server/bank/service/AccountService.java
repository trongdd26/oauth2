package com.example.resource.server.bank.service;

import com.example.resource.server.bank.model.Account;

import java.util.List;

public interface AccountService {
    void createNewAccount(String accountName, String owner);

    List<Account> getAccountByOwner(String owner);

    List<Account> getAccounts();

    void changeBalance(String accountId, long amount);
}
