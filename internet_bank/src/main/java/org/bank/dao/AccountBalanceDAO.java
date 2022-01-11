package org.bank.dao;

import org.bank.entity.AccountBalance;

public interface AccountBalanceDAO {

    AccountBalance getBalance(int id);

    void saveBalance(AccountBalance accountBalance);
}
