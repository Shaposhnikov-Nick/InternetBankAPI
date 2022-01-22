package org.bank.service;

import org.bank.entity.Operation;
import org.bank.model.OperationRequest;

import java.util.Date;
import java.util.List;

public interface OperationService {

    List<Operation> getOperationList(OperationRequest operationRequest);

    List<Operation> getOperationList();
}
