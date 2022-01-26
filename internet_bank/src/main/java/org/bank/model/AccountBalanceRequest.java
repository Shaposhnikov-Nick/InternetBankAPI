package org.bank.model;

/*
Тело запроса изменения баланса клиента
 */

public class AccountBalanceRequest {

        // id клиента
        private int id;

        // текущий баланс счета клента
        private long balance;

        // сумма, на которую изменяется баланс счета
        private long changeBalance;

        public AccountBalanceRequest() {
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

        public long getChangeBalance() {
                return changeBalance;
        }

        public void setChangeBalance(long changeBalance) {
                this.changeBalance = changeBalance;
        }
}
