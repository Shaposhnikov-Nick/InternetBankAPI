package org.bank;

import org.bank.entity.Balance;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Balance.class)
                .buildSessionFactory();

        //получение баланса по id пользвателя
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            Balance balance = session.get(Balance.class, 2);
            System.out.println(balance);
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
