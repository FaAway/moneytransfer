package com.faraway.moneytransfer.service.impl;

import com.faraway.moneytransfer.model.Account;
import com.faraway.moneytransfer.model.Money;
import com.faraway.moneytransfer.model.MoneyTransfer;
import com.faraway.moneytransfer.repository.AccountRepository;
import com.faraway.moneytransfer.repository.MoneyTransferRepository;
import com.faraway.moneytransfer.repository.jpa.JpaAccountRepositoryImpl;
import com.faraway.moneytransfer.repository.jpa.JpaMoneyTransferRepositoryImpl;
import com.faraway.moneytransfer.service.FinanceService;
import com.faraway.moneytransfer.util.HibernateUtil;

import javax.persistence.EntityManager;

/**
 * User: mterentyev
 * Date: 13.08.2018
 */
public class FinanceServiceImpl implements FinanceService {

    private MoneyTransferRepository moneyTransferRepository;
    private AccountRepository accountRepository;

    @Override
    public boolean transferMoney(Account sender, Account recipient, Money money) {

        EntityManager em = HibernateUtil.getEm();
        sender = em.find(Account.class, sender.getId());
        recipient = em.find(Account.class, recipient.getId());

        // TODO: currency converter
        if (!sender.getCurrency().equals(recipient.getCurrency()) || !sender.getCurrency().equals(money.getCurrency())) {
            throw new UnsupportedOperationException("Currency converter is not supported yet");
        }
        MoneyTransfer moneyTransfer = new MoneyTransfer(sender, recipient, money.getAmount(), money.getAmount());
        sender.setAmount(sender.getAmount().subtract(moneyTransfer.getSourceCurrencyUnits()));
        recipient.setAmount(recipient.getAmount().add(moneyTransfer.getTargetCurrencyUnits()));

        assureRepositoryInitialized(em);
        em.getTransaction().begin();
        moneyTransferRepository.save(moneyTransfer);
        accountRepository.save(sender);
        accountRepository.save(recipient);
        em.getTransaction().commit();
        return true;
    }

    @Override
    public Account getAccountById(int id) {
        EntityManager em = HibernateUtil.getEm();
        assureRepositoryInitialized(em);
        return accountRepository.get(id);
    }

    private void assureRepositoryInitialized(EntityManager em) {
        if (accountRepository == null) {
            accountRepository = new JpaAccountRepositoryImpl();
        }
        if (moneyTransferRepository == null) {
            moneyTransferRepository = new JpaMoneyTransferRepositoryImpl();
        }
        accountRepository.setEntityManager(em);
        moneyTransferRepository.setEntityManager(em);
    }

}
