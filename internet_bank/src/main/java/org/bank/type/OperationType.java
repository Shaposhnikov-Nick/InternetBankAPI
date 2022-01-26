package org.bank.type;

/*
Типы выполняемых переводов
 */
public enum OperationType {
    RECEIVING("Receiving money"),
    INVESTING("Investing money"),
    TRANSFER_TO("Transfer money to"),
    TRANSFER_FROM("Transfer money from");

    private String operation;

    OperationType(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }


}
