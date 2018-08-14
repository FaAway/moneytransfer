package com.faraway.moneytransfer.repository.jpa;

import com.faraway.moneytransfer.model.Account;
import com.faraway.moneytransfer.model.MoneyTransfer;
import com.faraway.moneytransfer.repository.MoneyTransferRepository;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.Collection;

/**
 * Created by пробная уч.запись on 14.08.2018.
 */
public class JpaMoneyTransferRepositoryImpl implements MoneyTransferRepository {

    private EntityManager em;

    public void setEntityManager(EntityManager entityManager) {
        this.em = entityManager;
    }

    @Override
    public MoneyTransfer save(MoneyTransfer moneyTransfer) {
        if (!moneyTransfer.isNew() && get(moneyTransfer.getId()) == null) {
            return null;
        }
        moneyTransfer.setSender(em.getReference(Account.class, moneyTransfer.getSender().getId()));
        moneyTransfer.setRecipient(em.getReference(Account.class, moneyTransfer.getRecipient().getId()));
        if (moneyTransfer.isNew()) {
            em.persist(moneyTransfer);
            return moneyTransfer;
        } else {
            return em.merge(moneyTransfer);
        }
    }

    @Override
    public MoneyTransfer get(int id) {
        return em.find(MoneyTransfer.class, id);
    }

    @Override
    public Collection<MoneyTransfer> getAll(int accountId) {
        return em.createNamedQuery(MoneyTransfer.ALL_BY_ACCOUNT_SORTED, MoneyTransfer.class)
                .setParameter("accountId", accountId)
                .getResultList();
    }

    @Override
    public Collection<MoneyTransfer> getBetween(LocalDateTime startDate, LocalDateTime endDate, int accountId) {
        return em.createNamedQuery(MoneyTransfer.GET_BETWEEN, MoneyTransfer.class)
                .setParameter("accountId", accountId)
                .setParameter("startDate", startDate)
                .setParameter("endDate", endDate).getResultList();
    }
}
