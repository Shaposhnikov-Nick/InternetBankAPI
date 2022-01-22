package org.bank.dao;

import org.bank.entity.Operation;
import org.bank.model.OperationRequest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OperationDAOImpl implements OperationDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Operation> getOperationList(OperationRequest operationRequest) {
        Session session = sessionFactory.getCurrentSession();
        List<Operation> operationList;

        if (operationRequest.getDateFrom() == null || operationRequest.getDateTo() == null) {
            Query<Operation> query = session.createQuery("select id, userId, operationType, date, amount from Operation " +
                    "where userId =:userId");
            query.setParameter("userId", operationRequest.getUserId());
            operationList = query.getResultList();
        } else {
            Query<Operation> query = session.createQuery("select id, userId, operationType, date, amount from Operation " +
                    "where userId =:userId AND date between :dateFrom AND :dateTo");
            query.setParameter("userId", operationRequest.getUserId());
            query.setParameter("dateFrom", operationRequest.getDateFrom());
            query.setParameter("dateTo", operationRequest.getDateTo());
            operationList = query.getResultList();
        }

        return operationList;
    }

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
}
