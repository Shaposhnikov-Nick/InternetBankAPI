package org.bank.service;

import org.bank.dao.AccountBalanceDAO;
import org.bank.dao.OperationDAO;
import org.bank.dto.AccountBalanceDto;
import org.bank.entity.AccountBalance;
import org.bank.entity.Operation;
import org.bank.exception_handling.InsufficientFundsOnTheAccountException;
import org.bank.type.OperationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class AccountBalanceServiceImpl implements AccountBalanceService {

    @Autowired
    private AccountBalanceDAO accountBalanceDAO;

    @Autowired
    private OperationDAO operationDAO;

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

        Operation operation = new Operation();
        operation.setUserId(accountBalance.getId());
        operation.setDate(new Date());
        operation.setOperationType(OperationType.RECEIVING);
        operationDAO.saveOperation(operation);

        return accountBalance;
    }

    @Override
    @Transactional
    public AccountBalance putMoney(AccountBalanceDto accountBalanceDto) {
        AccountBalance accountBalance = accountBalanceDAO.getBalance(accountBalanceDto.getId());
        accountBalance.setBalance(accountBalance.getBalance() + accountBalanceDto.getChangeBalance());
        accountBalanceDAO.saveBalance(accountBalance);

        Operation operation = new Operation();
        operation.setUserId(accountBalance.getId());
        operation.setDate(new Date());
        operation.setOperationType(OperationType.INVESTING);
        operationDAO.saveOperation(operation);

        return accountBalance;
    }
}
