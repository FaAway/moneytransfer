package com.faraway.moneytransfer.dto;

import com.faraway.moneytransfer.model.Currency;

import java.math.BigDecimal;

/**
 * Created by пробная уч.запись on 15.08.2018.
 */
public class MoneyDto {
    private BigDecimal amount;
    private CurrencyDto currency;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public CurrencyDto getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyDto currency) {
        this.currency = currency;
    }
}
