package org.bank.service;

import org.bank.dao.AccountBalanceDAO;
import org.bank.dto.AccountBalanceDto;
import org.bank.entity.AccountBalance;
import org.bank.exception_handling.InsufficientFundsOnTheAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountBalanceServiceImpl implements AccountBalanceService {

    @Autowired
    private AccountBalanceDAO accountBalanceDAO;

    @Override
    @Transactional
    public AccountBalance getBalance(int id) {
        return accountBalanceDAO.getBalance(id);
    }

    @Override
    @Transactional
    public AccountBalance takeMoney(AccountBalanceDto accountBalanceDto) {
        AccountBalance accountBalance = accountBalanceDAO.getBalance(accountBalanceDto.getId());

        if (accountBalanceDto.getChangeBalance() > accountBalance.getBalance())
            throw new InsufficientFundsOnTheAccountException("Недостаточно средств на счете!");
        else {
            accountBalance.setBalance(accountBalance.getBalance() - accountBalanceDto.getChangeBalance());
            accountBalanceDAO.saveBalance(accountBalance);
        }
        return accountBalance;
    }

    @Override
    @Transactional
    public AccountBalance putMoney(AccountBalanceDto accountBalanceDto) {
        AccountBalance accountBalance = accountBalanceDAO.getBalance(accountBalanceDto.getId());
        accountBalance.setBalance(accountBalance.getBalance() + accountBalanceDto.getChangeBalance());
        accountBalanceDAO.saveBalance(accountBalance);
        return accountBalance;
    }
}