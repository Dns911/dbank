package com.dbank.dbankoperationservice.entity.enums;

public enum CurrencyType {
    PLN(11), USD(22), EUR(33);

    private final long currencyNumber;

    CurrencyType(int currencyNumber) {
        this.currencyNumber = currencyNumber;
    }

    public long getCurrencyNumber() {
        return currencyNumber;
    }
}
