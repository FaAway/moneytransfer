package com.faraway.moneytransfer.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * User: mterentyev
 * Date: 08.08.2018
 */
@MappedSuperclass
public class NamedEntity extends BaseEntity {

    @Column(name = "name", nullable = false)
    protected String name;

    public NamedEntity() {
    }

    protected NamedEntity(Integer id, String name) {
        super(id);
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return name;
    }
}
