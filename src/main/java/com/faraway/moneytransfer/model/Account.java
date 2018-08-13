package com.faraway.moneytransfer.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * User: mterentyev
 * Date: 08.08.2018
 */
public class Account extends NamedEntity {
    private Date registered;
    private boolean enabled;
    private BigDecimal amount;
    private Currency currency;

    public Date getRegistered() {
        return registered;
    }

    public void setRegistered(Date registered) {
        this.registered = registered;
    }
}
