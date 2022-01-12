package org.bank.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/*
класс - обработчик исключений
 */

@ControllerAdvice
public class BalanceGlobalExceptionHandler {

    //обработчик исключения, возникающего при недостаточности средств на счете для снятия
    @ExceptionHandler
    public ResponseEntity<ChangeBalanceIncorrectData> handlerException(InsufficientFundsOnTheAccountException exception){
        ChangeBalanceIncorrectData data = new ChangeBalanceIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE);
    }
}
