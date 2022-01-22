package org.bank.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.bank.type.OperationType;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "operation")
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "operation_type")
    private OperationType operationType;

    @Column(name = "date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date date;

    @Column(name = "amount")
    private long amount;

    public Operation() {
    }

    public Operation(int id, int userId, OperationType operationType, Date date, long amount) {
        this.id = id;
        this.userId = userId;
        this.operationType = operationType;
        this.date = date;
        this.amount = amount;
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
