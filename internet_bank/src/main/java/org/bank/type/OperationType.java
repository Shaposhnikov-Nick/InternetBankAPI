package org.bank.type;

public enum OperationType {
    RECEIVING("Receiving money"),
    INVESTING("Investing money");

    private String operation;

    OperationType(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }


}
