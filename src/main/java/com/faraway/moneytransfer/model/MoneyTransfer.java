package com.faraway.moneytransfer.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * User: mterentyev
 * Date: 13.08.2018
 */

@NamedQueries({
        @NamedQuery(name = MoneyTransfer.GET_BETWEEN, query = "SELECT m FROM MoneyTransfer m "+
                "WHERE (m.sender.id=:senderId or m.recipient.id=:recipientID) AND m.operationDate BETWEEN :startDate AND :endDate ORDER BY m.operationDate DESC"),
        @NamedQuery(name = MoneyTransfer.ALL_BY_ACCOUNT_SORTED, query = "SELECT DISTINCT(m) FROM MoneyTransfer m " +
                "WHERE m.sender.id=:senderId or m.recipient.id=:recipientID ORDER BY m.operationDate"),
})
@Entity
@Table(name = "money_transfer")
public class MoneyTransfer extends BaseEntity {

    public MoneyTransfer() {}

    public MoneyTransfer(Account sender, Account recipient, BigDecimal sourceCurrencyUnits, BigDecimal targetCurrencyUnits) {
        this.sender = sender;
        this.recipient = recipient;
        this.sourceCurrencyUnits = sourceCurrencyUnits;
        this.targetCurrencyUnits = targetCurrencyUnits;
    }

    public static final String ALL_BY_ACCOUNT_SORTED = "MoneyTransfer.allByAccountSorted";
    public static final String GET_BETWEEN = "MoneyTransfer.getBetween";

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_id", nullable = false)
    private Account sender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipient_id", nullable = false)
    private Account recipient;

    @Column(name = "operation_date", columnDefinition = "timestamp default now()")
    private Date operationDate;

    @Column(name = "source_currency_units", nullable = false)
    private BigDecimal sourceCurrencyUnits;

    @Column(name = "target_currency_units", nullable = false)
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
