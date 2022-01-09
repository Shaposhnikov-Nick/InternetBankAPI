package org.bank.controller;

import org.bank.entity.Balance;
import org.bank.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AppController {

    @Autowired
    private BalanceService balanceService;

    @GetMapping("/balance/{id}")
    public Balance getBalance(@PathVariable int id){
        Balance balance = balanceService.getBalance(id);
        return balance;
    }
}
