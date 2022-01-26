package org.bank.exception_handling;

/*
исключение, возникающее при недостаточности средств на счете для снятия
 */

public class InsufficientFundsOnTheAccountException extends RuntimeException{

    public InsufficientFundsOnTheAccountException(String message) {
        super(message);
    }
}
