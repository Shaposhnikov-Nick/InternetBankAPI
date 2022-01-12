package org.bank.controller;

import org.bank.dto.AccountBalanceDto;
import org.bank.entity.AccountBalance;
import org.bank.service.AccountBalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AppController {

    @Autowired
    private AccountBalanceService accountBalanceService;

    // получение баланса клиента по id
    @GetMapping("/balance/{id}")
    public AccountBalance getBalance(@PathVariable int id) {
        return accountBalanceService.getBalance(id);
    }

    // снятие денег со счета
    @PutMapping("/take")
    public AccountBalance takeMoney(@RequestBody AccountBalanceDto accountBalanceDto) {
        return accountBalanceService.takeMoney(accountBalanceDto);
    }

    // пополнение счета
    @PutMapping("/put")
    public AccountBalance putMoney(@RequestBody AccountBalanceDto accountBalanceDto){
        return accountBalanceService.putMoney(accountBalanceDto);
    }
}
