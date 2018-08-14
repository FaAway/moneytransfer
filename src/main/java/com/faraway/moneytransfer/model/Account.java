package com.faraway.moneytransfer.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * User: mterentyev
 * Date: 08.08.2018
 */
@NamedQueries({
        @NamedQuery(name = Account.DELETE, query = "DELETE FROM Account a WHERE a.id=:id"),
        @NamedQuery(name = Account.ALL_SORTED, query = "SELECT DISTINCT(a) FROM Account a ORDER BY a.registered"),
})
@Entity
@Table(name = "account")
public class Account extends NamedEntity {

    public static final String DELETE = "Account.delete";
    public static final String ALL_SORTED = "Account.getAllSorted";

    @Column(name = "registered", columnDefinition = "timestamp default now()")
    private Date registered;

    @Column(name = "enabled", nullable = false)
    private boolean enabled;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "currency_id", nullable = false)
    private Currency currency;

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

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Date getRegistered() {
        return registered;
    }

    public void setRegistered(Date registered) {
        this.registered = registered;
    }
}
