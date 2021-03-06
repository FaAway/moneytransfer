package com.faraway.moneytransfer.model;

import java.math.BigDecimal;

/**
 * User: mterentyev
 * Date: 13.08.2018
 */
public class Money {
    private BigDecimal amount;
    private Currency currency;

    public Money() {
    }

    public Money(BigDecimal amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
