package org.bank.dao;

import org.bank.entity.AccountBalance;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountBalanceDAOImpl implements AccountBalanceDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public AccountBalance getBalance(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(AccountBalance.class, id);
    }

    @Override
    public void saveBalance(AccountBalance accountBalance) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(accountBalance);
    }
}
