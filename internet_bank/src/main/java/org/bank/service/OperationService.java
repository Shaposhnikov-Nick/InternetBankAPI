package org.bank.service;

import org.bank.entity.AccountBalance;
import org.bank.entity.Operation;
import org.bank.model.AccountBalanceRequest;
import org.bank.model.OperationRequest;
import org.bank.model.TransferRequest;


import java.util.List;

public interface OperationService {

    List<Operation> getOperationList(OperationRequest operationRequest);

    List<Operation> getOperationList();

    void saveOperationTakeMoney(AccountBalanceRequest accountBalanceRequest,AccountBalance accountBalance);

    void saveOperationPutMoney(AccountBalanceRequest accountBalanceRequest,AccountBalance accountBalance);

    void saveOperationTransferMoney(AccountBalance accountBalanceSender, AccountBalance accountBalanceRecipient,
                                    TransferRequest transferRequest);
}
