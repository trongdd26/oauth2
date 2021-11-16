package com.example.resource.server.bank.service;

import com.example.resource.server.bank.model.Account;
import com.example.resource.server.bank.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    AccountRepository repository;

    @Override
    public void createNewAccount(String accountName, String owner) {
        Account account = new Account();
        account.setAccountId(UUID.randomUUID().toString());
        account.setName(accountName);
        account.setActivated(true);
        account.setBalance(0);
        account.setOwner(owner);
        repository.save(account);
    }

    @Override
    public List<Account> getAccountByOwner(String owner) {
        return repository.getByOwner(owner);
    }

    @Override
    public List<Account> getAccounts() {
        return repository.findAll();
    }

    @Override
    public void changeBalance(String accountId, long amount) {
        Account account = repository.getById(accountId);
        account.setBalance(account.getBalance() - amount);
    }
}
