package com.faraway.moneytransfer.repository;

import com.faraway.moneytransfer.model.Account;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * User: mterentyev
 * Date: 14.08.2018
 */
public interface AccountRepository {
    Account save(Account account);

    // false if not found
    boolean delete(int id);

    // null if not found
    Account get(int id);

    List<Account> getAll();

    void setEntityManager(EntityManager em);
}
