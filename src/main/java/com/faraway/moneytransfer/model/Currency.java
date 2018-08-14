package com.faraway.moneytransfer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * User: mterentyev
 * Date: 13.08.2018
 */
@Entity
@Table(name = "currency")
public class Currency extends NamedEntity {

    @Column(name = "iso_currency_code", nullable = false)
    private String isoCurrencyCode;

    public String getIsoCurrencyCode() {
        return isoCurrencyCode;
    }

    public void setIsoCurrencyCode(String isoCurrencyCode) {
        this.isoCurrencyCode = isoCurrencyCode;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Currency)) {
            return false;
        }
        Currency oc = (Currency) o;
        return (this.getId() != null && this.getId() > 0 &&
                oc.getId() != null && oc.getId() > 0)
                ? super.equals(o)
                : getIsoCurrencyCode().equals(oc.getIsoCurrencyCode());
    }
}
