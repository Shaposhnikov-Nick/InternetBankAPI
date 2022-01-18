package org.bank.dao;

import org.bank.entity.Operation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OperationDAOImpl implements OperationDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Operation> getOperationList() {
        Session session = sessionFactory.getCurrentSession();
        List<Operation> operationList = session.createQuery("from Operation", Operation.class).getResultList();
        return operationList;
    }

    @Override
    public void saveOperation(Operation operation) {
        Session session = sessionFactory.getCurrentSession();
        session.save(operation);
    }

    @Override
    public Operation getOperation() {
        return null;
    }
}
