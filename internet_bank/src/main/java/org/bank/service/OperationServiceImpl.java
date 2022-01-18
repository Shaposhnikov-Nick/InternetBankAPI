package org.bank.service;

import org.bank.dao.OperationDAO;
import org.bank.entity.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OperationServiceImpl implements OperationService{

    @Autowired
    private OperationDAO operationDAO;

    @Override
    @Transactional
    public List<Operation> getOperationList() {
        return operationDAO.getOperationList();
    }
}
