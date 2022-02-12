package org.bank.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bank.type.OperationType;
import javax.persistence.*;
import java.util.Date;

/*
Операции, выполняемые клиентами
 */

@Entity
@Table(name = "operation")
public class Operation {

    // id операции
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonProperty("id")
    private int id;

    // id клиента, выполняющего операцию
    @Column(name = "user_id")
    @JsonProperty("userId")
    private int userId;

    // тип операции
    @Column(name = "operation_type")
    @JsonProperty("operationType")
    private OperationType operationType;

    // id клиента, в отношении которого выполняется операция
    @Column(name = "client_id")
    @JsonProperty("clientId")
    private int clientId;

    // сумма, на которую выполняется операция
    @Column(name = "amount")
    @JsonProperty("amount")
    private long amount;

    // дата выполнения операции
    @Column(name = "date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonProperty("date")
    private Date date;


    public Operation() {
    }

    public Operation(int id, int userId, OperationType operationType, Date date, long amount, int clientId) {
        this.id = id;
        this.userId = userId;
        this.operationType = operationType;
        this.date = date;
        this.amount = amount;
        this.clientId = clientId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int user_id) {
        this.userId = user_id;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    @Override
    public String toString() {
        return "OperationList{" +
                "id=" + id +
                ", user_id=" + userId +
                ", operationType=" + operationType +
                ", date=" + date +
                '}';
    }
}
