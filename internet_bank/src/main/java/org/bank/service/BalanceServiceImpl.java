package org.bank.service;

import org.bank.dao.BalanceDAO;
import org.bank.entity.Balance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BalanceServiceImpl implements BalanceService {

    @Autowired
    private BalanceDAO balanceDAO;

    @Override
    @Transactional
    public Balance getBalance(int id) {
        return balanceDAO.getBalance(id);
    }
}
