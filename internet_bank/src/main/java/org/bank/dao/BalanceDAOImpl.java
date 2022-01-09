package org.bank.dao;

import org.bank.entity.Balance;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BalanceDAOImpl implements BalanceDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Balance getBalance(int id) {
        Session session = sessionFactory.getCurrentSession();
        Balance balance = session.get(Balance.class, id);
        return balance;
    }
}
