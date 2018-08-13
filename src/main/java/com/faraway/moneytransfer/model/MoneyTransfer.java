package com.faraway.moneytransfer.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * User: mterentyev
 * Date: 13.08.2018
 */
public class MoneyTransfer extends BaseEntity {
    private Account sender;
    private Account recipient;
    private Date operationDate;
    private BigDecimal sourceCurrencyUnits;
    private BigDecimal targetCurrencyUnits;

    public Account getSender() {
        return sender;
    }

    public void setSender(Account sender) {
        this.sender = sender;
    }

    public Account getRecipient() {
        return recipient;
    }

    public void setRecipient(Account recipient) {
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
