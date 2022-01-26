package org.bank.model;

import java.util.Date;

/*
Тело запроса на получение списка операций пользователя за указанный промежуток времени
 */

public class OperationRequest {

    // id клиента
    private int userId;

    // начало диапазона дат
    private Date dateFrom;

   // конец диапазона дат
    private Date dateTo;

    public OperationRequest(int user_id, Date dateFrom, Date dateTo) {
        this.userId = user_id;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public OperationRequest() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int user_id) {
        this.userId = user_id;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }
}
