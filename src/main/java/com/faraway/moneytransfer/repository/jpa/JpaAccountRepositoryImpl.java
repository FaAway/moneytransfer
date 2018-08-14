package com.faraway.moneytransfer.repository.jpa;

import com.faraway.moneytransfer.model.Account;
import com.faraway.moneytransfer.repository.AccountRepository;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by пробная уч.запись on 14.08.2018.
 */
public class JpaAccountRepositoryImpl implements AccountRepository {

    private EntityManager em;

    public void setEntityManager(EntityManager entityManager) {
        this.em = entityManager;
    }

    @Override
    public Account save(Account account) {
        if (account.isNew()) {
            em.persist(account);
            return account;
        } else {
            return em.merge(account);
        }
    }

    @Override
    public boolean delete(int id) {
        return em.createNamedQuery(Account.DELETE).setParameter("id", id).executeUpdate() != 0;
    }

    @Override
    public Account get(int id) {
        return em.find(Account.class, id);
    }

    @Override
    public List<Account> getAll() {
        return em.createNamedQuery(Account.ALL_SORTED, Account.class).getResultList();
    }
}
