package org.bank.exception_handling;

/*
класс - информация для возникающих Exception при недостаточности средств на счете для снятия
 */

public class ChangeBalanceIncorrectData {

    private String info;

    public ChangeBalanceIncorrectData() {
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
