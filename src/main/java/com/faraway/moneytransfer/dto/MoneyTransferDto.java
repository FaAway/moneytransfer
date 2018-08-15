package com.faraway.moneytransfer.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * User: mterentyev
 * Date: 13.08.2018
 */


public class MoneyTransferDto {

    private int id;

    private AccountDto sender;

    private AccountDto recipient;

    private Date operationDate;

    private BigDecimal sourceCurrencyUnits;

    private BigDecimal targetCurrencyUnits;

    public MoneyTransferDto() {}

    public MoneyTransferDto(int id, AccountDto sender, AccountDto recipient, Date operationDate, BigDecimal sourceCurrencyUnits, BigDecimal targetCurrencyUnits) {
        this.id = id;
        this.sender = sender;
        this.recipient = recipient;
        this.operationDate = operationDate;
        this.sourceCurrencyUnits = sourceCurrencyUnits;
        this.targetCurrencyUnits = targetCurrencyUnits;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AccountDto getSender() {
        return sender;
    }

    public void setSender(AccountDto sender) {
        this.sender = sender;
    }

    public AccountDto getRecipient() {
        return recipient;
    }

    public void setRecipient(AccountDto recipient) {
        this.recipient = recipient;
    }

    public Date getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(Date operationDate) {
        this.operationDate = operationDate;
    }

    public BigDecimal getSourceCurrencyUnits() {
        return sourceCurrencyUnits;
    }

    public void setSourceCurrencyUnits(BigDecimal sourceCurrencyUnits) {
        this.sourceCurrencyUnits = sourceCurrencyUnits;
    }

    public BigDecimal getTargetCurrencyUnits() {
        return targetCurrencyUnits;
    }

    public void setTargetCurrencyUnits(BigDecimal targetCurrencyUnits) {
        this.targetCurrencyUnits = targetCurrencyUnits;
    }
}
