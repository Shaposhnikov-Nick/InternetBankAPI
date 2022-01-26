package org.bank.dao;

import org.bank.entity.Operation;
import org.bank.model.OperationRequest;

import java.util.List;

public interface OperationDAO {

    List<Operation> getOperationList(OperationRequest operationRequest);

    List<Operation> getOperationList();

    void saveOperation(Operation operation);
}
