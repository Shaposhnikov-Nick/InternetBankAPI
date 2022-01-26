package org.bank.service;

import org.bank.dao.OperationDAO;
import org.bank.entity.AccountBalance;
import org.bank.entity.Operation;
import org.bank.model.AccountBalanceRequest;
import org.bank.model.OperationRequest;
import org.bank.model.TransferRequest;
import org.bank.type.OperationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class OperationServiceImpl implements OperationService {

    @Autowired
    private OperationDAO operationDAO;

    // получение списка операций с условием (id клиента и период времени)
    @Override
    @Transactional
    public List<Operation> getOperationList(OperationRequest operationRequest) {
        return operationDAO.getOperationList(operationRequest);
    }

    // получение списка всех операций из БД
    @Override
    @Transactional
    public List<Operation> getOperationList() {
        return operationDAO.getOperationList();
    }


    // сохранение операции внесения денег на счет в БД
    @Override
    public void saveOperationPutMoney(AccountBalanceRequest accountBalanceRequest, AccountBalance accountBalance) {
        Operation operation = new Operation();
        operation.setUserId(accountBalance.getId());
        operation.setDate(new Date());
        operation.setOperationType(OperationType.INVESTING);
        operation.setAmount(accountBalanceRequest.getChangeBalance());
        operation.setClientId(accountBalance.getId());
        operationDAO.saveOperation(operation);
    }

    // сохранение операции снятия денег со счета в БД
    @Override
    public void saveOperationTakeMoney(AccountBalanceRequest accountBalanceRequest, AccountBalance accountBalance) {
        Operation operation = new Operation();
        operation.setUserId(accountBalance.getId());
        operation.setDate(new Date());
        operation.setOperationType(OperationType.RECEIVING);
        operation.setAmount(accountBalanceRequest.getChangeBalance());
        operation.setClientId(accountBalance.getId());
        operationDAO.saveOperation(operation);
    }

    // сохранение операции перевода денег от одного клиента другому в БД
    @Override
    public void saveOperationTransferMoney(AccountBalance accountBalanceSender, AccountBalance accountBalanceRecipient,
                                           TransferRequest transferRequest) {

        // сохранение операции перевода в БД
        Operation sendOperation = new Operation();
        sendOperation.setUserId(accountBalanceSender.getId());
        sendOperation.setDate(new Date());
        sendOperation.setOperationType(OperationType.TRANSFER_TO);
        sendOperation.setAmount(transferRequest.getAmount());
        sendOperation.setClientId(transferRequest.getMoneyRecipientId());
        operationDAO.saveOperation(sendOperation);

        // сохранение операции получения в БД
        Operation receiveOperation = new Operation();
        receiveOperation.setUserId(accountBalanceRecipient.getId());
        receiveOperation.setDate(new Date());
        receiveOperation.setOperationType(OperationType.TRANSFER_FROM);
        receiveOperation.setAmount(transferRequest.getAmount());
        receiveOperation.setClientId(transferRequest.getMoneySenderId());
        operationDAO.saveOperation(receiveOperation);
    }
}
