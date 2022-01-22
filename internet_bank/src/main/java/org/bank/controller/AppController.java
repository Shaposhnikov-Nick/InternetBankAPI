package org.bank.controller;

import org.bank.dto.AccountBalanceDto;
import org.bank.entity.AccountBalance;
import org.bank.entity.Operation;
import org.bank.model.OperationRequest;
import org.bank.service.AccountBalanceService;
import org.bank.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AppController {

    @Autowired
    private AccountBalanceService accountBalanceService;

    @Autowired
    private OperationService operationService;

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

//    получение списка операций без диапазона
    @GetMapping("/operation")
    public List<Operation> getOperationList(){
        return operationService.getOperationList();
    }

    // получение списка операций за выбранный диапазон времени
    @PostMapping("/operation")
    public List<Operation> getOperationList(@RequestBody OperationRequest operationRequest){
        return operationService.getOperationList(operationRequest);
    }
}
