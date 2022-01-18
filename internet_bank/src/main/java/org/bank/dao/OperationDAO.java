package org.bank.dao;

import org.bank.entity.Operation;

import java.util.List;

public interface OperationDAO {

    List<Operation> getOperationList();

    void saveOperation(Operation operation);

    Operation getOperation();
}
