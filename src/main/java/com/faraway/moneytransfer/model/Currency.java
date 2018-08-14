package com.faraway.moneytransfer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

/**
 * User: mterentyev
 * Date: 13.08.2018
 */
@Entity
@Table(name = "currency")
public class Currency extends NamedEntity {
    @Column(name = "iso_currency_code", nullable = false)
    private String isoCurrencyCode;

    public Currency() {}

    public Currency(String isoCurrencyCode, String name) {
        this.isoCurrencyCode = isoCurrencyCode;
        this.name = name;
    }

    public Currency(Integer id, String name, String isoCurrencyCode) {
        super(id, name);
        this.isoCurrencyCode = isoCurrencyCode;
    }

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
                ? Objects.equals(getId(), ((Currency) o).getId())
                : getIsoCurrencyCode().equals(oc.getIsoCurrencyCode());
    }
}
