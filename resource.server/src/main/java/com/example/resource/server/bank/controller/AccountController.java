package com.example.resource.server.bank.controller;

import com.example.resource.server.bank.model.Account;
import com.example.resource.server.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(value = "/api/account")
public class AccountController {
    @Autowired
    AccountService accountService;

    @GetMapping
    public List<Account> getAccounts(Principal principal) {
        String username = principal.getName();
        return accountService.getAccountByOwner(username);
    }

    @PostMapping
    public void createAccount(String name, String owner) {
        accountService.createNewAccount(name, owner);
    }

    @GetMapping("/all")
    public List<Account> getAll() {
        return accountService.getAccounts();
    }

    @PutMapping("/changeBalance")
    public void changeBalance(String accountId, long amount) {
        accountService.changeBalance(accountId, amount);
    }

}
