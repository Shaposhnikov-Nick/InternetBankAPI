package org.bank.service;

import org.bank.dto.AccountBalanceDto;
import org.bank.entity.AccountBalance;

public interface BalanceService {

    AccountBalance getBalance(int id);

    AccountBalance takeMoney(AccountBalanceDto accountBalanceDto);

    AccountBalance putMoney(int id, long sum);



}
