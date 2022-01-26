package org.bank.service;

import org.bank.dao.AccountBalanceDAO;
import org.bank.dao.OperationDAO;
import org.bank.model.AccountBalanceRequest;
import org.bank.entity.AccountBalance;
import org.bank.exception_handling.InsufficientFundsOnTheAccountException;
import org.bank.model.TransferRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AccountBalanceServiceImpl implements AccountBalanceService {

    @Autowired
    private AccountBalanceDAO accountBalanceDAO;

    @Autowired
    private OperationDAO operationDAO;

    @Autowired
    private OperationService operationService;

    // получение баланса клиента по id
    @Override
    @Transactional
    public AccountBalance getBalance(int id) {
        return accountBalanceDAO.getBalance(id);
    }

    // операция снятия денег со счета
    @Override
    @Transactional
    public AccountBalance takeMoney(AccountBalanceRequest accountBalanceRequest) {

        // получение баланса пользователя по id
        AccountBalance accountBalance = accountBalanceDAO.getBalance(accountBalanceRequest.getId());

        // проверка достаточности средств на балансе пользователя для выполнения операции списания
        if (accountBalanceRequest.getChangeBalance() > accountBalance.getBalance())

            // если средств на счете не достаточно
            throw new InsufficientFundsOnTheAccountException("Недостаточно средств на счете!");
        else {

            // списание со счета
            accountBalance.setBalance(accountBalance.getBalance() - accountBalanceRequest.getChangeBalance());

            // сохранение баланса в БД
            accountBalanceDAO.saveBalance(accountBalance);
        }

        // сохранение операции списания в БД
        operationService.saveOperationTakeMoney(accountBalanceRequest, accountBalance);

        return accountBalance;
    }

    // операция пополнения счета
    @Override
    @Transactional
    public AccountBalance putMoney(AccountBalanceRequest accountBalanceRequest) {

        // получение баланса пользователя
        AccountBalance accountBalance = accountBalanceDAO.getBalance(accountBalanceRequest.getId());

        // увеличение значения суммы на счете
        accountBalance.setBalance(accountBalance.getBalance() + accountBalanceRequest.getChangeBalance());

        // сохранение баланса в БД
        accountBalanceDAO.saveBalance(accountBalance);

        // сохрание операции списания в БД
        operationService.saveOperationPutMoney(accountBalanceRequest, accountBalance);

        return accountBalance;
    }

    // операция перевода денег от клиента другому клиенту
    @Override
    @Transactional
    public AccountBalance transferMoney(TransferRequest transferRequest) {

        // получение баланса счета отправителя
        AccountBalance accountBalanceSender = accountBalanceDAO.getBalance(transferRequest.getMoneySenderId());

        // получение баланса счета получателя
        AccountBalance accountBalanceRecipient = accountBalanceDAO.getBalance(transferRequest.getMoneyRecipientId());

        // проверка достаточность средств на балансе отправителя для выполнения операции перевода
        if (transferRequest.getAmount() > accountBalanceSender.getBalance())

            // если средств на счете не достаточно
            throw new InsufficientFundsOnTheAccountException("Недостаточно средств на счете!");
        else {

            // списание денег со счета отправителя
            accountBalanceSender.setBalance(accountBalanceSender.getBalance() - transferRequest.getAmount());

            // пополнение счета получателя
            accountBalanceRecipient.setBalance(accountBalanceRecipient.getBalance() + transferRequest.getAmount());

            // сохранение изменения в балансе отправителя
            accountBalanceDAO.saveBalance(accountBalanceSender);

            // сохранение изменения в балансе получателя
            accountBalanceDAO.saveBalance(accountBalanceRecipient);

            // сохранение операции перевода в БД
            operationService.saveOperationTransferMoney(accountBalanceSender, accountBalanceRecipient, transferRequest);
        }

        return accountBalanceSender;
    }
}
