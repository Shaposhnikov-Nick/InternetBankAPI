package org.bank.dto;


public class AccountBalanceDto {

        private int id;

        private long balance;

        // сумма, на которую изменяется баланс счета
        private long changeBalance;

        public AccountBalanceDto() {
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
