package com.faraway.moneytransfer.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * User: mterentyev
 * Date: 13.08.2018
 */
public class AccountDto {

    private int id;

    private String name;

    private Date registered;

    private boolean enabled;

    private BigDecimal amount;

    private CurrencyDto currency;

    public AccountDto() {
    }

    public AccountDto(int id, String name, Date registered, boolean enabled, BigDecimal amount, CurrencyDto currency) {
        this.id = id;
        this.name = name;
        this.registered = registered;
        this.enabled = enabled;
        this.amount = amount;
        this.currency = currency;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

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

    public Date getRegistered() {
        return registered;
    }

    public void setRegistered(Date registered) {
        this.registered = registered;
    }
}
