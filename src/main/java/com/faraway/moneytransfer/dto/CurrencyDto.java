package com.faraway.moneytransfer.dto;

import java.util.Objects;

/**
 * User: mterentyev
 * Date: 13.08.2018
 */
public class CurrencyDto {

    private int id;

    private String name;

    private String isoCurrencyCode;

    public CurrencyDto() {}

    public CurrencyDto(int id, String name, String isoCurrencyCode) {
        this.id = id;
        this.name = name;
        this.isoCurrencyCode = isoCurrencyCode;
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

    public String getIsoCurrencyCode() {
        return isoCurrencyCode;
    }

    public void setIsoCurrencyCode(String isoCurrencyCode) {
        this.isoCurrencyCode = isoCurrencyCode;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof CurrencyDto)) {
            return false;
        }
        CurrencyDto oc = (CurrencyDto) o;
        return (getId() > 0 && oc.getId() > 0)
                ? Objects.equals(getId(), ((CurrencyDto) o).getId())
                : getIsoCurrencyCode().equals(oc.getIsoCurrencyCode());
    }
}
