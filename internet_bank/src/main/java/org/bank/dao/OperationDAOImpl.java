package org.bank.dao;

import org.bank.entity.Operation;
import org.bank.model.OperationRequest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OperationDAOImpl implements OperationDAO {

    @Autowired
    private SessionFactory sessionFactory;

    // получение списка операций клиента по id за указанный диапазон времени
    @Override
    public List<Operation> getOperationList(OperationRequest operationRequest) {
        Session session = sessionFactory.getCurrentSession();
        List<Operation> operationList;
        Query<Operation> query;

        // если дата начала или окончания диапазона не указана
        if (operationRequest.getDateFrom() == null || operationRequest.getDateTo() == null) {

            // список операций за все время
            query = session.createQuery("select id, userId, operationType, clientId, amount, date from Operation " +
                    "where userId =:userId");
            query.setParameter("userId", operationRequest.getUserId());
        } else {

            // список операций за указанный диапазон
            query = session.createQuery("select id, userId, operationType, clientId, amount, date from Operation " +
                    "where userId =:userId AND date between :dateFrom AND :dateTo");
            query.setParameter("userId", operationRequest.getUserId());
            query.setParameter("dateFrom", operationRequest.getDateFrom());
            query.setParameter("dateTo", operationRequest.getDateTo());
        }
        operationList = query.getResultList();

        return operationList;
    }

    // получение списка операций всех клиентов
    @Override
    public List<Operation> getOperationList() {
        Session session = sessionFactory.getCurrentSession();
        List<Operation> operationList = session.createQuery("from Operation", Operation.class).getResultList();

        return operationList;
    }

    // сохранение операции клиента в БД
    @Override
    public void saveOperation(Operation operation) {
        Session session = sessionFactory.getCurrentSession();
        session.save(operation);
    }
}
