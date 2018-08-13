package com.faraway.moneytransfer.model;

/**
 * User: mterentyev
 * Date: 13.08.2018
 */
public class Currency extends NamedEntity {
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
