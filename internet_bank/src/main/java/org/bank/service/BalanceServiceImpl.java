package org.bank.service;

import org.bank.dao.AccountBalanceDAO;
import org.bank.dto.AccountBalanceDto;
import org.bank.dto.AccountBalanceDtoConverter;
import org.bank.entity.AccountBalance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BalanceServiceImpl implements BalanceService {

    @Autowired
    private AccountBalanceDtoConverter accountBalanceDtoConverter;

    @Autowired
    private AccountBalanceDAO balanceDAO;

    @Override
    @Transactional
    public AccountBalance getBalance(int id) {
        return balanceDAO.getBalance(id);
    }

    @Override
    @Transactional
    public AccountBalance takeMoney(AccountBalanceDto accountBalanceDto) {
        AccountBalance accountBalance = balanceDAO.getBalance(accountBalanceDto.getId());

        if (accountBalanceDto.getBalance() > accountBalance.getBalance())
            return null;
        else {
            accountBalance.setBalance(accountBalance.getBalance() - accountBalanceDto.getChangeBalance());
            balanceDAO.saveBalance(accountBalance);
        }
        return accountBalance;
    }

    @Override
    @Transactional
    public AccountBalance putMoney(int id, long sum) {
        return null;
    }
}
