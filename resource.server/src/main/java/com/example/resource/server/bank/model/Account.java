package com.example.resource.server.bank.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "account")
public class Account {
    @Id
    private String accountId;

    private String name;

    private boolean activated;

    private long balance;

    private String owner;
}
