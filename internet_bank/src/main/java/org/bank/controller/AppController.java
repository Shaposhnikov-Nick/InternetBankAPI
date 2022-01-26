package org.bank.controller;

import org.bank.model.AccountBalanceRequest;
import org.bank.entity.AccountBalance;
import org.bank.entity.Operation;
import org.bank.model.OperationRequest;
import org.bank.model.TransferRequest;
import org.bank.service.AccountBalanceService;
import org.bank.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    // снятие денег со счета клиента
    @PutMapping("/take")
    public AccountBalance takeMoney(@RequestBody AccountBalanceRequest accountBalanceRequest) {
        return accountBalanceService.takeMoney(accountBalanceRequest);
    }

    // пополнение счета клиента
    @PutMapping("/put")
    public AccountBalance putMoney(@RequestBody AccountBalanceRequest accountBalanceRequest){
        return accountBalanceService.putMoney(accountBalanceRequest);
    }

    // получение списка операций всех клиентов
    @GetMapping("/operation")
    public List<Operation> getOperationList(){
        return operationService.getOperationList();
    }

    // получение списка операций определенного клиента за выбранный диапазон времени
    @PostMapping("/operation")
    public List<Operation> getOperationList(@RequestBody OperationRequest operationRequest){
        return operationService.getOperationList(operationRequest);
    }

    // перевод денег от одного клиента банка другому
    @PutMapping("/transfer")
    public AccountBalance transferMoney(@RequestBody TransferRequest transferRequest) {
        return accountBalanceService.transferMoney(transferRequest);
    }
}
