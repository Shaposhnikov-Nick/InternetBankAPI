package org.bank.controller;

import org.bank.dto.AccountBalanceDto;
import org.bank.entity.AccountBalance;
import org.bank.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AppController {

    @Autowired
    private BalanceService balanceService;

    // получение баланса клиента по id
    @GetMapping("/balance/{id}")
    public AccountBalance getBalance(@PathVariable int id) {
        AccountBalance balance = balanceService.getBalance(id);
        return balance;
    }

    // снятие денег со счета
    @PutMapping("/balance")
    public AccountBalance takeMoney(@RequestBody AccountBalanceDto accountBalanceDto) {
        return balanceService.takeMoney(accountBalanceDto);
    }
}
