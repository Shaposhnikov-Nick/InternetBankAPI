package org.bank.service;

import org.bank.model.AccountBalanceRequest;
import org.bank.entity.AccountBalance;
import org.bank.model.TransferRequest;

public interface AccountBalanceService {

    AccountBalance getBalance(int id);

    AccountBalance takeMoney(AccountBalanceRequest accountBalanceRequest);

    AccountBalance putMoney(AccountBalanceRequest accountBalanceRequest);

    AccountBalance transferMoney(TransferRequest transferRequest);
}
