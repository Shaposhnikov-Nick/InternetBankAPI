package org.bank.entity;

import javax.persistence.*;

/*
Текущий баланс клиентов
 */

@Entity
@Table(name = "balance")
public class AccountBalance {

    // id клиента
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    // баланс клиента
    @Column(name = "balance")
    private long balance;

    public AccountBalance() {
    }

    public AccountBalance(int id, long balance) {
        this.id = id;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Balance{" +
                "id=" + id +
                ", balance=" + balance +
                '}';
    }
}
