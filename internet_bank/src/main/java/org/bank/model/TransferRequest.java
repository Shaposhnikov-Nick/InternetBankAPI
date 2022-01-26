package org.bank.model;

/*
Тело запроса на первод средств от одного клиента другому
 */

public class TransferRequest {

    // id отправителя
    private int moneySenderId;

    // id получателя
    private int moneyRecipientId;

    // сумма перевода
    private int amount;

    public TransferRequest() {
    }

    public TransferRequest(int moneySenderId, int moneyRecipientId, int amount) {
        this.moneySenderId = moneySenderId;
        this.moneyRecipientId = moneyRecipientId;
        this.amount = amount;
    }

    public int getMoneySenderId() {
        return moneySenderId;
    }

    public void setMoneySenderId(int moneySenderId) {
        this.moneySenderId = moneySenderId;
    }

    public int getMoneyRecipientId() {
        return moneyRecipientId;
    }

    public void setMoneyRecipientId(int moneyRecipientId) {
        this.moneyRecipientId = moneyRecipientId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
