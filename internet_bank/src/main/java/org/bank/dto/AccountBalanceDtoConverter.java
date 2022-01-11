package org.bank.dto;

import org.bank.entity.AccountBalance;
import org.springframework.stereotype.Service;

@Service
public class AccountBalanceDtoConverter {

    private AccountBalance accountBalance;
    private AccountBalanceDto accountBalanceDto;

    private AccountBalanceDtoConverter() {
    }

    public AccountBalanceDto convertAccountBalanceToDto(AccountBalance accountBalance) {
        AccountBalanceDto accountBalanceDto = new AccountBalanceDto();
        accountBalanceDto.setId(accountBalance.getId());
        accountBalanceDto.setBalance(accountBalance.getBalance());
        return accountBalanceDto;
    }

    public AccountBalance convertDtoToAccountBalance(AccountBalanceDto accountBalanceDto) {
        AccountBalance accountBalance = new AccountBalance();
        accountBalance.setId(accountBalanceDto.getId());
        accountBalance.setBalance(accountBalanceDto.getBalance());
        return accountBalance;
    }
}
